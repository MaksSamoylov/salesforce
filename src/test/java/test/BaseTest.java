package test;

import browser.Browser;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import steps.NavigationSteps;
import utils.configs.Config;

public abstract class BaseTest {

  protected final NavigationSteps navigationSteps = new NavigationSteps(Config.BASE_URL);

  @BeforeSuite(alwaysRun = true)
  protected void beforeSuite(ITestContext context) {
    Browser.setDefaultConfigurations();
  }
}
