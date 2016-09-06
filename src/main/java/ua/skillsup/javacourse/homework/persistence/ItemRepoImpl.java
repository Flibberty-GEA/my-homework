package ua.skillsup.javacourse.homework.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.springframework.stereotype.Repository;

import ua.skillsup.javacourse.homework.domain.item.Item;
import ua.skillsup.javacourse.homework.domain.item.ItemRepo;
import ua.skillsup.javacourse.homework.domain.tag.Tag;
import ua.skillsup.javacourse.homework.domain.tag.TagRepo;
import ua.skillsup.javacourse.homework.domain.user.User;
import ua.skillsup.javacourse.homework.domain.user.UserRepo;

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

  @Inject
  private UserRepo userRepo;

  @Override
  public List<Item> getAllItems(){/*return getAll();*/

    return Util.castList(
            session.getCurrentSession()
                    .createQuery("FROM Item")
                    .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY)
                    .list());
  }

  @Override
  public List<Item> findItemByTitle (String title) {
/*    return findWhereFieldLike("title", title);*/
    // todo: check this for n+1 problem
            return Util.castList(
            session.getCurrentSession()
                    .createQuery("FROM Item i where i.title LIKE :title")
                    .setParameter("title", "%" + title + "%")
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
                                    "ORDER BY i.publicationsDate DESC")
                    .setParameter("t", tag)
                    .setMaxResults(limit)
                    .list()
    );
  }
  @Override
  public List<Item> findItemsByUsername(String username, int limit) {
    return Util.castList(
            session.getCurrentSession()
                    .createQuery(
                            "FROM Item i " +
                                    "WHERE :u = i.user.username " +
                                    "ORDER BY i.publicationsDate DESC")
                    .setParameter("u", username)
                    .setMaxResults(limit)
                    .list()
    );
  }
}
