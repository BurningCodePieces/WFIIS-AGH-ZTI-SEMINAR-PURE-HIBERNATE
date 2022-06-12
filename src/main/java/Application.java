
import entities.Class;
import org.hibernate.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import daos.*;
import entities.*;

public class Application {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try (SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory()) {
            ClassDao classDao = new ClassDao(sessionFactory);
            PersonDao personDao = new PersonDao(sessionFactory);
            try (Session session = sessionFactory.getCurrentSession()) {// <--- ręczne implementowanie sesji...
                Transaction tx = session.beginTransaction(); // <--- ręczne implementowanie transakcji...
                Class class1 = classDao.save(new Class("Laby z UM"));
                Person jacek = personDao.save(new Person("Jacek", "Jacek@gmail.com", class1));
                Person asia = personDao.save(new Person("Asia", "Asia@gmail.com",class1));
                tx.commit(); // <--- ręczne implementowanie transakcji...
            }
            try (Session session = sessionFactory.getCurrentSession()) {// <--- ręczne implementowanie sesji...
                session.beginTransaction();// <--- i znowu ręczne implementowanie transakcji...
                System.out.println("Classes");
                classDao.list().forEach(classObj -> System.out.println(classObj.getName()));
                System.out.println("Students");
                personDao.list().forEach(student -> System.out.println(student.getName()));
            }
        }
    }
}
