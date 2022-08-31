package constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import models.ResourceType;
import models.User;

@Getter
@AllArgsConstructor
public enum UserResourceType implements ResourceType {

  USERS_YAML("test-users.yaml", User.class);

  private final String path;
  private final Class<User> clazz;
}
