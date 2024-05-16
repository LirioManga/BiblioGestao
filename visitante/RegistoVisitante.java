package visitante;

import javax.swing.*;

import bibliotecario.Home;

import java.awt.event.*;
import java.util.Date;
import java.sql.*;

public class RegistoVisitante extends JFrame implements ActionListener{
    JLabel labelNome, labelContacto;
    JTextField campoNome, campoContacto;
    JComboBox<String> comboBox;
    JButton submeter;

    public RegistoVisitante() {
        setTitle("Registo Visitantes"); 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        labelNome = new JLabel("Nome:");
        labelNome.setBounds(50, 50, 80, 30);
        add(labelNome);

        campoNome = new JTextField();
        campoNome.setBounds(140, 50, 200, 25);
        add(campoNome);

      
        labelContacto = new JLabel("Contacto:");
        labelContacto.setBounds(50, 100, 80, 30);
        add(labelContacto);

        campoContacto = new JTextField();
        campoContacto.setBounds(140, 100, 200, 25);
        add(campoContacto);

    
        comboBox = new JComboBox<>(new String[]{"FET-UP", "FEP-UP", "FCNM-UP", "FEG-UP","Institudo Medio de Lhanguene", "Escola Secundaria de Lhanguene", "Instituto Superior Dom Bosco", "Outro"});
        comboBox.setBounds(140, 150, 200, 30);
        add(comboBox);
        
        submeter = new JButton("Submeter");
        submeter.setBounds(130,200,130,30);
        submeter.setFocusable(false);
        submeter.addActionListener(this);
      
        add(submeter);

        setSize(400, 300); 
        setLayout(null);
        setLocationRelativeTo(null); 
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == submeter){
            dispose();

            String nome = campoNome.getText();
            String contacto = campoContacto.getText();
            String instituicao = (String) comboBox.getSelectedItem();

            if (nome.isEmpty() || contacto.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.", "Erro de Preenchimento", JOptionPane.ERROR_MESSAGE);
                new Home();
                
            }else{

                
                Date data = new Date();
                Timestamp timestamp = new Timestamp(data.getTime());
                dadosVisitantes(nome,instituicao,contacto, timestamp);
                new Visitante();
            }
            
        }

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

}
