package ua.skillsup.javacourse.homework.domain.security;

import java.util.Optional;

import ua.skillsup.javacourse.homework.domain.Repo;

public interface UserRepo extends Repo<User> {

  Optional<User> getByName(String username);

}
