package daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class BasicCrudDao<T>{              // <---- Musimy sami DEFINIOWAĆ własne dao!
                                            // Spring Data JPA - jedyne, co robimy
                                            // to rozszerzamy gotowy interfejs, SDJPA dostarcza implementacje
    private final SessionFactory sessionFactory;
    private final Class<T> entityClass;
    private final String entityName;

    protected BasicCrudDao(SessionFactory sessionFactory, Class<T> entityClass, String entityName) {
        this.sessionFactory = sessionFactory;
        this.entityClass = entityClass;
        this.entityName = entityName;
    }

    public T save(T entity) {
        sessionFactory.getCurrentSession().save(entity); //<--- Ale przynajmniej możemy wywoływać
                                                         // gotowe funkcje CRUD na sesji hibernate
        return entity;
    }

    public void delete(T entity) {
        sessionFactory.getCurrentSession().delete(entity); //<--- Operacje te są właśnie implementacjami
                                                           // interfejsów definiowanych przez JPA
    }

    public T find(long id) {
        return sessionFactory.getCurrentSession().find(entityClass, id);
    }

    public List<T> list() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaQuery<T> query = session.getCriteriaBuilder().createQuery(entityClass);
        query.select(query.from(entityClass));
        return session.createQuery(query).getResultList();
    }
}