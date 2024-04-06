package visitante;

import bibliotecario.Home;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.sql.*;

public class Visitante extends JFrame implements ActionListener{

    private DefaultListModel<String> listModel;
    private JList<String> list;
    JButton voltarButton, pesquisarButton;
    JTextField searchBar;

    public Visitante() {
        setTitle("Livros");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Modelo e JList
        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBounds(10, 50, 600, 400);
        add(scrollPane);

        searchBar = new JTextField();
        searchBar.setBounds(10, 10, 380, 30);
        add(searchBar);

        
        pesquisarButton = new JButton("Pesquisar");
        pesquisarButton.setBounds(400, 10, 100, 30);
        pesquisarButton.setFocusable(false);
        pesquisarButton.addActionListener(this);
      

        voltarButton = new JButton("Voltar");
        voltarButton.setFocusable(false);
        voltarButton.setBounds(510, 10,100,30);
        voltarButton.addActionListener(this);

        /*searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchTerm = searchBar.getText();
                preencherLista(searchTerm);
            }
        });*/

        add(pesquisarButton);
        add(voltarButton);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == voltarButton){
            dispose();
            new Home();
        }else if(e.getSource() == pesquisarButton){
            String pesquisarLivro = searchBar.getText();
            preencherLista(pesquisarLivro);
        }
    }

    private void preencherLista(String searchTerm) {
        listModel.clear(); 

        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String usuario = "root";
        String senha = "";

        try {
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            String sql = "SELECT * FROM livros WHERE titulo LIKE ?";

            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, "%" + searchTerm + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String autor = resultSet.getString("autor");
                String titulo = resultSet.getString("titulo");
                String editora = resultSet.getString("editora");
                String categoria = resultSet.getString("categoria");

                String item = titulo + " - " + autor + " - " + editora + " - " + categoria;
                listModel.addElement(item);
            }

            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
