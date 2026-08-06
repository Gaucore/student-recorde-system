package ui.component;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTextField;

public class FormTextField extends JTextField {

    public FormTextField(int columns) {
        super(columns);
        initialize();
    }

    private void initialize() {
        setFont(new Font("SansSerif", Font.PLAIN, 15));
        setPreferredSize(new Dimension(250, 35));
    }

}
