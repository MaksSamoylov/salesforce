package steps;

import models.User;
import models.page.PageSteps;
import pages.login.LoginPage;
import utils.UserProvider;
import verification.LogInPageVerification;

public class LogInPageSteps extends PageSteps<LogInPageSteps, LogInPageVerification, LoginPage> {

  private String baseUrl;

  public LogInPageSteps(LoginPage page, String baseUrl) {
    super.verification = new LogInPageVerification(this, page);
    super.page = page;
    this.baseUrl = baseUrl;
  }

  public HomePageSteps logIn() {
    return logIn(UserProvider.getUser());
  }

  public HomePageSteps logIn(User user) {
    page.setUserNameInput(user.getEmail());
    page.setPasswordInput(user.getPassword());
    return new HomePageSteps(page.clickLogInButton());
  }
}
