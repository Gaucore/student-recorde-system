package app;

import controller.LoginController;

public class Test {

    public static void main(String[] args) {
        LoginController controller = new LoginController();

        System.out.println(controller.login("admin", "admin124"));
    }

}
