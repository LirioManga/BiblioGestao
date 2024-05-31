package bibliotecario;


import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.*;

public class BibliotecarioHome extends JPanel{

    public BibliotecarioHome(){
        
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
        nameBibliotecario.setText("Livros");
        nameBibliotecario.setBounds(100,10, 270,30);
        nameBibliotecario.setFont(new Font("Arial", Font.PLAIN, 30));
        panelNrBibliotecarios.add(nameBibliotecario);
        
        
        JLabel nrBibliotecariosLabel = new JLabel();
        nrBibliotecariosLabel.setText(String.valueOf(5));
        nrBibliotecariosLabel.setBounds(130,70,50,40);
        nrBibliotecariosLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        panelNrBibliotecarios.add(nrBibliotecariosLabel);
        
        
        panelNrVisitante = new JPanel();
        panelNrVisitante.setLayout(null);
        panelNrVisitante.setBackground(Color.decode("#A65179"));
        firstSubPanel.add(panelNrVisitante);
        
        JLabel nameVisitanteJLabel = new JLabel();
        nameVisitanteJLabel.setText("Artigos");
        nameVisitanteJLabel.setBounds(100,10, 270,30);
        nameVisitanteJLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        panelNrVisitante.add(nameVisitanteJLabel);
        
        
        JLabel nrVisitanteLabel = new JLabel();
        nrVisitanteLabel.setText(String.valueOf(5));
        nrVisitanteLabel.setBounds(130,70,50,40);
        nrVisitanteLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        panelNrVisitante.add(nrVisitanteLabel);

        
        nrTotal = new JPanel();
        nrTotal.setLayout(null);
        nrTotal.setBackground(Color.decode("#A3A660"));
        firstSubPanel.add(nrTotal);
        
        JLabel nameNrTotalLabel = new JLabel();
        nameNrTotalLabel.setText("Monografias");
        nameNrTotalLabel.setBounds(100,10, 270,30);
        nameNrTotalLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        nrTotal.add(nameNrTotalLabel);
        
        
        JLabel nrTotalLabel = new JLabel();
        nrTotalLabel.setText(String.valueOf(5 + 5));
        nrTotalLabel.setBounds(130,70,50,40);
        nrTotalLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        nrTotal.add(nrTotalLabel);
     
        JPanel secondSubPanel = new JPanel();
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
}
