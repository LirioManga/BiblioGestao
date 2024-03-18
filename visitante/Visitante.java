package visitante;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Visitante extends JFrame {
    private DefaultTableModel modelo;
    private JTable tabela;

    public Visitante() {
        
        modelo = new DefaultTableModel();
        tabela = new JTable(modelo);

     
        modelo.addColumn("ID");
        modelo.addColumn("Autor");
        modelo.addColumn("Titulo");
        modelo.addColumn("Editora");
        modelo.addColumn("Categoria");

      
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(10, 10, 500, 200);
        add(scrollPane);

      
        setTitle("Livros");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);

        
        preencherTabela();
    }

    
    private void preencherTabela() {
        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String usuario = "root";
        String senha = "";

        try {
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            String sql = "SELECT * FROM livros";

            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String autor = resultSet.getString("autor");
                String titulo = resultSet.getString("titulo");
                String editora = resultSet.getString("editora");
                String categoria = resultSet.getString("categoria");

                modelo.addRow(new Object[]{autor, titulo, editora, categoria});
            }

            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
