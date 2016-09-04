package ua.skillsup.javacourse.homework.domain.user;

import java.util.Optional;

import ua.skillsup.javacourse.homework.domain.Repo;

public interface UserRepo extends Repo<User> {
  User findByName(String name);
  Optional<User> getByName(String username);

}
