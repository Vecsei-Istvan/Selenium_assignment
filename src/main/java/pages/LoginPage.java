package pages;
import org.openqa.selenium.By;

import config.ConfigReader;

public class LoginPage extends BasePage {
  private By email = By.id("email");
  private By pass  = By.id("password");
  private By submit= By.xpath("//button[text()='Login']");

  public void open() {
    driver.get(ConfigReader.get("base.url") + "/login");
  }
  public void login(String user, String pwd) {
    type(email, user);
    type(pass, pwd);
    click(submit);
  }
}