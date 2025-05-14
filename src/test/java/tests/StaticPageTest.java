package tests;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import drivers.DriverFactory;
import pages.StaticPage;

public class StaticPageTest {
  private StaticPage page;

  @BeforeClass
  public void setup() { page = new StaticPage(); }

  @Test
  public void verifyHomePageLoads() {
    page.open("/");
    assert page.hasElement(By.xpath("//div//a[@href='/somepath']"));
  }

  @AfterClass
  public void teardown() { DriverFactory.quit(); }
}