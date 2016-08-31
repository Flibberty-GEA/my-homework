package ua.skillsup.javacourse.homework.domain.genre;

import ua.skillsup.javacourse.homework.domain.Repo;

public interface GenreRepo extends Repo<Genre> {

  Genre getGenre(String name);
}
