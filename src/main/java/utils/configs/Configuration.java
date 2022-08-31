package utils.configs;

import org.aeonbits.owner.Config;

@org.aeonbits.owner.Config.LoadPolicy(org.aeonbits.owner.Config.LoadType.MERGE)
@Config.Sources("classpath:env.properties")
public interface Configuration extends Config {

  @Config.Key("base.url")
  String baseUrl();

  @Key("browser")
  String browser();

  @Key("browser.size")
  String browserSize();
}
