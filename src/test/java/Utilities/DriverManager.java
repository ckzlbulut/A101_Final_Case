package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DriverManager {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public static WebDriver setupProcess() {

        // Lines 22 and 23 have been added for the texts that we do not want to appear in the console.
        Logger.getLogger("").setLevel(Level.SEVERE);
        System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Error");

        // On lines 26 and 38, we perform the driver setup process according to the options we want.
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("incognito", "acceptInsecureCerts", "ignore-certificate-errors", "allow-insecure-localhost"
                               , "--disable-blink-features=AutomationControlled", "--disable-extensions");

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
            wait = new WebDriverWait(DriverManager.setupProcess(), Duration.ofSeconds(30));
            driver.get("https://www.hepsiburada.com/");
            driver.manage().window().maximize();
        }
        return driver;
    }

    // In this method, the driver exit process is performed after the test.
    @AfterClass
    public static void quitDriver() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (driver != null) {
            driver.quit();
            driver = null;
            Log.info("Test finished.");
        }
    }

}













