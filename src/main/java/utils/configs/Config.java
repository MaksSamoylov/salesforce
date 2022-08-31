package utils.configs;

import lombok.experimental.UtilityClass;
import org.aeonbits.owner.ConfigFactory;

@UtilityClass
public class Config {

  private static final Configuration CONFIG = ConfigFactory.create(Configuration.class, System.getProperties());

  public static final String BASE_URL = CONFIG.baseUrl();
  public static final String BROWSER = CONFIG.browser();
  public static final String BROWSER_SIZE = CONFIG.browserSize();
}
