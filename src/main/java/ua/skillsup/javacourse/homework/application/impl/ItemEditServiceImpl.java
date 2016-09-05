package ua.skillsup.javacourse.homework.application.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import ua.skillsup.javacourse.homework.application.ItemEditService;
import ua.skillsup.javacourse.homework.domain.item.Item;
import ua.skillsup.javacourse.homework.domain.tag.Tag;
import ua.skillsup.javacourse.homework.domain.user.User;
import ua.skillsup.javacourse.homework.domain.user.UserRepo;
import ua.skillsup.javacourse.homework.domain.tag.TagRepo;

@Service
@Transactional
public class ItemEditServiceImpl implements ItemEditService {

  @Inject
  private UserRepo userRepo;

  @Inject
  private TagRepo tagRepo;

  @Override
  @Transactional
  public User createUser(String username, String password) {
    final User user = new User();
    user.setUsername(username);
    user.setPassword(password);
    user.setAdmin(false);
    user.setEnabled(true);

    userRepo.add(user);
    return user;
  }

  public Item createItem(String username, String title, String summary, List<String> tags) {

    final User user = userRepo.findByName(username);

    final Item item = new Item();
    item.setTitle(title);
    item.setSummary(summary);
    item.setPublicationsDate(LocalDate.now()); //?
    item.setTags(tagRepo.getAll());//?
    user.addItem(item);

    final List<Tag> itemTags = tags.stream().map(t -> {
      Tag tag = tagRepo.getTag(t);
      if (tag == null) {
        tag = new Tag(t);
        tagRepo.add(tag);
      }
      return tag;
    }).collect(Collectors.toList());

    item.setTags(itemTags);

    return item;
  }

  @Override
  public void quickAddItemAndUser(String title, String username) {

  }
}
