package home;

//import admin.*;

import javax.swing.*;

import admin.Admin;
import bibliotecario.Bibliotecario;
import visitante.Visitante;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;


public class Home extends JFrame implements ActionListener{ 
    // panel para botoes
    JButton loginButton, getInButton, buttonEntrar, buttonLogin;;
    JPanel loginPanel;
    CardLayout cardLayout;
    JTextField contactoField, nomeField, userField, passwordField;
    JComboBox<String> comboBox;
   

    public Home() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(680, 450);
        setLocationRelativeTo(null);
       
        cardLayout = new CardLayout();

        loginPanel = new JPanel(cardLayout);
        loginPanel.add(panelVisitante(), "visitante");
        loginPanel.add(panelLogin(), "login");

        

        // container para login/registro estudante 
        JPanel loginContainer = new JPanel(new BorderLayout());
        loginContainer.setPreferredSize(new Dimension(400, 350));
        loginContainer.add(loginPanel, BorderLayout.CENTER);
        loginContainer.add(buttonsTelasRegisto(), BorderLayout.NORTH);

        // dentro do meu frame
        setLayout(new BorderLayout());
        add(nomeInstituicao(), BorderLayout.WEST);
        add(loginContainer, BorderLayout.CENTER); 
        setResizable(false);
        setVisible(true);
    }


    public JPanel nomeInstituicao(){
         // Panel do Nome da instituicao

         JLabel libraryName, namLabel2;
         JPanel nameLibraryPanel;
         nameLibraryPanel = new JPanel();
         nameLibraryPanel.setPreferredSize(new Dimension(300, 350));
         nameLibraryPanel.setBackground(new Color(64, 2, 31));
         nameLibraryPanel.setLayout(null);
 
 
         libraryName = new JLabel();
         libraryName.setText("Biblioteca UP");
         libraryName.setBounds(50, 140, 250, 50);
         libraryName.setFont(new Font("Consola", Font.PLAIN, 34));
         libraryName.setForeground(Color.white);
         nameLibraryPanel.add(libraryName);
 
         namLabel2 = new JLabel();
         namLabel2.setText("CPED");
         namLabel2.setBounds(120, 210, 250, 30);
         namLabel2.setForeground(Color.white);
         namLabel2.setFont(new Font("Consola", Font.ITALIC, 18));
         nameLibraryPanel.add(namLabel2);

        return nameLibraryPanel;
    }

    public JPanel buttonsTelasRegisto(){

       
        // painel dos botoes
        JPanel buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(400, 60));
        buttonPanel.setBackground(new Color(185, 202, 228));
        //buttonPanel.setBackground(Color.green);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT,10,10));

     
        loginButton = new JButton("Login");
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusable(false);
        loginButton.setContentAreaFilled(false);
        loginButton.setBorder(null);
        loginButton.setBackground(new Color(47, 164, 206));
        loginButton.addActionListener(this);
     
        getInButton = new JButton("Entrar");
        getInButton.setForeground(Color.WHITE);
        getInButton.setFocusable(false);
        getInButton.setContentAreaFilled(false);
        getInButton.setBorder(null);
        getInButton.setBackground(new Color(47, 164, 206));
        getInButton.addActionListener(this);
    
        buttonPanel.add(loginButton);
        buttonPanel.add(getInButton);

        return buttonPanel;
    }
 
    public JPanel panelLogin(){
        // Panel login
        JPanel login = new JPanel();
        login.setLayout(null);
        login.setBackground(new Color(185, 202, 228));

        JLabel loginLabel = new JLabel();
        loginLabel.setText("Login");
        loginLabel.setFont(new Font("Consola", Font.PLAIN, 25));
        loginLabel.setBounds(80,15,100,50);
        login.add(loginLabel);
        
        JLabel userLabel = new JLabel("Nome:");
        userLabel.setBounds(80, 70, 80, 25);
        login.add(userLabel);
        
        
        userField = new JTextField(20);
        userField.setBounds(80, 100, 250, 25);
        
        login.add(userField);
        
        
        JLabel passwordLabel = new JLabel("Senha:");
        passwordLabel.setBounds(80, 140, 80, 25);
        login.add(passwordLabel);
        
       
        passwordField= new JTextField(20);
        passwordField.setBounds(80, 170, 250, 25);
        
        login.add(passwordField);      


       
        buttonLogin = new JButton("Login");
        buttonLogin.setFocusable(false);
        buttonLogin.setBounds(80,240,90,30);
        buttonLogin.addActionListener(this);
        login.add(buttonLogin);

        return login;
    }

    public JPanel panelVisitante(){
        JPanel registrateStudentPanel;

        registrateStudentPanel = new JPanel();
        registrateStudentPanel.setLayout(null);
        registrateStudentPanel.setBackground(new Color(185, 202, 228));

        JLabel visitantLabel = new JLabel();
        visitantLabel.setText("Visitante");
        visitantLabel.setFont(new Font("Consola", Font.PLAIN, 20));
        visitantLabel.setBounds(80,30,100,20);

        registrateStudentPanel.add(visitantLabel);

        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(80, 70, 80, 25);
        registrateStudentPanel.add(nomeLabel);

        nomeField = new JTextField();
        nomeField.setBounds(80, 100, 250, 25);
        nomeField.setFont(new Font("Consolas", Font.PLAIN, 12));
       
        registrateStudentPanel.add(nomeField);
        
        JLabel contactoLabel = new JLabel("Contacto:");
        contactoLabel.setBounds(80, 130, 80, 25);
        registrateStudentPanel.add(contactoLabel);

        contactoField = new JTextField(20);
        contactoField.setBounds(80, 160, 250, 25);
        contactoField.setFont(new Font("Consolas", Font.PLAIN, 12));
      
        registrateStudentPanel.add(contactoField);


        JLabel faculLabel = new JLabel("Faculdade/Proviniencia");
        faculLabel.setBounds(80, 190, 200, 25);
        registrateStudentPanel.add(faculLabel);

        comboBox = new JComboBox<>(new String[]{"FET", "FCNM","FEP","FEG","FCEFD", "FCLCA", "FCTA","FCSF","Outro"});
        comboBox.setMaximumRowCount(4);
        comboBox.setBounds(80, 220, 250, 25);
        registrateStudentPanel.add(comboBox);

        buttonEntrar = new JButton("Entrar");
        buttonEntrar.setFocusable(false);
        buttonEntrar.setBounds(80,280,90,30);
        buttonEntrar.addActionListener(this);
        registrateStudentPanel.add(buttonEntrar);

        return registrateStudentPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e){
      
        if(e.getSource() == loginButton){
            cardLayout.show(loginPanel, "login");

        }else if(e.getSource() == getInButton){
            cardLayout.show(loginPanel, "visitante");

        }else if(e.getSource() == buttonLogin){
            System.out.println("login");
            if(userField.getText().isEmpty() || passwordField.getText().isEmpty() ||
                userField.getText().equals("Insira o seu nome") || passwordField.getText().equals("********")){
                //JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.");

            }else {
                String nome = userField.getText();
                String senha = passwordField.getText();

                String tipoUsuario = validarCredenciais(nome, senha);
                if(tipoUsuario !=null){
                    Frame frame = new Frame();
                    if (tipoUsuario.equals("admin")) {

                        System.out.println("entrei como admin");
                        dispose(); 
                        
                        Admin adminPanel = new Admin(nome,"admin",frame);
                        frame.addPanel(adminPanel, "admin");
                        frame.showPanel("admin");
                        frame.repaint();
                        frame.revalidate();
                    }else if(tipoUsuario.equals("bibliotecario")) {
                        System.out.println("entrei como bibliotecario");
                        dispose();
                       
                        Bibliotecario bibliotecarioPanel = new Bibliotecario(nome,"bibliotecario",frame);
                        frame.addPanel(bibliotecarioPanel, "bibliotecario");
                        frame.showPanel("bibliotecario");
                        repaint();
                        revalidate();
                    }   

                }else{
                    JOptionPane.showMessageDialog(this, "Nome de usuário ou senha incorretos.");

                }
            }

        }else if(e.getSource() == buttonEntrar){
            System.out.println("visitante");
            //if (nomeField.getText().isEmpty() || contactoField.getText().isEmpty() || nomeField.getText().equals("Insira o seu nome")|| contactoField.equals("(+258) 87635363532")) {
                //JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.");

           // }else{
                String nome = nomeField.getText();
                String contacto = contactoField.getText();
                String instituicao = (String) comboBox.getSelectedItem();

                Date data = new Date();
                Timestamp timestamp = new Timestamp(data.getTime());
              //  dadosVisitantes(nome,instituicao,contacto, timestamp);
                dispose();
                Frame frame = new Frame();
                Visitante visitante = new Visitante(nome,"Visitante",frame);
                frame.addPanel(visitante, "visitante");
                frame.showPanel("visitante");


                System.out.println("dados enviados com sucesso");
                nomeField.setText("");
                contactoField.setText("");
                repaint();
                revalidate();

           // }
        }
    }

    private String validarCredenciais(String nome, String senha) {
        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String usuarioBD = "root";
        String senhaBD = "";
    
        try {
            Connection conexao = DriverManager.getConnection(url, usuarioBD, senhaBD);
    
            
            String queryAdmin = "SELECT * FROM admin WHERE username = ? AND senha = ?";
            PreparedStatement declaracaoAdmin = conexao.prepareStatement(queryAdmin);
            declaracaoAdmin.setString(1, nome);
            declaracaoAdmin.setString(2, senha);
            
            ResultSet resultadoAdmin = declaracaoAdmin.executeQuery();
            
            if (resultadoAdmin.next()) {
                return "admin"; 
            }
    
            
            String queryBiblio = "SELECT * FROM bibliotecario WHERE nome = ? AND email = ?";
            PreparedStatement declaracaoBiblio = conexao.prepareStatement(queryBiblio);
            declaracaoBiblio.setString(1, nome);
            declaracaoBiblio.setString(2, senha);
            
            ResultSet resultadoBiblio = declaracaoBiblio.executeQuery();
            
            if (resultadoBiblio.next()) {
                return "bibliotecario"; 
            }
    
            conexao.close();
        } catch (SQLException g) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar dados no banco de dados: " + g.getMessage());
        }
    
        return null; 
    }
}
