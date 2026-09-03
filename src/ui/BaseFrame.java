package ui;

import javax.swing.JFrame;

import config.AppConfig;

public abstract class BaseFrame extends JFrame {

    public BaseFrame(String title) {
        initialize(title);
    }

    private void initialize(String title) {
        setTitle(title);
        setSize(1400, 850);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
    }

}
