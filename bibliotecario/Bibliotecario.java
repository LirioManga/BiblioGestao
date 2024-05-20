package bibliotecario;
import home.Frame;
import home.Home;

import javax.swing.*;

import admin.Bibliotecarios;
import biblioteca.ArtigosPanel;
import biblioteca.GitHubPanel;
import biblioteca.LivrosPanel;
import biblioteca.MonografiaPanel;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Bibliotecario extends JPanel implements ActionListener{
    JPanel panelTitle,panelItens, panelContent;
    JLabel titleLabel;
    JButton livrosButton,artigosButton,monografiaButton,gitHButton, aboutButton, exitButton;
    CardLayout cardLayout;
    JFrame frameDispose;

    public Bibliotecario(Frame frame){
        frameDispose = frame;
        frame.getContentPane().removeAll();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        panelTitle = new JPanel();
        panelTitle.setBackground(Color.GREEN);
        panelTitle.setPreferredSize(new Dimension(1100,100));
        panelTitle.setLayout(new FlowLayout(FlowLayout.CENTER,100,40));

        titleLabel = new JLabel("BIBLIOTECARIO");
        titleLabel.setFont(new Font("Consolas",Font.BOLD, 40));
        panelTitle.add(titleLabel);

        
        // Panel dos botoes
        panelItens = new JPanel();
        panelItens.setBackground(Color.magenta);
        panelItens.setPreferredSize(new Dimension(150,600));
        panelItens.setLayout(new BoxLayout(panelItens,BoxLayout.Y_AXIS));


        Dimension buttonSize = new Dimension(150, 50);

        livrosButton = new JButton("Livros");
        livrosButton.setFocusable(false);
        livrosButton.setMaximumSize(buttonSize);

        artigosButton = new JButton("Artigos");
        artigosButton.setFocusable(false);
        artigosButton.setMaximumSize(buttonSize);


        monografiaButton = new JButton("Monografias");
        monografiaButton.setFocusable(false);
        monografiaButton.setMaximumSize(buttonSize);

        gitHButton = new JButton("GitHub");
        gitHButton.setFocusable(false);
        gitHButton.setMaximumSize(buttonSize);

        exitButton = new JButton("Sair");
        exitButton.setFocusable(false);
        exitButton.setMaximumSize(buttonSize);



        panelItens.add(Box.createVerticalStrut(10));
        panelItens.add(livrosButton);
        panelItens.add(Box.createVerticalStrut(5)); // Espaçamento entre os botões
        panelItens.add(artigosButton);
        panelItens.add(Box.createVerticalStrut(5));
        panelItens.add(monografiaButton);
        panelItens.add(Box.createVerticalStrut(5));
        panelItens.add(gitHButton);
        panelItens.add(Box.createVerticalStrut(5));
        panelItens.add(exitButton);

            // panel dos cards
        cardLayout = new CardLayout();
        panelContent = new JPanel(cardLayout);
        panelContent.setBackground(Color.BLUE);
     
    
        
        Bibliotecarios bibliotecario = new Bibliotecarios();
        bibliotecario.updatePanel();
        panelContent.add(bibliotecario, "Livros");

        ArtigosPanel artigosPanel = new ArtigosPanel();
        //artigosPanel.updatePanel();
        panelContent.add(artigosPanel, "Artigos");    

        MonografiaPanel monografiaPanel = new MonografiaPanel();
        panelContent.add(monografiaPanel, "Monografias");
        

        GitHubPanel gitHPanel = new GitHubPanel();
        panelContent.add(gitHPanel, "GitHub");


        livrosButton.addActionListener(this);
        artigosButton.addActionListener(this);
        monografiaButton.addActionListener(this);
        gitHButton.addActionListener(this);
        exitButton.addActionListener(this);

         // definicoes
         frame.add(panelTitle, BorderLayout.NORTH);
         frame.add(panelItens,BorderLayout.WEST);
         frame.add(panelContent,BorderLayout.CENTER);
 
         frame.repaint();
         frame.revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == livrosButton) {
            cardLayout.show(panelContent, "Livros");
        } else if (e.getSource() == artigosButton) {
            cardLayout.show(panelContent, "Artigos");
        } else if (e.getSource() == monografiaButton) {
            cardLayout.show(panelContent, "Monografias");
        } else if (e.getSource() == gitHButton) {
            cardLayout.show(panelContent, "GitHub");
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }


    // public static void main(String[] args) {
    //     new Bibliotecario(new Frame());
    // }
}
