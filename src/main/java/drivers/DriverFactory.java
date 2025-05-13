package drivers;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import config.ConfigReader;

public class DriverFactory {
    private static WebDriver driver;
    public static WebDriver getDriver() {
        if(driver == null) {
            String browser = ConfigReader.get("browser");
            switch(browser) {
                case "chrome":
                    ChromeOptions opts = new ChromeOptions();
                    opts.addArguments("--disable-notifications");
                    driver = new ChromeDriver(opts);
                    break;
                case "firefox":
                    FirefoxOptions fopts = new FirefoxOptions();
                    driver = new FirefoxDriver(fopts);
                    break;
            }
            driver.manage().timeouts()
                  .implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader.get("implicit.wait"))));
        }
        return driver;
    }
    public static void quit() {
        if(driver != null) driver.quit();
    }
}