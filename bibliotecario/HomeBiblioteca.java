package bibliotecario;


import javax.swing.*;

import artigos.Artigos;
import livros.Livros;

import java.awt.event.*;

public class HomeBiblioteca extends JFrame implements ActionListener{
	JButton livros, artigos, monografias;
	
	public HomeBiblioteca(){
		livros = new JButton("Livros");
		livros.setBounds(120, 40, 150, 30);
		livros.setFocusable(false);
		livros.addActionListener(this);
		
		
		artigos = new JButton("Artigos");
		artigos.setBounds(120, 100, 150, 30);
		artigos.setFocusable(false);
		artigos.addActionListener(this);
		
		monografias = new JButton("Monografias");
		monografias.setBounds(120, 160, 150, 30);
		monografias.setFocusable(false);
		monografias.addActionListener(this);
		
		add(livros);
		add(artigos);
		add(monografias);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 350);
		this.setLayout(null);
		this.setVisible(true);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == livros){
			dispose();
			new Livros();
		}else if(e.getSource() == artigos){
			dispose();
			new Artigos();
			System.out.println("botao pessionado");
		}else{
			dispose();
			
		}
	}
	
}