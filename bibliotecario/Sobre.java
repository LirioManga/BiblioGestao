package bibliotecario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Sobre extends JPanel implements ActionListener{
    JPanel login;
    JLabel labelTitulo, labelNome, labelSenha, ipLabel;
    JTextField fieldNome, ipTextField;
    JPasswordField fieldSenha;
    JButton buttonLogin, botao;

    public Sobre() {
 
        setBackground(Color.lightGray);
        labelNome = new JLabel("Imprimindo nome");
        labelNome.setBounds(10,10,100,20);

        botao = new JButton("Botao");
        botao.setBounds(40,30,50,20);
        botao.addActionListener(this);

        this.add(labelNome);
        this.add(botao);
        this.setLayout(null);
    }


    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==botao){
            System.out.println("Estou a jobar");
        }
    }
}


