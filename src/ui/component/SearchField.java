
package ui.component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class SearchField extends JTextField {

    public SearchField(int columns) {
        super(columns);

        setFont(new Font("Segoe UI", Font.PLAIN, 14));
        setPreferredSize(new Dimension(170, 38));
        setMaximumSize(new Dimension(170, 38));
        setBorder(new CompoundBorder(
                new LineBorder(new Color(210, 210, 210), 1, true),
                new EmptyBorder(6, 10, 6, 10)));
        setBackground(Color.WHITE);
    }

}