package pages.login;

import annotations.PageUrl;
import com.codeborne.selenide.Selenide;
import elements.Button;
import elements.Input;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.BasePage;
import pages.HomePage;

@PageUrl("/")
public class LoginPage extends BasePage {

  @FindBy(how = How.ID, using = "username")
  private Input userNameInput;
  @FindBy(how = How.ID, using = "password")
  private Input passwordInput;
  @FindBy(how = How.ID, using = "Login")
  private Button logInButton;


  public void setUserNameInput(String userName) {
    userNameInput.sendKeys(userName);
  }

  public void setPasswordInput(String password) {
    passwordInput.sendKeys(password);
  }

  public HomePage clickLogInButton() {
    logInButton.click();
    return Selenide.page(HomePage.class);
  }
}
