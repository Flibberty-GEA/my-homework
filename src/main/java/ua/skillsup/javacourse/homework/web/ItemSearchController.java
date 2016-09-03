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

import ua.skillsup.javacourse.homework.application.ItemSearchService;
import ua.skillsup.javacourse.homework.application.EntityNotFoundException;
import ua.skillsup.javacourse.homework.domain.item.Item;

@Controller
@RequestMapping("/items")
public class ItemSearchController {

  @Inject
  private ItemSearchService itemSearchService;

  @RequestMapping(path = "/allItems", method = RequestMethod.GET)
  public String getAllBooks(Map<String, Object> model) {
    final List<Item> items = itemSearchService.findAllItems();

    model.put("items", items);

    return "all_items";
  }

  @RequestMapping(path = "/recommendations", method = RequestMethod.GET)
  public String getRecommendations(Map<String, Object> model) {
    final List<Item> items = itemSearchService.findItemsForTag("Java");

    model.put("items", items);

    return "items";
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.GET)
  public ModelAndView getItem(@PathVariable("id") Long id) throws EntityNotFoundException {
    SecurityContextHolder.getContext().getAuthentication();

    final Item item = itemSearchService.getItem(id);

    return new ModelAndView("item_view", "item", item);
  }
}
