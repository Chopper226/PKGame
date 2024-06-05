package main;

import javax.swing.*;
import java.awt.*;

public class Interface extends JPanel {
    public Interface() {
        setPreferredSize(new Dimension(1280, 720));

        // Create button on Interface panel
        JButton switchButton = new JButton("Switch to Setting Panel");
        add(switchButton);
        
        // Add ActionListener to button
        switchButton.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) getParent().getLayout();
            cardLayout.show(getParent(), "panel2");
        });
    }
}
