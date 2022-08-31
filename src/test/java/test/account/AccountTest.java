package test.account;

import constants.Message;
import models.Account;
import org.testng.annotations.Test;
import test.BaseTest;
import utils.RandomData;

public class AccountTest extends BaseTest {

  @Test(description = "Create new account")
  public void testCreateNewAccount() {
    Account account = new Account(RandomData.accountName());

    /* @Step 1: Test Case flow; Expected: Validation success */
    navigationSteps.openLogInPage()
        .logIn()
        .navigate(navigationSteps).openNewAccountPage()
        .createAccountWithRequiredFields(account)
        .verify()
        .verifyNotification(Message.ACCOUNT_CREATED.formatted(account.getName()))
        .verifyAccount(account);
  }

  @Test(description = "Edit existed account")
  public void testEditExistedAccount() {
    Account account = new Account(RandomData.accountName());
    Account editAccount = new Account(RandomData.accountName());

    /* @Step 1: Test Case flow; Expected: Validation success */
    navigationSteps.openLogInPage()
        .logIn()
        .navigate(navigationSteps).openNewAccountPage()
        .createAccountWithRequiredFields(account)
        .clickEditButton()
        .editAccountWithRequiredFields(editAccount)
        .verify()
        .verifyNotification(Message.ACCOUNT_EDITED.formatted(account.getName()))
        .verifyAccount(editAccount);
  }
}
