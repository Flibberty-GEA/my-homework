package ua.skillsup.javacourse.homework.web;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
  public String getAllItems(Map<String, Object> model) {
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

  @RequestMapping(path = "/search", method = RequestMethod.GET)
  public String searchItem(@RequestParam("title") String title, Map<String, Object> model) throws EntityNotFoundException {
    final List<Item> items = itemSearchService.findItemByTitle(title);
    model.put("items", items);
    return "search";
  }
}
