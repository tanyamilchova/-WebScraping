package org.example.driver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.DriverManager;

public class WebDriverSingleton {

    private static WebDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(WebDriverSingleton.class);
    private WebDriverSingleton(){
    }

public static synchronized WebDriver getDriver() {
    if (driver == null) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }
    return driver;
}

    public static void closeDriver(){
        if(driver != null){
            logger.info("Closing WebDriver.");
            driver.quit();
            driver = null;
        }
    }
}

