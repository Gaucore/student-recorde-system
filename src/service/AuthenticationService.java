package service;

import model.User;
import repository.UserRepository;

public class AuthenticationService {

    private UserRepository repository;

    public AuthenticationService() {
        repository = new UserRepository();
    }

    public boolean authenticate(String username, String password) {
        User user = repository.findUser(username);
        if (user == null) {
            return false;

        }

        return user.getPassword().equals(password);
    }

}
