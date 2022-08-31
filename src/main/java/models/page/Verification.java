package models.page;

import lombok.AllArgsConstructor;
import pages.Page;

@AllArgsConstructor
public abstract class Verification<S extends PageSteps<S, ?, ?>, P extends Page> {

  private S steps;
  protected P page;

  public S backToSteps() {
    return steps;
  }
}
