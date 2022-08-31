package verification;

import models.Account;
import models.page.Verification;
import org.assertj.core.api.Assertions;
import pages.account.AccountPage;
import steps.account.AccountPageSteps;
import utils.StepLogger;

public class AccountPageVerification extends Verification<AccountPageSteps, AccountPage> {

  public AccountPageVerification(AccountPageSteps steps, AccountPage page) {
    super(steps, page);
  }

  public AccountPageVerification verifyNotification(String message) {
    StepLogger.info("Verify notification '{}' message", message);
    Assertions.assertThat(page.getNotificationMessage()).as("Notification message is incorrect")
        .isEqualTo(message);
    return this;
  }

  public AccountPageVerification verifyAccount(Account account) {
    StepLogger.info("Verify account '{}' name", account.getName());
    Assertions.assertThat(page.getAccountNameText()).as("Account name is incorrect")
        .isEqualTo(account.getName());
    return this;
  }
}
