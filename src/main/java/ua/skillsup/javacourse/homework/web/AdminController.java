package ua.skillsup.javacourse.homework.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;

import ua.skillsup.javacourse.homework.application.ItemSearchService;
import ua.skillsup.javacourse.homework.application.EntityNotFoundException;
import ua.skillsup.javacourse.homework.domain.book.Item;

@Controller
@RequestMapping(path = "/admin")
public class AdminController {

  @Inject
  private ItemSearchService itemSearchService;

  @RequestMapping(path = "books/{id}", method = RequestMethod.POST)
  public String updateBook(@ModelAttribute Item item) throws EntityNotFoundException {
    itemSearchService.updateItemInfo(item);

    return "redirect:/books/recommendations";
  }

  @RequestMapping(path = "books/{id}", method = RequestMethod.GET)
  public ModelAndView edit(@PathVariable("id") Long id) throws EntityNotFoundException {
    final Item item = itemSearchService.getItem(id);

    return new ModelAndView("book_edit", "book", item);
  }
}
