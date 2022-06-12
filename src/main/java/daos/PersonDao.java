package daos;


import org.hibernate.SessionFactory;
import entities.Person;


public class PersonDao extends BasicCrudDao<Person> { //<--- rozszerzamy zdefiniowany przez nas interfejs
    public PersonDao(SessionFactory sessionFactory) {
        super(sessionFactory, Person.class, "Person");
    }
}