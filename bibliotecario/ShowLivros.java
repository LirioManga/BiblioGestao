package bibliotecario;

import java.awt.FlowLayout;
import javax.swing.*;


public class ShowLivros extends JFrame{
    

    JLabel msg;
    public ShowLivros(){

        msg = new JLabel("Livros buscados na base de dados. BREVEMENTE!!!");
        
        add(msg);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setSize(350,300);
		this.setVisible(true);
    }
}
