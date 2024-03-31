package administrador;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Admin extends JFrame implements ActionListener{
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

    JPanel login;
	JPanel painel;
	

	JLabel labelTitulo,labelNome,labelSenha;
	JTextField fieldNome, fieldSenha;
	JButton buttonLogin;
	
	public Admin(){
		setSenha();
		setNome();

		login = new JPanel();
		login.setBounds(130,90,400,300);
		login.setLayout(null);
		login.setBackground(new Color(0x123456));
		
		labelTitulo = new JLabel("Administrador");
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
		
		fieldSenha = new JTextField();
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
		this.setTitle("Administrador");
		this.setLayout(null);
		this.setSize(700,500);
		this.setVisible(true);
		add(login);
		
	}

    @Override
    public void actionPerformed (ActionEvent e){
        if(e.getSource() == buttonLogin){
			String nome = fieldNome.getText();
			String senha = fieldSenha.getText();
			
			
			if (nome.equals(getNome()) && senha.equals(getSenha())) {
				dispose();
				new CadastroBibliotecario();
			
			} else {
				fieldNome.setText("");
				fieldSenha.setText("");
				System.out.println("Nome ou senha incorretos");
				JOptionPane.showMessageDialog(null,"Erro, tente novamente", "Dados incorretos", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
	}
}

