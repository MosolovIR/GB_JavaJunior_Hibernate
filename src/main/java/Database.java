import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Database {
    public static void getConnection() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Person person = new Person("Антон", 25);
        session.beginTransaction();
        session.save(person);
        person = new Person("Андрей",37); session.save(person);
        person = new Person("Ольга",25); session.save(person);
        person = new Person("Иван",19); session.save(person);
        person = new Person("Виктория",21); session.save(person);
        session.getTransaction().commit();
        session.close();
    }
}
