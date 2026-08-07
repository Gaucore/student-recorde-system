package ui.component;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TitleLabel extends JLabel {
    public TitleLabel(String title) {

        super(title, SwingConstants.CENTER);

        setFont(new Font("Segoe UI", Font.BOLD, 28));

    }
}
