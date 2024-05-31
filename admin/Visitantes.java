package admin;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Visitantes extends JPanel implements ActionListener{
    JPanel searchPanel;
    JTextField searchField;
    JButton pesquisarButtonIcon, deleteButton;
    JLabel pesquisarLabelIcon;
    ImageIcon pesquisarIcon;


    DefaultTableModel modelo;
    JScrollPane scrollPane;
    JTable tabela;

    public Visitantes(){
        setBackground(Color.CYAN);
        setLayout(new BorderLayout());
    
     
                    // painel de pesquisa
        searchPanel = new JPanel();
        searchPanel.setPreferredSize(new Dimension(935,40));
        //searchPanel.setBackground(Color.blue);
        searchPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0,7));



        // Inicializando pesquisarIcon e pesquisarButtonIcon
        searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(500,30));


        pesquisarIcon = new ImageIcon("D:\\LICENCIATURA EM INFORMATICA\\3ANO\\1st\\JAVA\\projecto\\javaIconsProj\\pesquisar.png");
        pesquisarButtonIcon = new JButton(pesquisarIcon);
        pesquisarButtonIcon.setPreferredSize(new Dimension(40, 30));
        pesquisarButtonIcon.addActionListener(this);
        pesquisarButtonIcon.setIcon(new ImageIcon(getScaledImage(pesquisarIcon.getImage(), 40, 30)));

        searchPanel.add(searchField);
        searchPanel.add(pesquisarButtonIcon);



        modelo = new DefaultTableModel();

        modelo.addColumn("Nome");
        modelo.addColumn("Email");
        modelo.addColumn("Contacto");
        modelo.addColumn("Sexo");

        tabela = new JTable(modelo);
        tabela.setPreferredScrollableViewportSize(new Dimension(915, 400));
        tabela.setFillsViewportHeight(true);
        scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(0,0,750,250);
        // // Funcao para preencher a tabela antes.
        buscarDadosBaseDeDados();
        
        
        JPanel deletePanel = new JPanel();
        deletePanel.setPreferredSize(new Dimension(935,60));
        deletePanel.setLayout(new FlowLayout(FlowLayout.CENTER,5,20));
        
        deleteButton = new JButton("Excluir");
        deleteButton.setPreferredSize(new Dimension(100,30));
        deleteButton.setFocusable(false);
        deleteButton.addActionListener(this);
        deletePanel.add(deleteButton);


        add(deletePanel, BorderLayout.SOUTH);
        add(scrollPane, BorderLayout.CENTER);
        add(searchPanel, BorderLayout.NORTH);

    }
    
    private Image getScaledImage(Image srcImg, int width, int height) {

        return srcImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == pesquisarButtonIcon){
            pesquisarVisitantes();
        }else if(e.getSource() == deleteButton){
            int rowIndex = tabela.getSelectedRow();
            if (rowIndex != -1) {
                String nome = (String) tabela.getValueAt(rowIndex, 0); 
                excluirVisitante(nome);
               
                ((DefaultTableModel) tabela.getModel()).removeRow(rowIndex); 
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um registro para excluir.", "Erro", JOptionPane.ERROR_MESSAGE);
            }

        }
    }


    private void buscarDadosBaseDeDados() {

        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String usuario = "root";
        String senha = "";
        
        String sql = "SELECT nome, instituicao, contacto, dataEstadia FROM visitantes";

        try (Connection conexao = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement declaracao = conexao.prepareStatement(sql);
             ResultSet resultado = declaracao.executeQuery()) {

     
            DefaultTableModel model = (DefaultTableModel) tabela.getModel();
            model.setRowCount(0);

          
            while (resultado.next()) {
                String nome = resultado.getString("nome");
                String instituicao = resultado.getString("instituicao");
                String contacto = resultado.getString("contacto");
                String dataEstadia= resultado.getString("dataEstadia");

                Object[] linha = {nome, instituicao, contacto, dataEstadia};
                model.addRow(linha);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar dados no banco de dados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void pesquisarVisitantes() {
        String searchTerm = searchField.getText().trim();
        String dataEstadiaSearch= searchField.getText();
        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String usuario = "root";
        String senha = "";
    
        String sql = "SELECT nome, instituicao, contacto, dataEstadia FROM visitantes WHERE nome LIKE ? OR dataEstadia = ?";
    
        try (Connection conn = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
           
            stmt.setString(1, "%" + searchTerm + "%");
           
       

           
            if (isValidDate(searchTerm)) {
                stmt.setString(2, searchTerm); 
            } else {
                stmt.setString(2, ""); 
            }
    
            
            ResultSet rs = stmt.executeQuery();

          
            DefaultTableModel model = (DefaultTableModel) tabela.getModel();
            model.setRowCount(0);
           
    
            while (rs.next()) {
                
                String nome = rs.getString("nome");
                String instituicao = rs.getString("instituicao");
                String contacto = rs.getString("contacto");
                String dataEstadia = rs.getString("dataEstadia");
    
               
              
                Object[] linha = {nome, instituicao, contacto, dataEstadia};
                model.addRow(linha);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao buscar os dados: " + ex.getMessage());
        }
    }

     private boolean isValidDate(String dateStr) {
       try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate.parse(dateStr, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }


    private void excluirVisitante(String nome) {
        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String usuario = "root";
        String senha = "";
        String sql = "DELETE FROM visitantes WHERE nome = ?";
    
        try {
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            PreparedStatement declaracao = conexao.prepareStatement(sql);
    
            declaracao.setString(1, nome);
            declaracao.executeUpdate();
    
            JOptionPane.showMessageDialog(this, "Registro excluído com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao excluir registro do banco de dados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

}
