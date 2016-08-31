package ua.skillsup.javacourse.homework.application.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.inject.Inject;

import ua.skillsup.javacourse.homework.application.EntityNotFoundException;
import ua.skillsup.javacourse.homework.application.ItemSearchService;
import ua.skillsup.javacourse.homework.domain.author.Author;
import ua.skillsup.javacourse.homework.domain.author.AuthorRepo;
import ua.skillsup.javacourse.homework.domain.item.Item;
import ua.skillsup.javacourse.homework.domain.item.ItemRepo;

@Service
@Transactional
public class ItemSearchServiceImpl implements ItemSearchService {

  @Inject
  private AuthorRepo authorRepo;

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

    return origItem;
  }

  @Override
  public Author findAuthor(String name) {
    return authorRepo.findByName(name);
  }

  @Override
  public List<Item> findAllItems() {return itemRepo.getAllItems();}

  @Override
  public List<Item> findItemByTitle(String title) {return itemRepo.findItemByTitle(title);}

  @Override
  public List<Item> findItemsForGenre(String genre) {return itemRepo.findItemsByGenre(genre, 5);}
}
