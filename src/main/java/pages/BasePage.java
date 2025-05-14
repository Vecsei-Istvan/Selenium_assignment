package pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.ConfigReader;
import drivers.DriverFactory;

public class BasePage {
  protected WebDriver driver = DriverFactory.getDriver();
  protected WebDriverWait wait = new WebDriverWait(
      driver, Duration.ofSeconds(
          Long.parseLong(ConfigReader.get("explicit.wait"))));

  protected WebElement waitFor(By locator) {
    return wait.until(
      ExpectedConditions.visibilityOfElementLocated(locator));
  }

  public String getTitle() { return driver.getTitle(); }

  public void click(By locator) { waitFor(locator).click(); }
  public void type(By locator, String text) {
    WebElement el = waitFor(locator);
    el.clear(); el.sendKeys(text);
  }
}