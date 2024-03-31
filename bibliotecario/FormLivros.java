package bibliotecario;

import javax.swing.*;
import livros.Livros;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.util.Scanner;
import java.sql.*;
import java.awt.event.*;

public class FormLivros extends JFrame implements ActionListener{
	public String autor = "";
	public String titulo = "";
	public String editora = "";
	public String categoria = "";
	
	
	// FormLivros
	JLabel labAutor, labTitulo, labEditora, labCategoria;
	JTextField textAutor, textTitulo, textEditora, textCategoria;
	JButton adicionar;
	
	public FormLivros(){
		labAutor = new JLabel("Autor");
		labAutor.setBounds(30, 20, 50, 25);
		
		textAutor = new JTextField();
		textAutor.setBounds(100, 20,150,25);
		
		labTitulo = new JLabel("Titulo");
		labTitulo.setBounds(30, 60, 50,25);
		
		textTitulo = new JTextField();
		textTitulo.setBounds(100,60,150,25);
		
		labEditora = new JLabel("Editora");
		labEditora.setBounds(30,100,50,25);
		
		textEditora = new JTextField();
		textEditora.setBounds(100,100,150,25);
		
		labCategoria = new JLabel("Categoria");
		labCategoria.setBounds(30,140,70,25);
		
		textCategoria = new JTextField();
		textCategoria.setBounds(100,140,150,25);
		
		adicionar = new JButton("Adicionar");
		adicionar.setBounds(120, 200, 100,30);
		adicionar.setFocusable(false);
		adicionar.addActionListener(this);
		
		
		add(labAutor);
		add(textAutor);
		add(labTitulo);
		add(textTitulo);
		add(labEditora);
		add(textEditora);
		add(labCategoria);
		add(textCategoria);
		add(adicionar);
	
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(350,300);
		this.setVisible(true);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == adicionar){
			autor = textAutor.getText();
			titulo = textTitulo.getText();
			editora = textEditora.getText();
			categoria = textCategoria.getText();
			
			if(!autor.isEmpty()){
				Object[] novoLivro = {autor, titulo,editora,categoria};
				Livros.modelo.addRow(novoLivro);
				
				adicionarLivros();
			
				this.setVisible(false);
			}
		}
	}
	
	
	public void adicionarLivros(){
		String url = "jdbc:mysql://localhost:3306/biblioteca";
				String usuario = "root";
				String senha = "";
				
				try{
					Class.forName("com.mysql.cj.jdbc.Driver");
					 Connection conexao = DriverManager.getConnection(url, usuario, senha);
					
					String sql = "INSERT INTO livros (autor,titulo,editora,categoria) VALUES (?,?,?, ?)";
					
					try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
                
					preparedStatement.setString(1,autor);
					preparedStatement.setString(2,titulo);
					preparedStatement.setString(3,editora);
					preparedStatement.setString(4,categoria);

				
					preparedStatement.executeUpdate();

					System.out.println("Dados inseridos com sucesso.");
				}
					conexao.close();
					
					
				}catch (ClassNotFoundException f){
					
					f.printStackTrace();
					
				}catch(SQLException f){
					
					f.printStackTrace();
				}
				
				
				textAutor.setText("");
				textCategoria.setText("");
				textEditora.setText("");
				textTitulo.setText("");
			
		
	}
}