package bibliotecario;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.net.*;


public class Outro extends JFrame implements ActionListener{
    
    JPanel login;
    JLabel labelTitulo, labelNome, labelSenha;
    JTextField fieldNome;
    JPasswordField fieldSenha;
    JButton buttonLogin;
    Connection connection;
    
    public Outro() {
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
        
        labelTitulo = new JLabel("Outro");
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
        this.setTitle("Outro");
        this.setLayout(null);
        this.setSize(700,500);
        this.setVisible(true);
        add(login);
    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == buttonLogin) {

            try {

                InetAddress localhost = InetAddress.getLocalHost();
                String ip = localhost.getHostAddress();

                System.out.println(ip);
                if (!ip.equals("192.168.110.1")) {
                    JOptionPane.showMessageDialog(null, "Acesso permitido apenas a partir do IP 192.168.111.1", "Erro de acesso", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao obter o endereço IP", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String nome = fieldNome.getText();
            String email = String.valueOf(fieldSenha.getPassword());
            
            try {
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery("SELECT * FROM bibliotecario WHERE nome='" + nome + "' AND email='" + email + "'");
                
                if (result.next()) {
                   
                    dispose(); 
                    new HomeBiblioteca(); 
                } else {
                
                    JOptionPane.showMessageDialog(null,"Nome ou email incorretos", "Erro de login", JOptionPane.ERROR_MESSAGE);
                }//' or '1'='1   #BDC7E6
                
                statement.close();
                result.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

