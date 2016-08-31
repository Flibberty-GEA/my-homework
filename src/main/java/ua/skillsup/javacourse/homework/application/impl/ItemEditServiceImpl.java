package ua.skillsup.javacourse.homework.application.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Inject;

import ua.skillsup.javacourse.homework.application.ItemEditService;
import ua.skillsup.javacourse.homework.domain.author.Author;
import ua.skillsup.javacourse.homework.domain.author.AuthorRepo;
import ua.skillsup.javacourse.homework.domain.item.Item;
import ua.skillsup.javacourse.homework.domain.genre.Genre;
import ua.skillsup.javacourse.homework.domain.genre.GenreRepo;

@Service
@Transactional
public class ItemEditServiceImpl implements ItemEditService {

  @Inject
  private AuthorRepo authorRepo;

  @Inject
  private GenreRepo genreRepo;

  @Override
  @Transactional
  public Author createAuthor(String name) {
    final Author author = new Author();
    author.setName(name);

    authorRepo.add(author);
    return author;
  }

  public Item createItem(Long authorId, String title, String summary, Set<String> genres) {

    final Author author = authorRepo.getById(authorId).get();

    final Item item = new Item();
    item.setTitle(title);
    item.setSummary(summary);
    author.addItem(item);

    final Set<Genre> itemGenres = genres.stream().map(g -> {
      Genre genre = genreRepo.getGenre(g);
      if (genre == null) {
        genre = new Genre(g);
        genreRepo.add(genre);
      }
      return genre;
    }).collect(Collectors.toSet());

    item.setGenres(itemGenres);

    return item;
  }

  @Override
  public void quickAddItemAndAuthor(String title, String authorName) {

  }
}
