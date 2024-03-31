package administrador;

import javax.swing.*;
import java.awt.event.*;

public class CadastroBibliotecario extends JFrame implements ActionListener{

    JLabel tituloLabel, idLabel, nomeLabel,emaiLabel, senhLabel, contactoLabel;
    
    public CadastroBibliotecario(){
        tituloLabel = new JLabel();
        tituloLabel.setText("Cadastro de Bibliotecário");
        tituloLabel.setBounds(250,10,300,60);



        


        add(tituloLabel);
        this.setTitle("Cadastro Bibliotecário");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(700, 500);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        
    }
}
