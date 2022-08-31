package steps;

import models.page.PageSteps;
import models.page.Verification;
import pages.HomePage;

public class HomePageSteps extends PageSteps<HomePageSteps, Verification<HomePageSteps, HomePage>, HomePage> {

  public HomePageSteps(HomePage page) {
    super.page = page;
  }
}
