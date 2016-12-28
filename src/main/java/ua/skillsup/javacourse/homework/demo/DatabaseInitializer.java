package ua.skillsup.javacourse.homework.demo;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.stream.Stream;

import javax.inject.Inject;

import lombok.extern.slf4j.Slf4j;
import ua.skillsup.javacourse.homework.domain.item.Item;
import ua.skillsup.javacourse.homework.domain.item.ItemRepo;
import ua.skillsup.javacourse.homework.domain.tag.Tag;
import ua.skillsup.javacourse.homework.domain.tag.TagRepo;
import ua.skillsup.javacourse.homework.domain.user.User;
import ua.skillsup.javacourse.homework.domain.user.UserRepo;

import static java.util.stream.Collectors.toList;

@Slf4j
@Component
public class DatabaseInitializer implements ApplicationListener<ContextRefreshedEvent> {

  //private static final Logger log = LoggerFactory.getLogger(DatabaseInitializer.class);


  @Inject
  private TagRepo tagRepo;

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
    initTags();
    initUsers();
    initItems();
  }

  private void initTags() {
    Stream.of("Java", "PHP", "OOP", "JavaScript", "Development")
        .map(Tag::new)
        .forEach(tagRepo::add);
  }


  private void initItems() {
    final User user  = userRepo.findByName("admin");
    final Item item1 = new Item();

    item1.setTitle("Title of item1 - кириллица");
    item1.setUser(user);
    item1.setSummary("Summary of item1");
    item1.setContent("Some content of item1");
    item1.setPublicationsDate(LocalDate.parse("2016-07-29"));
    item1.setTags(
      Stream.of("Java", "OOP")
          .map(tagRepo::getTag)
          .collect(toList())
    );
    user.addItem(item1);

    final Item item2 = new Item();
    item2.setTitle("Title of item2");
    item2.setUser(user);
    item2.setSummary("Summary of item2");
    item2.setContent("Some content of item2");
    item2.setPublicationsDate(LocalDate.parse("2016-08-08"));
    item2.setTags(
            Stream.of("Java", "Development")
                    .map(tagRepo::getTag)
                    .collect(toList())
    );
    user.addItem(item2);

    final Item item3 = new Item();
    item3.setTitle("Title of item3");
    item3.setUser(user);
    item3.setSummary("Summary of item3");
    item3.setContent("Some content of item3");
    item3.setPublicationsDate(LocalDate.now());
    item3.setTags(
            Stream.of("JavaScript")
                    .map(tagRepo::getTag)
                    .collect(toList())
    );
    user.addItem(item3);
  }

  private void initUsers() {
    final User user = new User();
    user.setUsername("user");
    user.setPassword(passwordEncoder.encode("pass"));
    user.setAdmin(false);
    user.setEnabled(true);

    userRepo.add(user);

    final User admin = new User();
    admin.setUsername("admin");
    admin.setPassword(passwordEncoder.encode("pass"));
    admin.setAdmin(true);
    admin.setEnabled(true);

    userRepo.add(admin);

  }
}
