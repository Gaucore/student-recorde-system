package ui;

import javax.swing.JFrame;

import config.AppConfig;

public abstract class BaseFrame extends JFrame {

    public BaseFrame(String title) {
        initialize(title);
    }

    private void initialize(String title) {
        setTitle(title);
        setSize(AppConfig.WINDOW_WIDTH, AppConfig.WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

}
