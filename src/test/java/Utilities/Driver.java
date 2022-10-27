package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Driver {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public  static WebDriver setupProcess() {

        // extend report türkçe bilg çalışmaması sebebiyle kondu
        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");

        Logger.getLogger("").setLevel(Level.SEVERE);
        System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Error");

        if ( driver == null) {

            ChromeOptions options=new ChromeOptions();
            options.addArguments("incognito","acceptInsecureCerts","ignore-certificate-errors","allow-insecure-localhost"
                                ,"--disable-blink-features=AutomationControlled","--disable-extensions");

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
            wait=new WebDriverWait(Driver.setupProcess(), Duration.ofSeconds(30));

            Log.info("Test started...");

            driver.get("https://www.hepsiburada.com/");
            Driver.setupProcess().manage().window().maximize();
        }
        return driver;
    }

    @AfterClass
    public static void quitDriver() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (driver != null) { // driver varsa
            driver.quit();
            driver = null;
            Log.info("Test finished.");
        }
    }

    public static void stay(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }






}
