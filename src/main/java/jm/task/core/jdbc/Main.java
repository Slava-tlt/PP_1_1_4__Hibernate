package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    private final static UserServiceImpl userServiceImpl = new UserServiceImpl();

    public static void main(String[] args) {

        userServiceImpl.createUsersTable();

        userServiceImpl.saveUser("Николай", "Козлов", (byte) 25);
        userServiceImpl.saveUser("Светлана", "Сидорова", (byte) 31);
        userServiceImpl.saveUser("Сергей", "Круглов", (byte) 43);
        userServiceImpl.saveUser("Игорь", "Романов", (byte) 18);

        userServiceImpl.removeUserById(3);

        userServiceImpl.getAllUsers();

        userServiceImpl.cleanUsersTable();

        userServiceImpl.dropUsersTable();

    }
}
