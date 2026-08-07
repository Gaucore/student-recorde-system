// package ui.component;

// import java.awt.Dimension;
// import java.awt.Font;

// import javax.swing.JTextField;
// import javax.swing.border.EmptyBorder;

// public class FormTextField extends JTextField {

//     public FormTextField(int columns) {
//         super(columns);
//         initialize();
//     }

//     private void initialize() {
//         setFont(new Font("Segoe UI", Font.PLAIN, 15));
//         setBorder(new EmptyBorder(8, 10, 8, 10));
//     }

// }

package ui.component;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class FormTextField extends JTextField {

    public FormTextField(int columns) {
        super(columns);
        initialize();
    }

    private void initialize() {

        setFont(new Font("Segoe UI", Font.PLAIN, 15));

        setPreferredSize(new Dimension(260, 40));

        Border line = new LineBorder(new Color(190, 190, 190), 1, true);

        Border padding = new EmptyBorder(8, 12, 8, 12);

        setBorder(new CompoundBorder(line, padding));

        setBackground(Color.WHITE);

    }

}