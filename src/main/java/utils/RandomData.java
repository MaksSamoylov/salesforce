package utils;

import com.github.javafaker.Faker;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RandomData {

  private static final Faker FAKER = new Faker();

  public static String accountName() {
    return FAKER.book().title();
  }
}
