package ua.skillsup.javacourse.homework.persistence;

import org.springframework.stereotype.Repository;

import ua.skillsup.javacourse.homework.domain.genre.Genre;
import ua.skillsup.javacourse.homework.domain.genre.GenreRepo;

@Repository
public class GenreRepoImpl extends GenericRepo<Genre> implements GenreRepo {

  public GenreRepoImpl() {
    super(Genre.class);
  }

  @Override
  public Genre getGenre(String name) {
    return findOneByField("name", name).orElse(null);
  }
}
