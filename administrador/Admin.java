package administrador;

import javax.swing.*;

import bibliotecario.Home;
import bibliotecario.Sobre;

import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Admin extends JPanel implements ActionListener,WindowListener{
 
    JPanel login;
	JPanel painel;
	

	JLabel labelTitulo,labelNome,labelSenha;
	JTextField fieldNome;
	JPasswordField  fieldSenha;
	JButton buttonLogin;
	Connection connection;
	
	public Admin(){

		login = new JPanel();
		login.setBounds(350,150,350,400);
		login.setLayout(null);
		login.setBackground(new Color(0x123456));
		
		labelTitulo = new JLabel("Administração");
		labelTitulo.setBounds(90, 20, 300, 30);
		labelTitulo.setFont(new Font("mv boli", Font.BOLD, 30));
		labelTitulo.setForeground(Color.white);
		
		labelNome = new JLabel("Nome");
		labelNome.setBounds(45, 140, 50, 30);
		labelNome.setForeground(Color.white);
		
		fieldNome = new JTextField();
		fieldNome.setBounds(100, 140, 200, 30);
		
		labelSenha = new JLabel("Senha");
		labelSenha.setBounds(45, 210, 200, 30);
		labelSenha.setForeground(Color.white);
		
		fieldSenha = new JPasswordField();
		fieldSenha.setBounds(100,210,200,30);
		
		
		buttonLogin = new JButton("login");
		buttonLogin.setFont(new Font("mv boli", Font.ITALIC, 15));
		buttonLogin.setBounds(210, 320, 90, 30);
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
		
		
		this.setLayout(null);
		add(login);
		
	}

    @Override
    public void actionPerformed (ActionEvent e){

		String nome = fieldNome.getText();
        String senha = String.valueOf(fieldSenha.getPassword());

		try {
            
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }


		if(e.getSource() == buttonLogin){

			try {
				
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM admin WHERE username=? AND senha=?");
				statement.setString(1, nome);
				statement.setString(2, senha);
				ResultSet result = statement.executeQuery();
				
				if (result.next()) {
					//dispose();
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
		
	@Override
	public void windowClosing(WindowEvent e) {}
	public void windowActivated(WindowEvent e){}
	public void windowOpened(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
}


