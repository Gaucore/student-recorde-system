package repository;

import model.User;

public class UserRepository {

    public User findUser(String username) {

        // Temporary data
        if (username.equals("admin")) {
            return new User("admin", "admin123", "ADMIN");
        }

        return null;
    }
}
