package ua.skillsup.javacourse.homework.demo;

import org.springframework.context.ApplicationListener; //
import org.springframework.context.event.ContextRefreshedEvent; //
import org.springframework.security.crypto.password.PasswordEncoder; //
import org.springframework.security.crypto.password.StandardPasswordEncoder; //
import org.springframework.stereotype.Component; //
import org.springframework.transaction.annotation.Transactional; //

import java.util.stream.Stream;

import javax.inject.Inject; //

import lombok.extern.slf4j.Slf4j; //
import ua.skillsup.javacourse.homework.domain.book.Author;
import ua.skillsup.javacourse.homework.domain.book.AuthorRepo; //
import ua.skillsup.javacourse.homework.domain.book.Item;
import ua.skillsup.javacourse.homework.domain.book.ItemRepo;
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

    initItems();
    initUsers();

//    initMagazines();
  }

  private void initGenres() {
    Stream.of("Fantasy", "Adventure", "Sci-fi", "Drama", "Utopia")
        .map(Genre::new)
        .forEach(genreRepo::add);
  }

  private void initItems() {
    final Author author = new Author();
    author.setName("John Ronald Reuel Tolkien");

    authorRepo.add(author);

    final Item item1 = new Item();
    item1.setTitle("The Lord of the Rings");
    item1.setSummary(
        "The Lord of the Rings is an epic high-fantasy novel written by English author J. R. R. Tolkien.");
    item1.setGenres(
        Stream.of("Fantasy", "Adventure")
            .map(genreRepo::getGenre)
            .collect(toSet())
    );

    author.addItem(item1);
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
