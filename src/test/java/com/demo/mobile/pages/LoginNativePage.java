package com.demo.mobile.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LoginNativePage {
    private AndroidDriver driver;

    // Localizadores nativos de My Demo App
    private By btnMenuLateral = AppiumBy.accessibilityId("View menu");
    private By opcionLoginMenu = AppiumBy.accessibilityId("Login Menu Item");
    private By inputUsuario = AppiumBy.id("com.saucelabs.mydemoapp.android:id/nameET");
    private By inputPassword = AppiumBy.id("com.saucelabs.mydemoapp.android:id/passwordET");
    private By btnLogin = AppiumBy.accessibilityId("Tap to login with given credentials");
    private By tituloProductos = AppiumBy.accessibilityId("title");

    public LoginNativePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void irALogin() {
        driver.findElement(btnMenuLateral).click();
        driver.findElement(opcionLoginMenu).click();
    }

    public void iniciarSesion(String usuario, String password) {
        driver.findElement(inputUsuario).sendKeys(usuario);
        driver.findElement(inputPassword).sendKeys(password);
        driver.findElement(btnLogin).click();
    }

    public boolean estaEnCatalogo() {
        return driver.findElement(tituloProductos).isDisplayed();
    }
}
