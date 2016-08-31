package ua.skillsup.javacourse.homework.persistence;

import org.springframework.stereotype.Repository;

import ua.skillsup.javacourse.homework.domain.author.Author;
import ua.skillsup.javacourse.homework.domain.author.AuthorRepo;

@Repository
public class AuthorRepoImpl extends GenericRepo<Author> implements AuthorRepo {

  public AuthorRepoImpl() {
    super(Author.class);
  }

  @Override
  public Author findByName(String name) {
    return findOneByField("name", name).orElse(null);
  }
}
