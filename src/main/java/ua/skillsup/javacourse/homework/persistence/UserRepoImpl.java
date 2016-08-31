package ua.skillsup.javacourse.homework.persistence;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import ua.skillsup.javacourse.homework.domain.security.User;
import ua.skillsup.javacourse.homework.domain.security.UserRepo;

@Repository
public class UserRepoImpl extends GenericRepo<User> implements UserRepo {

  public UserRepoImpl() {
    super(User.class);
  }

  @Override
  public Optional<User> getByName(String username) {
    return findOneByField("username", username);
  }
}
