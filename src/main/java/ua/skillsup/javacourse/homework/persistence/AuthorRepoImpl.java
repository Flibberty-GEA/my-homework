package ua.skillsup.javacourse.homework.persistence;

import org.springframework.stereotype.Repository;

import java.util.List;

import ua.skillsup.javacourse.homework.domain.book.Author;
import ua.skillsup.javacourse.homework.domain.book.AuthorRepo;

@Repository
public class AuthorRepoImpl extends GenericRepo<Author> implements AuthorRepo {

  public AuthorRepoImpl() {
    super(Author.class);
  }

  @Override
  public List<Author> findByName(String name) {
    return findWhereFieldLike("name", name);
  }
}
