package models.page;

import annotations.PageUrl;
import com.codeborne.selenide.Selenide;
import lombok.Getter;
import pages.Page;

public abstract class Navigation {

  @Getter
  private final String baseUrl;

  protected Navigation(String baseUrl) {
    this.baseUrl = baseUrl;
  }

  /**
   * Open page with formatted url dynamic parts.
   *
   * <p>PageUrl: 'https://example.com/id/%s' -> 'https://example.comx/id/555'<p/>.
   *
   * @param pageClass PageObject class
   * @param urlParams dynamic url parameters
   * @return PageObject class
   */
  protected <T extends Page> T openPage(Class<T> pageClass, Object... urlParams) {
    return Selenide.open(getPageUrl(pageClass, urlParams), pageClass);
  }

  private <T extends Page> String getPageUrl(Class<T> pageClass, Object... urlParams) {
    String pagePath = pageClass.getAnnotation(PageUrl.class).value();
    return baseUrl + pagePath.formatted(urlParams);
  }
}
