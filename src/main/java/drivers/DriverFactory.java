package drivers;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import config.ConfigReader;

public class DriverFactory {
  private static WebDriver driver;
  public static WebDriver getDriver() {
    if (driver == null) {
      ChromeOptions opts = new ChromeOptions();
      opts.addArguments("--disable-notifications");  // custom option
      driver = new ChromeDriver(opts);
      driver.manage().timeouts()
           .implicitlyWait(Duration.ofSeconds(
               Long.parseLong(ConfigReader.get("implicit.wait"))));
    }
    return driver;
  }
  public static void quit() {
    if (driver != null) driver.quit();
  }
}