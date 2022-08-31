package pages.account;

import java.time.Duration;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import elements.Button;
import elements.Input;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.BasePage;

public abstract class AbstractAccountPage extends BasePage {

  @FindBy(how = How.XPATH, using = "//span[.='Account Name']/../..//input")
  private Input accountNameInput;
  @FindBy(how = How.CSS, using = "[title='Save']")
  private Button saveButton;

  public void setAccountName(String accountName) {
    accountNameInput.should(Condition.visible, Duration.ofSeconds(10));
    accountNameInput.clear().sendKeys(accountName);
  }

  public AccountPage clickSaveButton() {
    saveButton.click();
    return Selenide.page(AccountPage.class);
  }
}
