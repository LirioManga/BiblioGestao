package visitante;


import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

public class Artigos extends JPanel implements ActionListener{

    
    JPanel panelTitle,panelItens, panelContent, panelCadastroLivros, submeterPanel;
   
    JPanel informacaoInternaPanel, informacaoAdicionalPanel,searchPanel;
    JTextField textEditora, textAutor, textArea, textTitulo, textIdioma, textNumeroPaginas, textLocalizacaoFisica, textISBN, textDataAquisicao, textNumeroCopias, textCodigoBarras;
    JTextArea textResumo;
    CardLayout cardLayout;
    JButton submeterButton,cancelarButton,pesquisarButtonIcon;
    JLabel labelImg, pesquisarLabelIcon;
    ImageIcon pesquisarIcon;
    JTextField searchField;

    public Artigos(){
        setLayout(new BorderLayout());
        setBackground(Color.green);


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(cadastroLivros());
       // mainPanel.add(submeterPanel());


        add(mainPanel, BorderLayout.CENTER);

        repaint();
        revalidate();
    }




    public JPanel cadastroLivros() {
        panelCadastroLivros = new JPanel();
        panelCadastroLivros.setPreferredSize(new Dimension(600, 650));
        panelCadastroLivros.setBackground(Color.green);
        panelCadastroLivros.setLayout(new BorderLayout());

        searchPanel = new JPanel();
        searchPanel.setPreferredSize(new Dimension(935,40));
        //searchPanel.setBackground(Color.blue);
        searchPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0,7));



        // // Inicializando pesquisarIcon e pesquisarButtonIcon
        searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(500,30));


        pesquisarIcon = new ImageIcon("D:\\LICENCIATURA EM INFORMATICA\\3ANO\\1st\\JAVA\\projecto\\javaIconsProj\\pesquisar.png");
        pesquisarButtonIcon = new JButton(pesquisarIcon);
        pesquisarButtonIcon.setPreferredSize(new Dimension(40, 30));
        pesquisarButtonIcon.addActionListener(this);
        pesquisarButtonIcon.setIcon(new ImageIcon(getScaledImage(pesquisarIcon.getImage(), 40, 30)));

        searchPanel.add(searchField);
        searchPanel.add(pesquisarButtonIcon);

       

        Border linBorderTitulo = BorderFactory.createLineBorder(new Color(0xBDC7E6), 2);
        Border emptyBorderTitulo = BorderFactory.createEmptyBorder(0, 50, 0, 20);
        Border compoundBorderTitulo = BorderFactory.createCompoundBorder(linBorderTitulo, emptyBorderTitulo);
        searchPanel.setBorder(compoundBorderTitulo);


        JPanel panelsContainer = new JPanel();
        panelsContainer.setLayout(new GridLayout(1, 2)); // 1 row, 2 columns

        informacaoInternaPanel = new JPanel();
        informacaoInternaPanel.setBackground(Color.lightGray);
        informacaoInternaPanel.setPreferredSize(new Dimension(500, 600));

        informacaoAdicionalPanel = new JPanel();
        informacaoAdicionalPanel.setBackground(Color.gray);
        informacaoAdicionalPanel.setPreferredSize(new Dimension(100, 600));



     
        JList<String> itemList = new JList<>();
        itemList.setPreferredSize(new Dimension(600, 550));
        JScrollPane listScrollPane = new JScrollPane(itemList);
        listScrollPane.setPreferredSize(new Dimension(470,500));
        informacaoInternaPanel.add(listScrollPane, BorderLayout.CENTER);

       
        JTextArea additionalInfoTextArea = new JTextArea();
        additionalInfoTextArea.setPreferredSize(new Dimension(500, 400));
        JScrollPane textAreaScrollPane = new JScrollPane(additionalInfoTextArea);
        informacaoAdicionalPanel.add(textAreaScrollPane, BorderLayout.CENTER);

        panelsContainer.add(informacaoInternaPanel);
        panelsContainer.add(informacaoAdicionalPanel);

        panelCadastroLivros.add(searchPanel, BorderLayout.NORTH);
        panelCadastroLivros.add(panelsContainer, BorderLayout.CENTER);

        return panelCadastroLivros;
    }

  

   
    private Image getScaledImage(Image srcImg, int width, int height) {

        return srcImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        
    }

    @Override 
    public void actionPerformed(ActionEvent e){
            
    }
}
