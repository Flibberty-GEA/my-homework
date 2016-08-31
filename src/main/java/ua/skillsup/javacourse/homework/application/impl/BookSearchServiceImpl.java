package ua.skillsup.javacourse.homework.application.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.inject.Inject;

import ua.skillsup.javacourse.homework.application.BookSearchService;
import ua.skillsup.javacourse.homework.application.EntityNotFoundException;
import ua.skillsup.javacourse.homework.domain.book.Author;
import ua.skillsup.javacourse.homework.domain.book.AuthorRepo;
import ua.skillsup.javacourse.homework.domain.book.Item;
import ua.skillsup.javacourse.homework.domain.book.ItemRepo;

@Service
@Transactional
public class BookSearchServiceImpl implements BookSearchService {

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
  public List<Author> findAuthor(String name) {
    return authorRepo.findByName(name);
  }

  // this method simply delegates the call to repository
  @Override
  public List<Item> findItemByTitle(String title) {return itemRepo.findItemByTitle(title);}

  // here we have some application related logic
  @Override
  public List<Item> findItemsForGenre(String genre) {return itemRepo.findItemsByGenre(genre, 5);}
}
