package ua.skillsup.javacourse.homework.domain;

import java.util.List;
import java.util.Optional;

public interface Repo<T> {

  Optional<T> getById(Long id);

  Optional<T> findOneByField(String field, String value);

  List<T> findWhereFieldLike(String field, String value);

  void add(T t);

  List<T> getAll();
}
