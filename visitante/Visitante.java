package visitante;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

import bibliotecario1.Home;

import java.sql.*;

public class Visitante extends JPanel implements ActionListener{

    private DefaultListModel<String> listModel;
    private JList<String> list;
    JButton voltarButton, pesquisarButton;
    JTextField searchBar;
    JFrame homeInstance;
    public Visitante(Home homeInstance) {
        //setTitle("Livros");
        //setSize(700, 500);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.homeInstance = homeInstance;
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


        add(pesquisarButton);
        add(voltarButton);
        //this.setLocationRelativeTo(null);
        //setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == voltarButton){
           // dispose();
           homeInstance.getContentPane().removeAll();
           homeInstance.setContentPane(new Home()); // To reset back to Home screen
           homeInstance.repaint();
           homeInstance.revalidate();
          
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
