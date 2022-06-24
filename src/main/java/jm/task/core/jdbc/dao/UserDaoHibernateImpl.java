package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

import static jm.task.core.jdbc.util.Util.getSessionFactory;

public class UserDaoHibernateImpl implements UserDao {
    SessionFactory sessionFactory = getSessionFactory();

    public UserDaoHibernateImpl() {

    }

    Transaction transaction = null;

    @Override
    public void createUsersTable() {

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            session.createSQLQuery("CREATE TABLE IF NOT EXISTS users " +
                            "(id BIGINT PRIMARY KEY AUTO_INCREMENT, " +
                            "name VARCHAR(50), lastName VARCHAR(50), " +
                            "age TINYINT)")
                    .executeUpdate();

            session.getTransaction().commit();

        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void dropUsersTable() {

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            session.createSQLQuery("DROP TABLE IF EXISTS users")
                    .executeUpdate();

            session.getTransaction().commit();

        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            User user = new User(name, lastName, age);
            session.save(user);
            session.getTransaction().commit();

        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void removeUserById(long id) {

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            User user = session.get(User.class, id);
            session.delete(user);

            session.getTransaction().commit();

        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            users = session.createQuery("from User")
                    .getResultList();

            session.getTransaction().commit();

        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }

        return users;
    }

    @Override
    public void cleanUsersTable() {

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.createQuery("delete User ").executeUpdate();

            session.getTransaction().commit();

        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
}
