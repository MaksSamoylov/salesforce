package steps.account;

import models.Account;
import models.page.PageSteps;
import models.page.Verification;
import pages.account.NewAccountPage;
import utils.StepLogger;

public class NewAccountPageSteps extends
    PageSteps<NewAccountPageSteps, Verification<NewAccountPageSteps, NewAccountPage>, NewAccountPage> {

  public NewAccountPageSteps(NewAccountPage page) {
    super.page = page;
  }

  public AccountPageSteps createAccountWithRequiredFields(Account account) {
    StepLogger.info("Create account with '{}' name", account.getName());
    page.setAccountName(account.getName());
    return new AccountPageSteps(page.clickSaveButton());
  }
}
