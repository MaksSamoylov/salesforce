package elements;

/**
 * Link UI element and methods of working with it.
 */
public class Input extends UiBase {

  public Input clear() {
    getSelf().clear();
    return this;
  }

  public Input sendKeys(String text) {
    getSelf().sendKeys(text);
    return this;
  }
}
