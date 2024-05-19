package biblioteca;

import javax.swing.*;
import java.awt.*;

public class LivrosPanel extends JPanel {

    JPanel searchPanel, resultPanel,messagePanel;
    JTextField searchField;
    JButton searchButton,sendButton;
    JButton pesquisarButtonIcon;
    ImageIcon pesquisarIcon;
    JTextArea messageArea;

    public LivrosPanel() {
       // setLayout(new BorderLayout());
        setBackground(Color.RED);
        
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
        mainPanel.setPreferredSize(new Dimension(935,470));
        mainPanel.setLayout(new BorderLayout());

        resultPanel = new JPanel();
        resultPanel.setPreferredSize(new Dimension(935,350));
        resultPanel.setBackground(Color.DARK_GRAY);
        resultPanel.setLayout(new FlowLayout(FlowLayout.CENTER,52,2));
        
        JPanel resultTextPanel = new JPanel();
        resultTextPanel.setPreferredSize(new Dimension(530,290));
        resultTextPanel.setBackground(Color.ORANGE);
        resultPanel.add(resultTextPanel);
        
        JPanel resultInfoPanel = new JPanel();
        resultInfoPanel.setPreferredSize(new Dimension(250,340));
        resultInfoPanel.setBackground(Color.CYAN);   
              
        resultPanel.add(resultInfoPanel);
        mainPanel.add(resultPanel, BorderLayout.NORTH);
        
        // painel de envio de mensagem
        messagePanel = new JPanel();
        messagePanel.setPreferredSize(new Dimension(300,140));
        messagePanel.setLayout(null);
        messagePanel.setBackground(Color.BLUE);


        sendButton = new JButton("Enviar");
        sendButton.setFocusable(false);
        sendButton.setBounds(215,80,80,30);

        messageArea = new JTextArea();
        messageArea.setBounds(10,5,200,110);
        messagePanel.add(messageArea);
        messagePanel.add(sendButton);
        mainPanel.add(messagePanel,BorderLayout.WEST);
        
        // adicao de elementos
        searchPanel.add(searchField);
        searchPanel.add(pesquisarButtonIcon);
        add(searchPanel,BorderLayout.NORTH);
        add(mainPanel,BorderLayout.CENTER);
        
      
        
    }

    private Image getScaledImage(Image srcImg, int width, int height) {

        return srcImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        
    }
}
