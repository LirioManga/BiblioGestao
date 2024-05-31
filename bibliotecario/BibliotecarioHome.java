package bibliotecario;


import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.*;

import javax.swing.*;


public class BibliotecarioHome extends JPanel{
    JLabel nrMonografiasLabel,nrArtigosLabel,nrLivrosLabel,nrBibliotecariosLabel; 
    public BibliotecarioHome(){
        
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

     
        JPanel firstSubPanel = new JPanel(new GridLayout(1, 3, 10, 10)); // 1 linha, 3 colunas, espaço de 10px entre eles
        firstSubPanel.setBackground(Color.decode("#EEEEEE"));
        firstSubPanel.setBorder(new EmptyBorder(20, 0, 20, 0));
        firstSubPanel.setPreferredSize(new Dimension(950,200));

        

        JPanel panelNrLivros, panelNrArtigos,panelNrMonografia;

        panelNrLivros = new JPanel();
        panelNrLivros.setLayout(null);
        panelNrLivros.setBackground(Color.decode("#658CBF"));
        firstSubPanel.add(panelNrLivros);

        nrLivrosLabel = new JLabel();
        nrLivrosLabel.setText("Livros");
        nrLivrosLabel.setBounds(100,10, 270,30);
        nrLivrosLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        panelNrLivros.add(nrLivrosLabel);
        
        
        nrBibliotecariosLabel = new JLabel();
        nrBibliotecariosLabel.setBounds(130,70,50,40);
        nrBibliotecariosLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        panelNrLivros.add(nrBibliotecariosLabel);
        
        
        panelNrArtigos = new JPanel();
        panelNrArtigos.setLayout(null);
        panelNrArtigos.setBackground(Color.decode("#A65179"));
        firstSubPanel.add(panelNrArtigos);
        
        JLabel nameVisitanteJLabel = new JLabel();
        nameVisitanteJLabel.setText("Artigos");
        nameVisitanteJLabel.setBounds(100,10, 270,30);
        nameVisitanteJLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        panelNrArtigos.add(nameVisitanteJLabel);
        
        
         nrArtigosLabel = new JLabel();
        nrArtigosLabel.setBounds(130,70,50,40);
        nrArtigosLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        panelNrArtigos.add(nrArtigosLabel);

        
        panelNrMonografia = new JPanel();
        panelNrMonografia.setLayout(null);
        panelNrMonografia.setBackground(Color.decode("#A3A660"));
        firstSubPanel.add(panelNrMonografia);
        
        JLabel nameNrTotalLabel = new JLabel();
        nameNrTotalLabel.setText("Monografias");
        nameNrTotalLabel.setBounds(100,10, 270,30);
        nameNrTotalLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        panelNrMonografia.add(nameNrTotalLabel);
        
        
        nrMonografiasLabel = new JLabel();
        nrMonografiasLabel.setBounds(130,70,50,40);
        nrMonografiasLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        panelNrMonografia.add(nrMonografiasLabel);
     
        JPanel secondSubPanel = new JPanel();
        secondSubPanel.setBackground(Color.LIGHT_GRAY);
        secondSubPanel.setPreferredSize(new Dimension(450,380));
        secondSubPanel.setBorder(new EmptyBorder(0, 20, 20, 20));


        this.setBorder(new EmptyBorder(15,15,15,15));
        add(firstSubPanel, BorderLayout.NORTH);
        add(secondSubPanel, BorderLayout.SOUTH);


        dadosEstatisticos();

        repaint();
        revalidate();
    }

    private void dadosEstatisticos() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
            statement = connection.createStatement();

            
            resultSet = statement.executeQuery("SELECT COUNT(*) AS count FROM livros");
            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                nrBibliotecariosLabel.setText(String.valueOf(count));
            }

            resultSet = statement.executeQuery("SELECT COUNT(*) AS count FROM artigos");
            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                nrArtigosLabel.setText(String.valueOf(count));
            }

          
            // resultSet = statement.executeQuery("SELECT COUNT(*) AS count FROM monografias");
            // if (resultSet.next()) {
            //     int count = resultSet.getInt("count");
            //     nrMonografiasLabel.setText(String.valueOf(count));
            // }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
    
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
