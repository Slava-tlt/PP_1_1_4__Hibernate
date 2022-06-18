package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public interface UserService {

    void createUsersTable();

    List<User> getAllUsers();

    void saveUser(String name, String lastName, byte age);

    void removeUserById(long id);

    void cleanUsersTable();

    void dropUsersTable();

}
