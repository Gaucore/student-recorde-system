package ui.component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPasswordField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class PasswordField extends JPasswordField {

    public PasswordField(int columns) {
        super(columns);
        initialize();
    }

    private void initialize() {

        setFont(new Font("Segoe UI", Font.PLAIN, 15));

        setPreferredSize(new Dimension(260, 40));

        Border line = new LineBorder(new Color(190, 190, 190), 1, true);

        Border padding = new EmptyBorder(8, 12, 8, 12);

        setBorder(new CompoundBorder(line, padding));

    }

}
