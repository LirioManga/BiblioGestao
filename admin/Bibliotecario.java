package admin;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bibliotecario extends JPanel implements ActionListener{
    JPanel navegationPanel, contentPanel,messagePanel,searchPanel,deletePanel;
    JButton cadastroButton,bibliotecarioButton,actividadeButton;
    JTextField searchField;
    JButton submeterButton,deleteButton;
    CardLayout cardLayout;
    JButton pesquisarButtonIcon;
    ImageIcon pesquisarIcon;
    
    public Bibliotecario() {
        setLayout(new BorderLayout());
        setBackground(Color.YELLOW);
        add(new JLabel("bibliotecario"));
        

         // painel de navegacao
        navegationPanel= new JPanel();
        navegationPanel.setPreferredSize(new Dimension(935,40));
        navegationPanel.setBackground(Color.lightGray);
        navegationPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5,20));

        cadastroButton = new JButton("Cadastro");
        cadastroButton.setFocusable(false);
        cadastroButton.setPreferredSize(new Dimension(90,20));
        cadastroButton.addActionListener(this);
        navegationPanel.add(cadastroButton);
        
        bibliotecarioButton = new JButton("Activos");
        bibliotecarioButton.setFocusable(false);
        bibliotecarioButton.setPreferredSize(new Dimension(120,20));
        bibliotecarioButton.addActionListener(this);
        navegationPanel.add(bibliotecarioButton);

        actividadeButton = new JButton("Actividade");
        actividadeButton.setFocusable(false);
        actividadeButton.setPreferredSize(new Dimension(120,20));
        actividadeButton.addActionListener(this);
        navegationPanel.add(actividadeButton);


        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);

        // painéis individuais para cada botão
        JPanel cadastroPanel = new JPanel();
        cadastroPanel.setBackground(Color.CYAN);
        // dados bibliotecario
        JPanel dadosPanel = new JPanel();
        dadosPanel.setBackground(Color.LIGHT_GRAY);
        dadosPanel.setPreferredSize(new Dimension(935, 400));
        dadosPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 15));
        cadastroPanel.add(dadosPanel);

        JPanel dadosPessoaisPanel = new JPanel();
        dadosPessoaisPanel.setPreferredSize(new Dimension(450, 380));
        dadosPessoaisPanel.setBackground(Color.PINK);

        JPanel formacaoPanel = new JPanel();
        formacaoPanel.setPreferredSize(new Dimension(450, 380));
        formacaoPanel.setBackground(Color.GREEN);

        dadosPanel.add(dadosPessoaisPanel);
        dadosPanel.add(formacaoPanel);

        JPanel submeterPanel = new JPanel();
        submeterPanel.setPreferredSize(new Dimension(935,60));
        submeterPanel.setLayout(new FlowLayout(FlowLayout.RIGHT,5,20));
        
        submeterButton = new JButton("Submeter");
        submeterButton.setPreferredSize(new Dimension(100,30));
        submeterButton.setFocusable(false);
        submeterPanel.add(submeterButton);
        cadastroPanel.add(submeterPanel, BorderLayout.CENTER);

        // panel dos activos
        JPanel activosPanel = new JPanel();
        activosPanel.setBackground(Color.DARK_GRAY);
        activosPanel.setLayout(new BorderLayout());
                    // painel de pesquisa
        searchPanel = new JPanel();
        searchPanel.setPreferredSize(new Dimension(935,60));
        searchPanel.setBackground(Color.blue);
        searchPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0,20));



        // Inicializando pesquisarIcon e pesquisarButtonIcon
        searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(500,30));


        pesquisarIcon = new ImageIcon("D:\\LICENCIATURA EM INFORMATICA\\3ANO\\1st\\JAVA\\projecto\\javaIconsProj\\pesquisar.png");
        pesquisarButtonIcon = new JButton(pesquisarIcon);
        pesquisarButtonIcon.setPreferredSize(new Dimension(40, 30));
        pesquisarButtonIcon.setIcon(new ImageIcon(getScaledImage(pesquisarIcon.getImage(), 40, 30)));

        searchPanel.add(searchField);
        searchPanel.add(pesquisarButtonIcon);

       
        JPanel mainActivosPanel = new JPanel();
        mainActivosPanel.setBackground(Color.LIGHT_GRAY);
        mainActivosPanel.setPreferredSize(new Dimension(935, 400));
        mainActivosPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        activosPanel.add(mainActivosPanel);

        JPanel tableActivosPanel = new JPanel();
        tableActivosPanel.setPreferredSize(new Dimension(650, 370));
        tableActivosPanel.setBackground(Color.green);

        mainActivosPanel.add(tableActivosPanel);
        

        JPanel deletePanel = new JPanel();
        deletePanel.setPreferredSize(new Dimension(935,60));
        deletePanel.setLayout(new FlowLayout(FlowLayout.RIGHT,5,20));
        
        deleteButton = new JButton("Excluir");
        deleteButton.setPreferredSize(new Dimension(100,30));
        deleteButton.setFocusable(false);
        deletePanel.add(deleteButton);
        activosPanel.add(deletePanel, BorderLayout.SOUTH);
        activosPanel.add(searchPanel, BorderLayout.NORTH);

    

        JPanel actividadePanel = new JPanel();
        actividadePanel.setBackground(Color.ORANGE);

        contentPanel.add(cadastroPanel, "Cadastro");
        contentPanel.add(activosPanel, "Activos");
        contentPanel.add(actividadePanel, "Actividade");

        add(contentPanel, BorderLayout.CENTER);

        // Define o painel inicial a ser exibido
        cardLayout.show(contentPanel, "Cadastro");

        
         // painel de resultados
         JPanel mainPanel = new JPanel();
         mainPanel.setPreferredSize(new Dimension(935,700));
         mainPanel.setLayout(new BorderLayout());
 
        
         
         JPanel resultInfoPanel = new JPanel();
         resultInfoPanel.setPreferredSize(new Dimension(250,500));
         resultInfoPanel.setBackground(Color.CYAN);   
               
         //resultPanel.add(resultInfoPanel);
         add(navegationPanel,BorderLayout.NORTH);
        
         //mainPanel.add(resultPanel, BorderLayout.CENTER);
         //add(mainPanel,)
  
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == cadastroButton) {
            cardLayout.show(contentPanel, "Cadastro");
        } else if (e.getSource() == bibliotecarioButton) {
            cardLayout.show(contentPanel, "Activos");
        } else if (e.getSource() == actividadeButton) {
            cardLayout.show(contentPanel, "Actividade");
        } 
    }

    private Image getScaledImage(Image srcImg, int width, int height) {

        return srcImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        
    }
}


