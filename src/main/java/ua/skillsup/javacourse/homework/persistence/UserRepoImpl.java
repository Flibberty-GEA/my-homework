package ua.skillsup.javacourse.homework.persistence;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import ua.skillsup.javacourse.homework.domain.user.User;
import ua.skillsup.javacourse.homework.domain.user.UserRepo;

@Repository
public class UserRepoImpl extends GenericRepo<User> implements UserRepo {

  public UserRepoImpl() {
    super(User.class);
  }
  @Override
  public User findByName(String username) {
    return findOneByField("username", username).orElse(null);
  }
  @Override
  public Optional<User> getByName(String username) {
    return findOneByField("username", username);
  }
}
