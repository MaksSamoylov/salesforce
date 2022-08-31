package steps.account;

import models.page.PageSteps;
import pages.account.AccountPage;
import verification.AccountPageVerification;

public class AccountPageSteps extends PageSteps<AccountPageSteps, AccountPageVerification, AccountPage> {

  public AccountPageSteps(AccountPage page) {
    super.verification = new AccountPageVerification(this, page);
    super.page = page;
  }

  public EditAccountPageSteps clickEditButton() {
    return new EditAccountPageSteps(page.clickEditButton());
  }
}
