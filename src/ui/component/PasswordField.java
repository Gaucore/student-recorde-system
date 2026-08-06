package ui.component;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPasswordField;

public class PasswordField extends JPasswordField {

    public PasswordField(int columns) {
        super(columns);
        initialize();
    }

    private void initialize() {
        setFont(new Font("SansSerif", Font.PLAIN, 15));
        setPreferredSize(new Dimension(250, 35));
    }

}
