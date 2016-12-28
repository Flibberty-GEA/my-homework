package ua.skillsup.javacourse.homework.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;

import ua.skillsup.javacourse.homework.application.ItemEditService;
import ua.skillsup.javacourse.homework.application.ItemSearchService;
import ua.skillsup.javacourse.homework.application.EntityNotFoundException;
import ua.skillsup.javacourse.homework.domain.item.Item;
import ua.skillsup.javacourse.homework.domain.tag.Tag;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping(path = "/admin")
public class AdminController {

  @Inject
  private ItemSearchService itemSearchService;

    @Inject
    private ItemEditService itemEditService;

  @RequestMapping(path = "items/{id}", method = RequestMethod.POST)
  public String updateItemAdmin(@ModelAttribute Item item) throws EntityNotFoundException {
    itemSearchService.updateItemInfo(item);
    return "redirect:/items/recommendations";
  }

  @RequestMapping(path = "items/{id}", method = RequestMethod.GET)
  public ModelAndView edit(@PathVariable("id") Long id) throws EntityNotFoundException {
    final Item item = itemSearchService.getItem(id);
    return new ModelAndView("item_edit", "item", item);
  }



}
