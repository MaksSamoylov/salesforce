package browser;

import com.codeborne.selenide.Configuration;
import lombok.experimental.UtilityClass;
import utils.configs.Config;

@UtilityClass
public class Browser {

  public static void setDefaultConfigurations() {
    Configuration.browser = Config.BROWSER;
    Configuration.browserSize = Config.BROWSER_SIZE;
  }
}
