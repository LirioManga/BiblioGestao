package visitante;

import javax.swing.*;
import javax.swing.border.Border;
import home.Home;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class Visitante extends JPanel implements ActionListener{

     JPanel panelItens,panelHome,panelBibliotecarios,panelVisitantes;
    JPanel panelContent;
    JButton buttonHome, buttonLivros,buttonArtigos,buttonMonografias,buttonGitHub,buttonExit;
    CardLayout cardLayout;

    String status,nome;
    JFrame frame;

    public Visitante(String nome, String status, JFrame frame) {
        setLayout(new BorderLayout());
         this.nome = nome;
        this.status = status;
        this.frame = frame;
       
        cardLayout = new CardLayout();
        panelContent = new JPanel(cardLayout);
        panelContent.setBackground(Color.black);
        
        Livros livros = new Livros();
        Artigos artigos = new Artigos();
        Monografias monografias = new Monografias();
        GitHub gitHub = new GitHub();
        
        panelContent.add(livros,"livros");
        panelContent.add(artigos, "artigos");
        panelContent.add(monografias,"monografias");
        panelContent.add(gitHub,"github");
        
     
    
        add(panelInfoVisitante(),BorderLayout.NORTH);
        add(panelMenu(),BorderLayout.WEST);
        add(panelContent,BorderLayout.CENTER);
        System.out.println(nome + " "+ status);
    }

    public JPanel panelInfoVisitante(){
        JPanel panelInfo = new JPanel(new BorderLayout());
        


        Border linBorderPanelUser = BorderFactory.createLineBorder(new Color(0xBDC7E6), 2);

        JPanel userPanel = new JPanel();
        userPanel.setLayout(null);
        userPanel.setPreferredSize(new Dimension(150, 50));
        userPanel.setBackground(Color.WHITE);
        userPanel.setBorder(linBorderPanelUser);

        JLabel userLabel = new JLabel();
        userLabel.setBounds(15,5,100,20);
        userLabel.setText(nome);
        userPanel.add(userLabel);

        JLabel userStatus = new JLabel();
        userStatus.setBounds(25,20,90,20);
        userStatus.setText(status);
        userPanel.add(userStatus);

        JPanel panelMenuLabel = new JPanel();
        panelMenuLabel.setPreferredSize(new Dimension(150,50));
        panelMenuLabel.setBackground(Color.decode("#0D5FA6"));
        panelInfo.add(panelMenuLabel,BorderLayout.WEST);

        JLabel labelMenu = new JLabel();
        labelMenu.setText("Menu");
        labelMenu.setFont(new Font("Consola", Font.PLAIN, 20));
        panelMenuLabel.add(labelMenu);
        
    
        panelInfo.add(userPanel, BorderLayout.EAST);
        panelInfo.setBackground(Color.WHITE);
        panelInfo.setPreferredSize(new Dimension(1100, 40)); // Ajuste conforme necessário para o layout desejado
    
        
        return panelInfo;
    }

    public JPanel panelMenu(){
        panelItens = new JPanel();
        panelItens.setBackground(new Color(13, 95, 166));
        panelItens.setPreferredSize(new Dimension(150,600));
        panelItens.setLayout(new BoxLayout(panelItens,BoxLayout.Y_AXIS));


        Dimension buttonSize = new Dimension(150, 50);

      

        buttonLivros = new JButton("Livros");
        buttonLivros.setFocusable(false);
        buttonLivros.addActionListener(this);
        buttonLivros.setMaximumSize(buttonSize);


        buttonArtigos = new JButton("Artigos");
        buttonArtigos.setFocusable(false);
        buttonArtigos.addActionListener(this);
        buttonArtigos.setMaximumSize(buttonSize);

        buttonMonografias = new JButton("Monografias");
        buttonMonografias.setFocusable(false);
        buttonMonografias.addActionListener(this);
        buttonMonografias.setMaximumSize(buttonSize);

        buttonGitHub = new JButton("GitHub");
        buttonGitHub.setFocusable(false);
        buttonGitHub.addActionListener(this);
        buttonGitHub.setMaximumSize(buttonSize);

    

        buttonExit = new JButton("Sair");
        buttonExit.setFocusable(false);
        buttonExit.addActionListener(this);
        buttonExit.setMaximumSize(buttonSize);

       
        panelItens.add(Box.createVerticalStrut(10)); 
        panelItens.add(buttonLivros);
        panelItens.add(Box.createVerticalStrut(5));
        panelItens.add(buttonArtigos);
        panelItens.add(Box.createVerticalStrut(5));
        panelItens.add(buttonMonografias);
        panelItens.add(Box.createVerticalStrut(5));
        panelItens.add(buttonGitHub);
        panelItens.add(Box.createVerticalStrut(5));
        panelItens.add(buttonExit);

        return panelItens;
    }

     @Override
    public void actionPerformed(ActionEvent e){
         
        if (e.getSource() == buttonLivros) {
            cardLayout.show(panelContent, "livros");
        } else if (e.getSource() == buttonArtigos) {
            cardLayout.show(panelContent, "artigos");
        }else if(e.getSource() == buttonMonografias){
            cardLayout.show(panelContent, "monografias");
        }else if(e.getSource() == buttonGitHub){
            cardLayout.show(panelContent, "github");
            openWebpage("https://github.com/LirioManga/Repositorio");
        } else if (e.getSource() == buttonExit) {
           frame.dispose();
           new Home();
        }
    }

    private void openWebpage(String urlString) {
        try {
            URI uri = new URI(urlString);
            Desktop desktop = Desktop.getDesktop();
            desktop.browse(uri);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
