package steps.account;

import models.Account;
import models.page.PageSteps;
import models.page.Verification;
import pages.account.EditAccountPage;
import utils.StepLogger;

public class EditAccountPageSteps extends
    PageSteps<EditAccountPageSteps, Verification<EditAccountPageSteps, EditAccountPage>, EditAccountPage>  {

  public EditAccountPageSteps(EditAccountPage page) {
    super.page = page;
  }

  public AccountPageSteps editAccountWithRequiredFields(Account account) {
    StepLogger.info("Edit account with '{}' name", account.getName());
    page.setAccountName(account.getName());
    return new AccountPageSteps(page.clickSaveButton());
  }
}
