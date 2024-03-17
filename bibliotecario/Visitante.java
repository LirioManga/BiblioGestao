package bibliotecario;
import bibliotecario.HomeBiblioteca;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Visitante extends JFrame implements ActionListener{
	private String name;
	private String password;
	
	// setters & getters
	public void setNome(){
		this.name = "Lirio";
	}
	
	public String getNome(){
		return name;
	}
	
	public void setSenha(){
		this.password = "lirio10";
	}
	
	public String getSenha(){
		return password;
	}
	
	// Frame
	JPanel login;
	JPanel painel;
	

	JLabel labelTitulo,labelNome,labelInst, nrLabel;
	JTextField fieldNome, fieldnr,fieldInst;
	JButton buttonLogin;
	
	public Visitante(){
		setNome();
		setSenha();
		
		login = new JPanel();
		login.setBounds(130,90,400,300);
		login.setLayout(null);
		login.setBackground(new Color(0x123456));
		
		labelTitulo = new JLabel("Dados Visitante");
		labelTitulo.setBounds(90, 20, 300, 30);
		labelTitulo.setFont(new Font("mv boli", Font.BOLD, 30));
		labelTitulo.setForeground(Color.white);
		

		nrLabel = new JLabel("Nr_Visitante");
		nrLabel.setBounds(100, 60, 80, 25);
		nrLabel.setForeground(Color.white);

		fieldnr = new JTextField();
		fieldnr.setBounds(175, 60, 130, 25);

		labelNome = new JLabel("Nome");
		labelNome.setBounds(100, 120, 50, 25);
		labelNome.setForeground(Color.white);
		
		fieldNome = new JTextField();
		fieldNome.setBounds(140, 120, 130, 25);
		
		labelInst = new JLabel("Instituicao");
		labelInst.setBounds(100, 180, 100, 25);
		labelInst.setForeground(Color.white);
		
		fieldInst = new JTextField();
		fieldInst.setBounds(180,180,130,25);
		
		
		buttonLogin = new JButton("Registar");
		buttonLogin.setFont(new Font("mv boli", Font.ITALIC, 15));
		buttonLogin.setBounds(160, 250, 100, 30);
		buttonLogin.setFocusable(false);
		buttonLogin.addActionListener(this);
		
		// adicionando elementos ao panel
		login.add(nrLabel);
		login.add(fieldnr);
		login.add(labelTitulo);
		login.add(labelNome);
		login.add(fieldNome);
		login.add(labelInst);
		login.add(fieldInst);
		login.add(buttonLogin);
		
			
		// frame settings
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Visitante");
		this.setLayout(null);
		this.setSize(700,500);
		this.setVisible(true);
		add(login);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e){
			
		if(e.getSource() == buttonLogin){
			String nr_visitante = fieldnr.getText();
			String nome = fieldNome.getText();
			String instituicao = fieldInst.getText();
			
				if(!nome.isEmpty()){
				
				String url = "jdbc:mysql://localhost:3306/biblioteca";
				String usuario = "root";
				String senha = "";
				
				try{
					Class.forName("com.mysql.cj.jdbc.Driver");
					 Connection conexao = DriverManager.getConnection(url, usuario, senha);
					
					String sql = "INSERT INTO visitantes (nr_id,nome,instituicao) VALUES (?,?,?)";
					
					try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
                
					preparedStatement.setString(1,nr_visitante);
					preparedStatement.setString(2,nome);
					preparedStatement.setString(3,instituicao);
			

				
					preparedStatement.executeUpdate();

					System.out.println("Dados inseridos com sucesso.");
				}
					conexao.close();
					
					
				}catch (ClassNotFoundException f){
					
					f.printStackTrace();
					
				}catch(SQLException f){
					
					f.printStackTrace();
				}
			}
			
			dispose();
			new ShowLivros();
		
		}
		
	}
	
	
}