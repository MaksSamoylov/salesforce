package steps;

import models.page.Navigation;
import pages.account.NewAccountPage;
import pages.login.LoginPage;
import steps.account.NewAccountPageSteps;
import utils.StepLogger;

public class NavigationSteps extends Navigation {

  public NavigationSteps(String baseUrl) {
    super(baseUrl);
  }

  public LogInPageSteps openLogInPage() {
    StepLogger.info("Open 'Log In' page");
    return new LogInPageSteps(openPage(LoginPage.class), getBaseUrl());
  }

  public NewAccountPageSteps openNewAccountPage() {
    StepLogger.info("Open 'New Account' page");
    return new NewAccountPageSteps(openPage(NewAccountPage.class));
  }
}
