package app;

import javax.swing.SwingUtilities;

import ui.LoginFrame;

public class Main {
    public static void main(String[] args) {
        // System.out.println("Student Record Storage System Started.");

        SwingUtilities.invokeLater(() -> {
            LoginFrame frame = new LoginFrame();
            frame.setVisible(true);
        });

    }
}