package admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Visitantes extends JPanel{
    JPanel searchPanel, resultPanel,messagePanel;
    JTextField searchField;
    JButton searchButton,sendButton;
    JButton pesquisarButtonIcon;
    ImageIcon pesquisarIcon;
    JTextArea messageArea;

    public Visitantes(){
        setLayout(new BorderLayout());
        setBackground(Color.RED);
        add(new JLabel("visitantes"));
        


         // painel de pesquisa
        
        // painel de pesquisa
        searchPanel = new JPanel();
        searchPanel.setPreferredSize(new Dimension(935,60));
        searchPanel.setBackground(Color.lightGray);
        searchPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0,20));

        searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(500,30));

    
        pesquisarIcon = new ImageIcon("D:\\LICENCIATURA EM INFORMATICA\\3ANO\\1st\\JAVA\\projecto\\javaIconsProj\\pesquisar.png");
        pesquisarButtonIcon= new JButton(pesquisarIcon);
        pesquisarButtonIcon.setPreferredSize(new Dimension(40,30));
        pesquisarButtonIcon.setIcon(new ImageIcon(getScaledImage(pesquisarIcon.getImage(), 40, 30)));

         // painel de resultados
         JPanel mainPanel = new JPanel();
         mainPanel.setPreferredSize(new Dimension(935,700));
         mainPanel.setLayout(new BorderLayout());
 
         resultPanel = new JPanel();
         resultPanel.setPreferredSize(new Dimension(935,350));
         resultPanel.setBackground(Color.DARK_GRAY);
         resultPanel.setLayout(new FlowLayout(FlowLayout.LEADING,52,2));
         
         JPanel resultTextPanel = new JPanel();
         resultTextPanel.setPreferredSize(new Dimension(530,290));
         resultTextPanel.setBackground(Color.ORANGE);
         resultPanel.add(resultTextPanel);
         
         JPanel resultInfoPanel = new JPanel();
         resultInfoPanel.setPreferredSize(new Dimension(250,500));
         resultInfoPanel.setBackground(Color.CYAN);   
               
         searchPanel.add(searchField);
         searchPanel.add(pesquisarButtonIcon);
         add(searchPanel,BorderLayout.NORTH);
    }

    private Image getScaledImage(Image srcImg, int width, int height) {

        return srcImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        
    }
}
