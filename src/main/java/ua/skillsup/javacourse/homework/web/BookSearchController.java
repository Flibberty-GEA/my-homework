package ua.skillsup.javacourse.homework.web;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import ua.skillsup.javacourse.homework.application.BookSearchService;
import ua.skillsup.javacourse.homework.application.EntityNotFoundException;
import ua.skillsup.javacourse.homework.domain.book.Item;

@Controller
@RequestMapping("/books")
public class BookSearchController {

  @Inject
  private BookSearchService bookSearchService;

  @RequestMapping(path = "/allBooks", method = RequestMethod.GET)
  public String getAllBooks(Map<String, Object> model) {
    final List<Item> items = bookSearchService.findItemsForGenre("Fantasy");

    model.put("items", items);

    return "all_books";
  }

  @RequestMapping(path = "/recommendations", method = RequestMethod.GET)
  public String getRecommendations(Map<String, Object> model) {
    final List<Item> items = bookSearchService.findItemsForGenre("Fantasy");

    model.put("items", items);

    return "books";
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.GET)
  public ModelAndView getBook(@PathVariable("id") Long id) throws EntityNotFoundException {
    SecurityContextHolder.getContext().getAuthentication();

    final Item item = bookSearchService.getItem(id);

    return new ModelAndView("book_view", "book", item);
  }
}
