package pages;
import org.openqa.selenium.By;

public class FormPage extends BasePage {
  private By textInput = By.name("q");
  private By radioOpt  = By.xpath("//input[@type='radio' and @value='opt1']");
  private By checkBox  = By.xpath("//input[@type='checkbox']");
  private By submitBtn = By.xpath("//button[@type='submit']");

  public void fillAndSend(String text) {
    type(textInput, text);
    click(radioOpt);
    click(checkBox);
    click(submitBtn);
  }
}