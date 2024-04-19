package bibliotecario;
import visitante.RegistoVisitante;
import visitante.Visitante;
import administrador.Admin;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Home extends JFrame implements ActionListener{
    JMenuBar menu;
    JMenu home;
    JMenuItem adminItem, bibliotecarioItem, exitItem;

    JLabel bem_vindo, frase_motivacional;
    JButton botao_entrar;
    
    public Home(){
        // menu
        menu = new JMenuBar();
        home = new JMenu("Menu");
        adminItem = new JMenuItem("Admin");
        bibliotecarioItem = new JMenuItem("Bibliotecario");
        exitItem = new JMenuItem("Sair");

		// eventos
        adminItem.addActionListener(this);
		bibliotecarioItem.addActionListener(this);
		exitItem.addActionListener(this);


        // elementos no frame
        bem_vindo = new JLabel();
        bem_vindo.setText("Bem vindo");
        bem_vindo.setBounds(250, 80, 350, 150);
        bem_vindo.setFont(new Font("mv boli", Font.ITALIC, 35));

        frase_motivacional = new JLabel();
        frase_motivacional.setText("Encontre seu livro, artigo ou monografia");
        frase_motivacional.setBounds(125,130, 500, 150);
        frase_motivacional.setFont(new Font("mv boli", Font.ITALIC, 20));

        botao_entrar = new JButton("Entrar");
        botao_entrar.setFocusable(false);
        botao_entrar.setBackground(Color.BLUE);
        botao_entrar.setBounds(280, 240, 120, 50);
		botao_entrar.addActionListener(this);


        // Adicionando elementos ao frame
        home.add(adminItem);
        home.add(bibliotecarioItem);
        home.add(exitItem);
        menu.add(home);
        this.add(bem_vindo);
        this.add(frase_motivacional);
        this.add(botao_entrar);
		

        // frame settings
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(700, 500);
        this.setJMenuBar(menu);
        this.setVisible(true);
    }		

    @Override
    public void actionPerformed (ActionEvent e){
        if(e.getSource() == adminItem){
            dispose();
            new Admin();
            System.out.print("entrando como administrador");
        }else if(e.getSource() == bibliotecarioItem){
			dispose();
            new Bibliotecario();
        }else if(e.getSource() == exitItem){
            dispose();
        }
        else if(e.getSource() == botao_entrar){
            dispose();
			new RegistoVisitante();
		}
    }
    
}
