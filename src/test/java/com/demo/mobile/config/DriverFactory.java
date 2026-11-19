package com.demo.mobile.config;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import java.time.Duration;
import java.util.Properties;

public class DriverFactory {

    public static AndroidDriver iniciarDriver() throws Exception {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) {
            props.load(fis);
        }

        File apk = new File(props.getProperty("app.path"));

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName(props.getProperty("platform.name"));
        options.setAutomationName(props.getProperty("automation.name"));
        options.setDeviceName(props.getProperty("device.name"));
        options.setApp(apk.getAbsolutePath());
        options.setAppWaitActivity(props.getProperty("app.waitActivity"));

        AndroidDriver driver = new AndroidDriver(new URI(props.getProperty("appium.url")).toURL(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
}
