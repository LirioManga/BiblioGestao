package home;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URI;


public class Frame extends JFrame{
    JPanel mainPanel;
    CardLayout cardLayout;

    public Frame(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1100, 680);


        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        add(mainPanel);
        
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void addPanel(JPanel panel, String name) {
        mainPanel.add(panel, name);
        cardLayout.show(mainPanel, name);
    }

    public void showPanel(String name) {
        cardLayout.show(mainPanel, name);
    }
}
