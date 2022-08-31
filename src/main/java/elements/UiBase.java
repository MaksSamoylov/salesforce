package elements;

import java.time.Duration;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public abstract class UiBase extends ElementsContainer {

  public void click() {
    getSelf().click();
  }

  public String getText() {
    return getSelf().getText();
  }

  public boolean isDisplayed() {
    return getSelf().isDisplayed();
  }

  public UiBase should(Condition condition) {
    getSelf().should(condition);
    return this;
  }

  public UiBase should(Condition condition, Duration duration) {
    getSelf().should(condition, duration);
    return this;
  }

  public UiBase shouldNot(Condition condition) {
    getSelf().shouldNot(condition);
    return this;
  }

  public SelenideElement find(By selector) {
    return getSelf().find(selector);
  }
}
