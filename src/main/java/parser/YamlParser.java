package parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.yaml.snakeyaml.Yaml;

@UtilityClass
public class YamlParser {

  private static final Yaml YAML = new Yaml();

  public static <T> List<T> loadValuesFromMapFromResources(String yamlResource, Class<T> type) {
    return new ArrayList<>(loadAsMapFromResources(yamlResource, type).values());
  }

  @SneakyThrows(IOException.class)
  @SuppressWarnings("unchecked")
  public static <T> Map<String, T> loadAsMapFromResources(String yamlResource, Class<T> type) {
    try (InputStream inputStream = getResourceAsStream(yamlResource)) {
      return loadAsMap(YAML.loadAs(inputStream, Map.class), type);
    }
  }

  private static <T> Map<String, T> loadAsMap(Map<Object, Object> loadedMap, Class<T> classObj) {
    return loadedMap.entrySet().stream()
        .collect(Collectors.toMap(
            entry -> (String) entry.getKey(),
            entry -> objFromJson(entry.getValue(), classObj)));
  }

  private static InputStream getResourceAsStream(String yamlResource) {
    InputStream resourceAsStream = YamlParser.class.getClassLoader().getResourceAsStream(yamlResource);
    if (Objects.isNull(resourceAsStream)) {
      throw new IllegalArgumentException("Cannot load '%s' file".formatted(yamlResource));
    }
    return resourceAsStream;
  }

  private static <T> T objFromJson(Object obj, Class<T> classOfT) {
    Gson gsonSerializeNulls = new GsonBuilder().serializeNulls().create();
    return gsonSerializeNulls.fromJson(gsonSerializeNulls.toJson(obj), classOfT);
  }
}
