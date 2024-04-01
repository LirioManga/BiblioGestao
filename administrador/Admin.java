package administrador;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Admin extends JFrame implements ActionListener{
 
    JPanel login;
	JPanel painel;
	

	JLabel labelTitulo,labelNome,labelSenha;
	JTextField fieldNome, fieldSenha;
	JButton buttonLogin;
	Connection connection;
	
	public Admin(){
		try {
            
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }


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

		String nome = fieldNome.getText();
        String senha = fieldSenha.getText();

		if(e.getSource() == buttonLogin){

			try {
				
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM admin WHERE username=? AND senha=?");
				statement.setString(1, nome);
				statement.setString(2, senha);
				ResultSet result = statement.executeQuery();
				
				if (result.next()) {
					dispose();
					new CadastroBibliotecario();
				
				} else {
					fieldNome.setText("");
					fieldSenha.setText("");
					System.out.println("Nome ou senha incorretos");
					JOptionPane.showMessageDialog(null,"Erro, tente novamente", "Dados incorretos", JOptionPane.ERROR_MESSAGE);
				}
				
				statement.close();
				result.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
		}
		
}


