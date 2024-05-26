package admin;

import java.awt.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.*;

public class AdminHome extends JPanel{
    //int nrTotalBibliotecario, nrTotalVisitante, nrTotal;
    public AdminHome(){
        
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

     
        JPanel firstSubPanel = new JPanel(new GridLayout(1, 3, 10, 10)); // 1 linha, 3 colunas, espaço de 10px entre eles
        firstSubPanel.setBackground(Color.decode("#EEEEEE"));
        firstSubPanel.setBorder(new EmptyBorder(20, 0, 20, 0));
        //firstSubPanel.setBorder(BorderFactory.createTitledBorder("Primeiro Subpainel"));
        firstSubPanel.setPreferredSize(new Dimension(950,200));

        

        JPanel panelNrBibliotecarios, panelNrVisitante,nrTotal;

        panelNrBibliotecarios = new JPanel();
        panelNrBibliotecarios.setLayout(null);
        panelNrBibliotecarios.setBackground(Color.decode("#658CBF"));
        firstSubPanel.add(panelNrBibliotecarios);

        JLabel nameBibliotecario = new JLabel();
        nameBibliotecario.setText("Bibliotecarios");
        nameBibliotecario.setBounds(50,10, 270,30);
        nameBibliotecario.setFont(new Font("Arial", Font.PLAIN, 30));
        panelNrBibliotecarios.add(nameBibliotecario);
        
        
        JLabel nrBibliotecariosLabel = new JLabel();
        nrBibliotecariosLabel.setText(String.valueOf(getTotalBibliotecarios()));
        nrBibliotecariosLabel.setBounds(130,70,50,40);
        nrBibliotecariosLabel.setFont(new Font("Arial", Font.PLAIN, 35));
        panelNrBibliotecarios.add(nrBibliotecariosLabel);
        
        
        panelNrVisitante = new JPanel();
        panelNrVisitante.setLayout(null);
        panelNrVisitante.setBackground(Color.decode("#A65179"));
        firstSubPanel.add(panelNrVisitante);
        
        JLabel nameVisitanteJLabel = new JLabel();
        nameVisitanteJLabel.setText("Visitantes");
        nameVisitanteJLabel.setBounds(70,10, 270,30);
        nameVisitanteJLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        panelNrVisitante.add(nameVisitanteJLabel);
        
        
        JLabel nrVisitanteLabel = new JLabel();
        nrVisitanteLabel.setText(String.valueOf(getTotalVisitantes()));
        nrVisitanteLabel.setBounds(130,70,50,40);
        nrVisitanteLabel.setFont(new Font("Arial", Font.PLAIN, 35));
        panelNrVisitante.add(nrVisitanteLabel);

        
        nrTotal = new JPanel();
        nrTotal.setLayout(null);
        nrTotal.setBackground(Color.decode("#A3A660"));
        firstSubPanel.add(nrTotal);
        
        JLabel nameNrTotalLabel = new JLabel();
        nameNrTotalLabel.setText("Total Acessos");
        nameNrTotalLabel.setBounds(50,10, 270,30);
        nameNrTotalLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        nrTotal.add(nameNrTotalLabel);
        
        
        JLabel nrTotalLabel = new JLabel();
        nrTotalLabel.setText(String.valueOf(getTotalBibliotecarios() + getTotalVisitantes()));
        nrTotalLabel.setBounds(130,70,50,40);
        nrTotalLabel.setFont(new Font("Arial", Font.PLAIN, 35));
        nrTotal.add(nrTotalLabel);
     
        JPanel secondSubPanel = new JPanel();
        //ImageIcon imageIcon = new ImageIcon("D:\\LICENCIATURA EM INFORMATICA\\3ANO\\1st\\JAVA\\projecto\\javaIconsProj\\bibliotecaHome.jpg");
        //Image scaledImage = getScaledImage(imageIcon.getImage(), 950, 400);
        //JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
        //secondSubPanel.add(imageLabel);
        //secondSubPanel.setBorder(BorderFactory.createTitledBorder("Segundo Subpainel"));
        secondSubPanel.setBackground(Color.LIGHT_GRAY);
        secondSubPanel.setPreferredSize(new Dimension(450,380));
        secondSubPanel.add(new JLabel("Aqui pode estar o conteúdo do segundo subpainel."));
        secondSubPanel.setBorder(new EmptyBorder(0, 20, 20, 20));


        this.setBorder(new EmptyBorder(15,15,15,15));

        add(firstSubPanel, BorderLayout.NORTH);
        add(secondSubPanel, BorderLayout.SOUTH);


        repaint();
        revalidate();
    }

     private int getTotalBibliotecarios() {
        int total = 0;
       
            String url = "jdbc:mysql://localhost:3306/biblioteca";
            String usuarioBD = "root";
            String senhaBD = "";
        
            try {
                Connection conexao = DriverManager.getConnection(url, usuarioBD, senhaBD);
                String sql = "SELECT COUNT(*) AS total FROM bibliotecario";
                PreparedStatement pstmt = conexao.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    total = rs.getInt("total");
                }
                
               
                conexao.close();
            } catch (SQLException g) {
                JOptionPane.showMessageDialog(null, "Erro ao buscar dados no banco de dados: " + g.getMessage());
            }
        
        return total; 
        
    }
     private int getTotalVisitantes() {
        int total = 0;
       
            String url = "jdbc:mysql://localhost:3306/biblioteca";
            String usuarioBD = "root";
            String senhaBD = "";
        
            try {
                Connection conexao = DriverManager.getConnection(url, usuarioBD, senhaBD);
                String sql = "SELECT COUNT(*) AS total FROM visitantes";
                PreparedStatement pstmt = conexao.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    total = rs.getInt("total");
                }
                
               
                conexao.close();
            } catch (SQLException g) {
                JOptionPane.showMessageDialog(null, "Erro ao buscar dados no banco de dados: " + g.getMessage());
            }
        
        return total; 
        
    }


    private Image getScaledImage(Image srcImg, int width, int height) {
        return srcImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }
}
