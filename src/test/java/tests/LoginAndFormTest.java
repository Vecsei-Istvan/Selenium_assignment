package tests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import drivers.DriverFactory;
import pages.FormPage;
import pages.LoginPage;

public class LoginAndFormTest {
  private LoginPage login;  private FormPage form;

  @BeforeClass
  public void setup() {
    login = new LoginPage();
    form  = new FormPage();
  }

  @Test
  public void loginAndSubmitForm() {
    login.open();
    login.login("user@example.com", "password");
    form.fillAndSend("Test input via complex xpath");
    // verify submission by checking title
    assert form.getTitle().contains("Result");
  }

  @AfterClass
  public void teardown() { DriverFactory.quit(); }
}