package pages.account;

import java.time.Duration;

import annotations.PageUrl;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import elements.Button;
import elements.Label;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.BasePage;

@PageUrl("/lightning/r/Account/%s/view")
public class AccountPage extends BasePage {

  @FindBy(how = How.XPATH, using = "//span[.='Account Name']/ancestor::div[contains(@class,'slds-form-element')]//*[@slot='outputField']")
  private Label accountNameLabel;
  @FindBy(how = How.CSS, using = "[name='Edit']")
  private Button editButton;

  public String getAccountNameText() {
    return accountNameLabel.should(Condition.visible, Duration.ofSeconds(10)).getText();
  }

  public EditAccountPage clickEditButton() {
    editButton.click();
    return Selenide.page(EditAccountPage.class);
  }
}
