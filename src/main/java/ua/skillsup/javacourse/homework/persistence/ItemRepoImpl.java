package ua.skillsup.javacourse.homework.persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ua.skillsup.javacourse.homework.domain.item.Item;
import ua.skillsup.javacourse.homework.domain.item.ItemRepo;
import ua.skillsup.javacourse.homework.domain.tag.Tag;
import ua.skillsup.javacourse.homework.domain.tag.TagRepo;

import javax.inject.Inject;
import java.util.List;

@Repository
public class ItemRepoImpl extends GenericRepo<Item> implements ItemRepo {

  public ItemRepoImpl() {
    super(Item.class);
  }

  @Inject
  private SessionFactory session;

  @Inject
  private TagRepo tagRepo;

  @Override
  public List<Item> getAllItems(){return getAll();}

  @Override
  public List<Item> findItemByTitle (String title) {
    // todo: check this for n+1 problem
            return Util.castList(
            session.getCurrentSession()
                    .createQuery("FROM Item i where i.title LIKE :nm")
                    .setParameter("nm", "%" + title + "%")
                    .list());
  }

  @Override
  public List<Item> findItemsByTag(String tagName, int limit) {
    final Tag tag = tagRepo.getTag(tagName);

    return Util.castList(
            session.getCurrentSession()
                    .createQuery(
                            "FROM Item i " +
                                    "WHERE :t member of i.tags " +
                                    "ORDER BY i.id")
                    .setParameter("t", tag)
                    .setMaxResults(limit)
                    .list()
    );
  }
}
