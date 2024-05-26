package admin;

import java.awt.*;
import java.awt.event.*;
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
        // //buscarDadosBaseDeDados();
        
        
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

    }

}
