package ui.component;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class TitleLabel extends JLabel {
    public TitleLabel(String text) {
        super(text);
        initialize();
    }

    private void initialize() {
        setFont(new Font("SansSerif", Font.BOLD, 28));
        setForeground(new Color(25, 118, 210));
        setHorizontalAlignment(CENTER);
    }
}
