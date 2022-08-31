package verification;

import models.page.Verification;
import pages.login.LoginPage;
import steps.LogInPageSteps;

public class LogInPageVerification extends Verification<LogInPageSteps, LoginPage> {

  public LogInPageVerification(LogInPageSteps steps, LoginPage page) {
    super(steps, page);
  }
}
