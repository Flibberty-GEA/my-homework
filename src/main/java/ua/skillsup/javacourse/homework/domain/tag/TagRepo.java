package ua.skillsup.javacourse.homework.domain.tag;

import ua.skillsup.javacourse.homework.domain.Repo;

public interface TagRepo extends Repo<Tag> {

  Tag getTag(String name);
}
