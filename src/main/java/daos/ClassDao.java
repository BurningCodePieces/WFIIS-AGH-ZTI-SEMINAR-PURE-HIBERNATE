package daos;

import org.hibernate.SessionFactory;
import entities.Class;


public class ClassDao extends BasicCrudDao<Class> {
    public ClassDao(SessionFactory sessionFactory) {
        super(sessionFactory, Class.class, "Class");
    }
}