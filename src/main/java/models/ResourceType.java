package models;

public interface ResourceType {

  String getPath();

  <T> Class<T> getClazz();
}
