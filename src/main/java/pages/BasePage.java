package pages;

import java.time.Duration;

import com.codeborne.selenide.Condition;
import elements.Label;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BasePage implements Page {

  @FindBy(how = How.CLASS_NAME, using = "forceActionsText")
  private Label notification;

  public String getNotificationMessage() {
    return notification.should(Condition.visible, Duration.ofSeconds(10)).getText();
  }
}
