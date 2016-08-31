package ua.skillsup.javacourse.homework.demo;

import org.springframework.context.ApplicationListener; //
import org.springframework.context.event.ContextRefreshedEvent; //
import org.springframework.security.crypto.password.PasswordEncoder; //
import org.springframework.security.crypto.password.StandardPasswordEncoder; //
import org.springframework.stereotype.Component; //
import org.springframework.transaction.annotation.Transactional; //

import java.time.LocalDate;
import java.util.stream.Stream;

import javax.inject.Inject; //

import lombok.extern.slf4j.Slf4j; //
import ua.skillsup.javacourse.homework.domain.author.Author;
import ua.skillsup.javacourse.homework.domain.author.AuthorRepo; //
import ua.skillsup.javacourse.homework.domain.item.Item;
import ua.skillsup.javacourse.homework.domain.item.ItemRepo;
import ua.skillsup.javacourse.homework.domain.genre.Genre;
import ua.skillsup.javacourse.homework.domain.genre.GenreRepo; //
import ua.skillsup.javacourse.homework.domain.security.User;
import ua.skillsup.javacourse.homework.domain.security.UserRepo; //

import static java.util.stream.Collectors.toSet;

@Slf4j
@Component
public class DatabaseInitializer implements ApplicationListener<ContextRefreshedEvent> {

  //private static final Logger log = LoggerFactory.getLogger(DatabaseInitializer.class);

  @Inject
  private AuthorRepo authorRepo;

  @Inject
  private GenreRepo genreRepo;

  @Inject
  private ItemRepo itemRepo;

  @Inject
  private UserRepo userRepo;

  private final PasswordEncoder passwordEncoder =
      new StandardPasswordEncoder();

  @Override
  @Transactional
  public void onApplicationEvent(ContextRefreshedEvent event) {
    log.info(" --- app ctx started!");
    initDb();
  }

  private void initDb() {
    initGenres();
      initAuthors();
    initItems();
    initUsers();

//    initMagazines();
  }

  private void initGenres() {
    Stream.of("Fantasy", "Adventure", "Sci-fi", "Drama", "Utopia")
        .map(Genre::new)
        .forEach(genreRepo::add);
  }

    private void initAuthors() {
        final Author author = new Author();
        author.setName("John");
        authorRepo.add(author);
    }

  private void initItems() {
      final Author author  = authorRepo.findByName("John");
    final Item item1 = new Item();

      item1.setTitle("Title of item1");
      item1.setAuthor(author);
      item1.setSummary("Summary of item1");
      item1.setGenres(
        Stream.of("Fantasy", "Adventure")
            .map(genreRepo::getGenre)
            .collect(toSet())
      );
      author.addItem(item1);

      final Item item2 = new Item();
      item2.setTitle("Title of item2");
      item2.setAuthor(author);
      item2.setSummary("Summary of item2");
      item2.setGenres(
              Stream.of("Fantasy", "Adventure")
                      .map(genreRepo::getGenre)
                      .collect(toSet())
      );
      author.addItem(item2);

      final Item item3 = new Item();
      item3.setTitle("Title of item3");
      item3.setAuthor(author);
      item3.setSummary("Summary of item3");
      item3.setGenres(
              Stream.of("Fantasy", "Adventure")
                      .map(genreRepo::getGenre)
                      .collect(toSet())
      );
      author.addItem(item3);
  }

  private void initUsers() {
    final User user = new User();
    user.setUsername("user1");
    user.setPassword(passwordEncoder.encode("userpass123"));
    user.setAdmin(false);
    user.setEnabled(true);

    userRepo.add(user);

    final User admin = new User();
    admin.setUsername("admin1");
    admin.setPassword(passwordEncoder.encode("adminpass123"));
    admin.setAdmin(true);
    admin.setEnabled(true);

    userRepo.add(admin);

  }
}
