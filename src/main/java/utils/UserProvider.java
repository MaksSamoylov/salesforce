package utils;

import java.util.List;

import constants.UserResourceType;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import models.User;
import parser.YamlParser;

@RequiredArgsConstructor
public enum UserProvider {

  USERS(read(UserResourceType.USERS_YAML));

  @NonNull @Getter
  private final List<User> users;

  public static User getUser() {
    return USERS.getFirstUser();
  }

  public User getFirstUser() {
    return users.stream()
        .findFirst()
        .orElseThrow(() -> new RuntimeException("No valid user"));
  }

  private static List<User> read(UserResourceType userResourceType) {
    List<User> users = YamlParser.loadValuesFromMapFromResources(userResourceType.getPath(), userResourceType.getClazz());
    if (users.isEmpty()) {
      throw new RuntimeException(userResourceType.getPath());
    }
    return users;
  }
}
