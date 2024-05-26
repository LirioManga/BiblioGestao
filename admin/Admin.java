package admin;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

public class Admin extends JPanel implements ActionListener{
    JPanel panelItens,panelHome,panelBibliotecarios,panelVisitantes;
    JPanel panelContent;
    JButton buttonHome,buttonBibliotecario, buttonVisitante,buttonExit;

    CardLayout cardLayout;
    String nome,status;


    public Admin(String nome,String status,JFrame frame) {
        this.nome = nome;
        this.status = status;
        setLayout(new BorderLayout());
       
        cardLayout = new CardLayout();
        panelContent = new JPanel(cardLayout);
        panelContent.setBackground(Color.black);
        
        AdminHome home = new AdminHome();
        Visitantes visitantes = new Visitantes();
        Bibliotecarios bibliotecarios = new Bibliotecarios();

        panelContent.add(home,"home");
        panelContent.add(bibliotecarios, "bibliotecarios");
        panelContent.add(visitantes,"visitantes");
     
    
        add(panelInfoAdmin(),BorderLayout.NORTH);
        add(panelMenu(),BorderLayout.WEST);
        add(panelContent,BorderLayout.CENTER);
        System.out.println(nome + " "+ status);

      
    }

    public JPanel panelMenu(){
        panelItens = new JPanel();
        panelItens.setBackground(new Color(13, 95, 166));
        panelItens.setPreferredSize(new Dimension(150,600));
        panelItens.setLayout(new BoxLayout(panelItens,BoxLayout.Y_AXIS));


        Dimension buttonSize = new Dimension(150, 50);

        buttonHome = new JButton("Home");
        buttonHome.setFocusable(false);
        buttonHome.addActionListener(this);
        buttonHome.setMaximumSize(buttonSize);

        buttonBibliotecario = new JButton("Bibliotecarios");
        buttonBibliotecario.setFocusable(false);
        buttonBibliotecario.addActionListener(this);
        buttonBibliotecario.setMaximumSize(buttonSize);


        buttonVisitante = new JButton("Visitantes");
        buttonVisitante.setFocusable(false);
        buttonVisitante.addActionListener(this);
        buttonVisitante.setMaximumSize(buttonSize);

    

        buttonExit = new JButton("Sair");
        buttonExit.setFocusable(false);
        buttonExit.addActionListener(this);
        buttonExit.setMaximumSize(buttonSize);



        panelItens.add(Box.createVerticalStrut(10));
        panelItens.add(buttonHome);
        panelItens.add(Box.createVerticalStrut(5)); 
        panelItens.add(buttonBibliotecario);
        panelItens.add(Box.createVerticalStrut(5));
        panelItens.add(buttonVisitante);
        panelItens.add(Box.createVerticalStrut(5));
        panelItens.add(buttonExit);
       


        return panelItens;
    }


    public JPanel panelInfoAdmin(){
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



  

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonHome) {
            cardLayout.show(panelContent, "home");
            System.out.println("Entrei");
        } else if (e.getSource() == buttonBibliotecario) {
            cardLayout.show(panelContent, "bibliotecarios");
        } else if (e.getSource() == buttonVisitante) {
            cardLayout.show(panelContent, "visitantes");
        } else if (e.getSource() == buttonExit) {
            System.exit(0);
        }
    }
}
