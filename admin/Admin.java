package admin;
import home.Frame;
import home.Home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Admin extends JPanel implements ActionListener{
    JPanel panelTitle,panelItens, panelContent;
    JLabel titleLabel;
    JButton bibliotecarioButton,visitanteButton, exitButton;
    CardLayout cardLayout;
    JFrame frameDispose;
    public Admin(Frame frame){
        frameDispose = frame;
        frame.getContentPane().removeAll();
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        panelTitle = new JPanel();
        panelTitle.setBackground(Color.GREEN);
        panelTitle.setPreferredSize(new Dimension(1100,100));
        panelTitle.setLayout(new FlowLayout(FlowLayout.CENTER,100,40));


        
        titleLabel = new JLabel("ADMIN");
        titleLabel.setFont(new Font("Consolas",Font.BOLD, 40));
        panelTitle.add(titleLabel);

        // PANEL DE Botoes
        panelItens = new JPanel();
        panelItens.setBackground(Color.magenta);
        panelItens.setPreferredSize(new Dimension(150,600));
        panelItens.setLayout(new BoxLayout(panelItens,BoxLayout.Y_AXIS));

        Dimension buttonSize = new Dimension(150, 50);

        bibliotecarioButton = new JButton("Bibliotecário");
        bibliotecarioButton.setFocusable(false);
        bibliotecarioButton.setMaximumSize(buttonSize);
        bibliotecarioButton.addActionListener(this);

        visitanteButton= new JButton("Visitantes");
        visitanteButton.setFocusable(false);
        visitanteButton.setMaximumSize(buttonSize);
        visitanteButton.addActionListener(this);


        exitButton = new JButton("Sair");
        exitButton.setFocusable(false);
        exitButton.setMaximumSize(buttonSize);
        exitButton.addActionListener(this);



        panelItens.add(Box.createVerticalStrut(10));
        panelItens.add(bibliotecarioButton);
        panelItens.add(Box.createVerticalStrut(5)); 
        panelItens.add(visitanteButton);
        panelItens.add(Box.createVerticalStrut(5));
        panelItens.add(exitButton);


          // panel dos cards
        cardLayout = new CardLayout();
        panelContent = new JPanel(cardLayout);
        panelContent.setBackground(Color.BLUE);

        Bibliotecarios bibliotecario = new Bibliotecarios();
        panelContent.add(bibliotecario, "bibliotecario");


        Visitantes visitantes = new Visitantes();
        panelContent.add(visitantes, "visitantes");

        // definicoes
        frame.add(panelTitle, BorderLayout.NORTH);
        frame.add(panelItens,BorderLayout.WEST);
        frame.add(panelContent,BorderLayout.CENTER);

        frame.repaint();
        frame.revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bibliotecarioButton) {
            cardLayout.show(panelContent, "bibliotecario");
        } else if (e.getSource() == visitanteButton) {
            cardLayout.show(panelContent, "visitantes");
        } else if (e.getSource() == exitButton) {
            frameDispose.dispose();
            new Home();
        }
    }
    
}
