package ua.skillsup.javacourse.homework.persistence;

import java.util.List;

final class Util {

  private Util() {
  }

  @SuppressWarnings("unchecked")
  static <T> List<T> castList(List list) {
    return list;
  }

  @SuppressWarnings("unchecked")
  static <T> T cast(Object o) {
    return (T) o;
  }
}
