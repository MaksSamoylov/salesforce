package utils;

import lombok.experimental.UtilityClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@UtilityClass
public class StepLogger {

  private static final Logger LOGGER = LoggerFactory.getLogger(StepLogger.class);

  public static String info(String stepMessage) {
    LOGGER.info(stepMessage);
    return stepMessage;
  }

  public static String info(String stepMessage, Object... arguments) {
    LOGGER.info(stepMessage, arguments);
    return stepMessage.formatted(arguments);
  }
}
