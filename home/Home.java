package home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;

public class Home extends JFrame implements ActionListener{
    JTextField contactoField, nomeField, faculField;
    JTextField userField, passwordField;
    JButton loginButton, getInButton;
    JLabel libraryName, namLabel2;
    JPanel nameLibraryPanel, registrationPanel;
    JPanel registrateStudentPanel, loginPanel;
    CardLayout cardLayout;
    JComboBox<String> comboBox;

    public Home() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 350);
        setLocationRelativeTo(null);

        nameLibraryPanel = new JPanel();
        nameLibraryPanel.setPreferredSize(new Dimension(250, 350));
        nameLibraryPanel.setBackground(Color.GRAY);
        nameLibraryPanel.setLayout(null);


        libraryName = new JLabel();
        libraryName.setText("Biblioteca UP");
        libraryName.setBounds(20, 100, 250, 50);
        libraryName.setFont(new Font("Consola", Font.PLAIN, 34));
        nameLibraryPanel.add(libraryName);

        namLabel2 = new JLabel();
        namLabel2.setText("CPED");
        namLabel2.setBounds(90, 170, 250, 30);
        namLabel2.setFont(new Font("Consola", Font.ITALIC, 18));
        nameLibraryPanel.add(namLabel2);

       
        cardLayout = new CardLayout();
        loginPanel = new JPanel(cardLayout);
        loginPanel.setBackground(Color.GREEN);


        //panel visitante


        JPanel visitante = new JPanel();
        visitante.add(new JLabel("Este é o Cartão 1"));
        visitante.setLayout(null);
        visitante.setBackground(Color.pink);

        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(10, 50, 80, 25);
        visitante.add(nomeLabel);

        nomeField = new JTextField(20);
        nomeField.setBounds(100, 50, 165, 25);
        setPlaceholder(nomeField, "Insira o seu nome");
        visitante.add(nomeField);
        
        JLabel contactoLabel = new JLabel("Contacto:");
        contactoLabel.setBounds(10, 90, 80, 25);
        visitante.add(contactoLabel);

        contactoField = new JTextField(20);
        contactoField.setBounds(100, 90, 165, 25);
        setPlaceholder(contactoField, "(+258) 87635363532");
        visitante.add(contactoField);


        JLabel faculLabel = new JLabel("Faculdade:");
        faculLabel.setBounds(10, 140, 80, 25);
        visitante.add(faculLabel);

        comboBox = new JComboBox<>(new String[]{"FET", "FCNM","FEP","FEG","FCEFD", "FCLCA", "FCTA","FCSF","Outro"});
        comboBox.setMaximumRowCount(4);
        comboBox.setBounds(100, 140, 165, 25);
        visitante.add(comboBox);

        loginPanel.add(visitante, "visitante");


        // panel login
        
        
        JPanel login = new JPanel();
        login.add(new JLabel("Este é o Cartão 2"));
        login.setLayout(null);
        login.setBackground(Color.cyan);
        
        JLabel userLabel = new JLabel("Nome:");
        userLabel.setBounds(10, 80, 80, 25);
        login.add(userLabel);

        userField = new JTextField(20);
        userField.setBounds(100, 80, 165, 25);
        setPlaceholder(userField, "Insira o seu nome");
        login.add(userField);


        JLabel passwordLabel = new JLabel("Senha:");
        passwordLabel.setBounds(10, 140, 80, 25);
        login.add(passwordLabel);

        passwordField= new JTextField(20);
        passwordField.setBounds(100, 140, 165, 25);
        setPlaceholder(passwordField, "(+258) 87635363532");
        login.add(passwordField);



        
        loginPanel.add(visitante, "visitante");
        loginPanel.add(login, "login");

        // painel dos botoes

        JPanel buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(400, 60));
        buttonPanel.setBackground(Color.BLUE);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER,100,20));

     
        loginButton = new JButton("Login");
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);
        getInButton = new JButton("Entrar");
        getInButton.setFocusable(false);
        getInButton.addActionListener(this);

       
        buttonPanel.add(loginButton);
        buttonPanel.add(getInButton);


        // container para login
        
        JPanel loginContainer = new JPanel(new BorderLayout());
        loginContainer.setPreferredSize(new Dimension(400, 350));
        loginContainer.add(loginPanel, BorderLayout.CENTER);
        loginContainer.add(buttonPanel, BorderLayout.SOUTH);

        
        setLayout(new BorderLayout());
        add(nameLibraryPanel, BorderLayout.WEST);
        add(loginContainer, BorderLayout.CENTER);

       
       
        setResizable(false);
        setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == loginButton) {
            boolean isFirstClick = userField.getText().isEmpty() && passwordField.getText().isEmpty();
            cardLayout.show(loginPanel, "login");

            if(userField.getText().isEmpty() || passwordField.getText().isEmpty() ||
                userField.getText().equals("Insira o seu nome") || passwordField.getText().equals("********")){
                JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.");
            }else if(isFirstClick){
                System.out.println("nao faz");
            }
        } else if (e.getSource() == getInButton) {

            cardLayout.show(loginPanel, "visitante");
            if (nomeField.getText().isEmpty() || contactoField.getText().isEmpty() || nomeField.getText().equals("Insira o seu nome")|| contactoField.equals("(+258) 87635363532")) {
                JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.");

            }else{
                String nome = nomeField.getText();
                String contacto = contactoField.getText();
                String instituicao = (String) comboBox.getSelectedItem();

                Date data = new Date();
                Timestamp timestamp = new Timestamp(data.getTime());
                dadosVisitantes(nome,instituicao,contacto, timestamp);
               System.out.println("dados enviados com sucesso");
               nomeField.setText("");
               contactoField.setText("");
            }
        }
    }

    private void setPlaceholder(JTextField textField, String placeholder) {
        textField.setFont(new Font("mv boli", Font.ITALIC, 10));
        textField.setText(placeholder);
        textField.setForeground(Color.GRAY);

        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                    textField.setForeground(Color.GRAY);
                }
            }
        });
    }
  
    public void dadosVisitantes(String nome, String instituicao,String contacto, Timestamp data){
        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String usuario = "root";
        String senha = "";

        try {

            Connection conexao = DriverManager.getConnection(url, usuario, senha);

            String query = "INSERT INTO visitantes (nome, instituicao,contacto,dataEstadia) VALUES (?, ?, ?,?)";

            PreparedStatement declaracao = conexao.prepareStatement(query);

            declaracao.setString(1, nome);
            declaracao.setString(2, instituicao);
            declaracao.setString(3, contacto);
            declaracao.setTimestamp(4, data);

            declaracao.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
    
            conexao.close();

        } catch (SQLException g) {

            JOptionPane.showMessageDialog(null, "Erro ao inserir dados no banco de dados: " + g.getMessage());

        }

    }

    public static void main(String[] args) {
        new Home();
    }
}
