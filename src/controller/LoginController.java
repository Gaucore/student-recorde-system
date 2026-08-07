package controller;

import service.AuthenticationService;

public class LoginController {

    private AuthenticationService service;

    public LoginController() {
        service = new AuthenticationService();
    }

    public boolean login(String username, String password) {
        return service.authenticate(username, password);
    }

}
