package bibliotecario;
import bibliotecario.HomeBiblioteca;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Bibliotecario extends JFrame implements ActionListener{
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
	
	JPasswordField fieldSenha;
	JLabel labelTitulo,labelNome,labelSenha;
	JTextField fieldNome;
	JButton buttonLogin;
	
	public Bibliotecario(){
		setNome();
		setSenha();
		
		login = new JPanel();
		login.setBounds(130,90,400,300);
		login.setLayout(null);
		login.setBackground(new Color(0x123456));
		
		labelTitulo = new JLabel("Bibliotecario");
		labelTitulo.setBounds(90, 20, 300, 30);
		labelTitulo.setFont(new Font("mv boli", Font.BOLD, 30));
		labelTitulo.setForeground(Color.white);
		
		labelNome = new JLabel("Nome");
		labelNome.setBounds(100, 80, 50, 25);
		labelNome.setForeground(Color.white);
		
		fieldNome = new JTextField();
		fieldNome.setBounds(140, 80, 130, 25);
		
		labelSenha = new JLabel("Senha");
		labelSenha.setBounds(100, 140, 50, 25);
		labelSenha.setForeground(Color.white);
		
		fieldSenha = new JPasswordField();
		fieldSenha.setBounds(140,140,130,25);
		
		
		buttonLogin = new JButton("login");
		buttonLogin.setFont(new Font("mv boli", Font.ITALIC, 15));
		buttonLogin.setBounds(160, 200, 90, 30);
		buttonLogin.setFocusable(false);
		buttonLogin.addActionListener(this);
		
		// adicionando elementos ao panel
		login.add(labelTitulo);
		login.add(labelNome);
		login.add(fieldNome);
		login.add(labelSenha);
		login.add(fieldSenha);
		login.add(buttonLogin);
		
			
		// frame settings
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Bibliotecario");
		this.setLayout(null);
		this.setSize(700,500);
		this.setVisible(true);
		add(login);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e){
			
		if(e.getSource() == buttonLogin){
			String nome = fieldNome.getText();
			String senha = fieldSenha.getText();
			
			
			if((nome.equals(getNome()))&&(senha.equals(getSenha()))){
				dispose();
				new HomeBiblioteca();
			
			}else if((!nome.equals(getNome())) || (!senha.equals(getSenha()))){
	
				fieldNome.setText("");
				fieldSenha.setText("");
				System.out.print("nome e senha incorreto");
				JOptionPane.showMessageDialog(null,"Erro, tente novamente", "Dados incorrectos", JOptionPane.ERROR_MESSAGE);
				
			}else if(!senha.equals(getSenha())){
				fieldSenha.setText("");
				System.out.print("senha incorreta");
				
			}else if(!nome.equals(getNome())){
				
				System.out.println("incorreto");
			}
		}
		
	}
	
	
}