package pages;
import org.openqa.selenium.By;

import config.ConfigReader;

public class StaticPage extends BasePage {
  public void open(String path) {
    driver.get(ConfigReader.get("base.url") + path);
  }
  public boolean hasElement(By locator) {
    return !driver.findElements(locator).isEmpty();
  }
}