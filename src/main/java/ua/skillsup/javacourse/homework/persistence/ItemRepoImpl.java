package ua.skillsup.javacourse.homework.persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ua.skillsup.javacourse.homework.domain.item.Item;
import ua.skillsup.javacourse.homework.domain.item.ItemRepo;
import ua.skillsup.javacourse.homework.domain.genre.Genre;
import ua.skillsup.javacourse.homework.domain.genre.GenreRepo;

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
  private GenreRepo genreRepo;

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
  public List<Item> findItemsByGenre(String genreName, int limit) {
    final Genre genre = genreRepo.getGenre(genreName);

    return Util.castList(
            session.getCurrentSession()
                    .createQuery(
                            "FROM Item i " +
                                    "WHERE :g member of i.genres " +
                                    "ORDER BY i.id")
                    .setParameter("g", genre)
                    .setMaxResults(limit)
                    .list()
    );


  }
}
