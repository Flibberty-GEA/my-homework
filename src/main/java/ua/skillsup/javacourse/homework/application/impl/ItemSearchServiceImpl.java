package ua.skillsup.javacourse.homework.application.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.skillsup.javacourse.homework.application.EntityNotFoundException;
import ua.skillsup.javacourse.homework.application.ItemSearchService;
import ua.skillsup.javacourse.homework.domain.item.Item;
import ua.skillsup.javacourse.homework.domain.item.ItemRepo;
import ua.skillsup.javacourse.homework.domain.user.User;
import ua.skillsup.javacourse.homework.domain.user.UserRepo;

@Service
@Transactional
public class ItemSearchServiceImpl implements ItemSearchService {

  @Inject
  private UserRepo userRepo;

  @Inject
  private ItemRepo itemRepo;

  public Item getItem(Long id) throws EntityNotFoundException {
    return itemRepo.getById(id).orElseThrow(
        (() -> new EntityNotFoundException("Item with ID " + id + " not found")));
  }

  @Override
  public Item updateItemInfo(Item item) throws EntityNotFoundException {
    final Item origItem = getItem(item.getId());
    origItem.setTitle(item.getTitle());
    origItem.setSummary(item.getSummary());
/*    origItem.setPublicationsDate(LocalDate.now());*/

    return origItem;
  }

  @Override
  public User findUser(String username) {
    return userRepo.findByName(username);
  }

  @Override
  public List<Item> findAllItems() {return itemRepo.getAllItems();}

  @Override
  public List<Item> findItemByTitle(String title) {return itemRepo.findItemByTitle(title);}

  @Override
  public List<Item> findItemsForTag(String tag) {return itemRepo.findItemsByTag(tag, 10);}

  @Override
  public List<Item> findItemsForUsername(String username){return itemRepo.findItemsByUsername(username, 10);}


}
