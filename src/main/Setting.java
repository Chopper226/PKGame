package main;

import javax.swing.*;
import java.awt.*;

public class Setting extends JPanel {
    public Setting() {
        setPreferredSize(new Dimension(400, 300));

        // Create button on Setting panel
        JButton switchButton = new JButton("Switch to Interface Panel");
        add(switchButton);
        
        // Add ActionListener to button
        switchButton.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) getParent().getLayout();
            cardLayout.show(getParent(), "panel1");
        });
    }
}
