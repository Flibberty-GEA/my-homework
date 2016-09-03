package ua.skillsup.javacourse.homework.persistence;

import org.springframework.stereotype.Repository;

import ua.skillsup.javacourse.homework.domain.tag.Tag;
import ua.skillsup.javacourse.homework.domain.tag.TagRepo;

@Repository
public class TagRepoImpl extends GenericRepo<Tag> implements TagRepo {

  public TagRepoImpl() {
    super(Tag.class);
  }

  @Override
  public Tag getTag(String name) {
    return findOneByField("name", name).orElse(null);
  }
}
