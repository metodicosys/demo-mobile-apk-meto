package com.demo.mobile.tests;

import com.demo.mobile.config.DriverFactory;
import com.demo.mobile.pages.LoginNativePage;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginNativeTest {
    private AndroidDriver driver;

    @BeforeEach
    public void configurar() throws Exception {
        driver = DriverFactory.iniciarDriver();
    }

    @Test
    public void debeIniciarSesionExitosamenteEnAppNativa() {
        LoginNativePage loginPage = new LoginNativePage(driver);

        // 1. Navegar al formulario de Login desde el menú hamburguesa
        loginPage.irALogin();

        // 2. Ingresar credenciales de prueba válidas de Sauce Labs My Demo App
        loginPage.iniciarSesion("bod@example.com", "10203040");

        // 3. Validar (Assert) que ingresó al catálogo principal
        Assertions.assertTrue(
                loginPage.estaEnCatalogo(),
                "Error: No se mostró el catálogo de productos después de iniciar sesión"
        );
    }

    @AfterEach
    public void cerrar() {
        if (driver != null) {
            driver.quit();
        }
    }
}
