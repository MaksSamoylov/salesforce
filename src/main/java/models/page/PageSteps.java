package models.page;

import pages.Page;

public abstract class PageSteps<S extends PageSteps<S, V, P>, V extends Verification<S, P>, P extends Page> {

  protected V verification;
  protected P page;

  public V verify() {
    return verification;
  }

  public <T extends Navigation> T navigate(T navigationSteps) {
    return navigationSteps;
  }
}
