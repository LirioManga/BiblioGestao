package admin;


import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bibliotecarios extends JPanel implements ActionListener{
    JPanel navegationPanel, contentPanel,messagePanel,searchPanel,deletePanel, mainActivosPanel, tableActivosPanel;
    JButton cadastroButton,bibliotecarioButton,actividadeButton;
    JTextField searchField;
    JButton submeterButton,deleteButton;
    CardLayout cardLayout;
    JButton pesquisarButtonIcon;
    ImageIcon pesquisarIcon;
    JPanel cadastroPanel, dadosPanel,formacaoPanel,dadosPessoaisPanel;
    

      // para o panel dos dados pessoais
      JLabel tituloLabel, idLabel, nomeLabel, emailLabel, senhaLabel, contactoLabel, sexoLabel;
      JTextField nomeTextField, emailTextField, contactoTextField, campoPesquisaTextField;
      JLabel labelImg, pesquisarLabelIcon;
      ImageIcon imagemBiliotecario, imagemBibliotecaria;
      JRadioButton femininoRadioButton, masculinoRadioButton;
      ButtonGroup sexo;
      JPanel sexoPanel;

      // tabela
        DefaultTableModel modelo;
        JTable tabela;
        JScrollPane scrollPane;

    public Bibliotecarios() {
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
        cadastroPanel = new JPanel();
        cadastroPanel.setBackground(Color.CYAN);
        // dados bibliotecario
        dadosPanel = new JPanel();
        dadosPanel.setBackground(Color.LIGHT_GRAY);
        dadosPanel.setPreferredSize(new Dimension(935, 400));
        dadosPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 15));
        cadastroPanel.add(dadosPanel);

        dadosPessoaisPanel = new JPanel();
        dadosPessoaisPanel.setPreferredSize(new Dimension(450, 380));
        dadosPessoaisPanel.setBackground(Color.PINK);

        formacaoPanel = new JPanel();
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

       
        mainActivosPanel = new JPanel();
        mainActivosPanel.setBackground(Color.LIGHT_GRAY);
        mainActivosPanel.setPreferredSize(new Dimension(935, 400));
        mainActivosPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        activosPanel.add(mainActivosPanel);

        tableActivosPanel = new JPanel();
        tableActivosPanel.setPreferredSize(new Dimension(800, 370));
        tableActivosPanel.setBackground(Color.green);


        modelo = new DefaultTableModel();

        modelo.addColumn("Nome");
        modelo.addColumn("Email");
        modelo.addColumn("Contacto");
        modelo.addColumn("Sexo");

        tabela = new JTable(modelo);
        tabela.setPreferredScrollableViewportSize(new Dimension(750, 370));
        tabela.setFillsViewportHeight(true);
        scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(0,0,750,250);
        tableActivosPanel.add(scrollPane);

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

         add(navegationPanel,BorderLayout.NORTH); 
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

    public void updatePanel(){
       //mainActivosPanel.remove(tableActivosPanel);
        dadosPanel.remove(formacaoPanel);
        dadosPessoaisPanel.setPreferredSize(new Dimension(600,380));
        cadastroButton.setText("Adicionar");
        bibliotecarioButton.setText("Disponiveis");
        revalidate();
        repaint();
    }

    public void itensDadosPessoais(){

      

        tituloLabel = new JLabel();
        tituloLabel.setText("Dados Pessoais");
        tituloLabel.setBounds(10, 10, 430, 40);
        tituloLabel.setFont(new Font("MV BOLI", Font.PLAIN, 20));

        Border linBorderTitulo = BorderFactory.createLineBorder(new Color(0xBDC7E6), 2);
        Border emptyBorderTitulo = BorderFactory.createEmptyBorder(0,50, 0, 20);
        Border compoundBorderTitulo = BorderFactory.createCompoundBorder(linBorderTitulo, emptyBorderTitulo);

        
        Border lineBorder = BorderFactory.createLineBorder(Color.BLACK, 2);
        Border emptyBorder = BorderFactory.createEmptyBorder(0, 10, 0, 10);
        Border compoundBorder = BorderFactory.createCompoundBorder(lineBorder, emptyBorder);
        tituloLabel.setBorder(compoundBorderTitulo);
        tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);

        imagemBiliotecario = new ImageIcon("D:\\LICENCIATURA EM INFORMATICA\\3ANO\\1st\\JAVA\\projecto\\javaIconsProj\\bibliotecario.png");
        imagemBibliotecaria = new ImageIcon("D:\\LICENCIATURA EM INFORMATICA\\3ANO\\1st\\JAVA\\projecto\\javaIconsProj\\bibliotecaria.png");
        pesquisarIcon = new ImageIcon("D:\\LICENCIATURA EM INFORMATICA\\3ANO\\1st\\JAVA\\projecto\\javaIconsProj\\pesquisar.png");

       

        labelImg = new JLabel(imagemBiliotecario);
        labelImg.setBounds(10, 80, 150, 170);
        labelImg.setBorder(lineBorder);
        labelImg.setIcon(new ImageIcon(getScaledImage(imagemBiliotecario.getImage(), 120, 120))); 

        nomeLabel = new JLabel("Nome");
        nomeLabel.setFont(new Font("Arial", Font.BOLD, 12));
        nomeLabel.setBounds(180, 80, 60, 20);

        nomeTextField = new JTextField(20);
        nomeTextField.setBounds(240, 80, 200, 25);

        contactoLabel = new JLabel("Contacto");
        contactoLabel.setFont(new Font("Arial", Font.BOLD, 12));
        contactoLabel.setBounds(180, 120, 60, 20);

        contactoTextField = new JTextField(20);
        contactoTextField.setBounds(240, 120, 200, 25);

        emailLabel = new JLabel("E-mail");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 12));
        emailLabel.setBounds(180, 160, 60, 20);

        emailTextField = new JTextField(20);
        emailTextField.setBounds(240, 160, 200, 25);

        masculinoRadioButton = new JRadioButton("Masculino");
        masculinoRadioButton.setFocusable(false);

        femininoRadioButton = new JRadioButton("Feminino");
        femininoRadioButton.setFocusable(false);

        sexo = new ButtonGroup();
        sexo.add(masculinoRadioButton);
        sexo.add(femininoRadioButton);

        sexoPanel = new JPanel();
        sexoPanel.setBounds(180, 220, 260, 50);
        sexoPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        sexoPanel.add(masculinoRadioButton);
        sexoPanel.add(femininoRadioButton);

        sexoLabel = new JLabel("Sexo");
        sexoLabel.setFont(new Font("Arial", Font.BOLD, 12));
        sexoLabel.setBounds(180, 200, 60, 20);

        dadosPessoaisPanel.setLayout(null);
        dadosPessoaisPanel.add(tituloLabel);
        dadosPessoaisPanel.add(labelImg);
        dadosPessoaisPanel.add(nomeLabel);
        dadosPessoaisPanel.add(nomeTextField);
        dadosPessoaisPanel.add(contactoLabel);
        dadosPessoaisPanel.add(contactoTextField);
        dadosPessoaisPanel.add(emailLabel);
        dadosPessoaisPanel.add(emailTextField);
        dadosPessoaisPanel.add(sexoLabel);
        dadosPessoaisPanel.add(sexoPanel);
       
        revalidate();
        repaint();

    }

    public void formacaoAcademica(){
        JLabel tituloLabel, instituicaoLabel, cursoLabel, grauLabel, anoLabel, certificacoesLabel, especializacaoLabel;
        JTextField instituicaoTextField, cursoTextField, grauTextField, anoTextField, certificacoesTextField, especializacaoTextField;

        tituloLabel = new JLabel();
        tituloLabel.setText("Formação Academica");
        tituloLabel.setBounds(10, 10, 430, 40);
        tituloLabel.setFont(new Font("MV BOLI", Font.PLAIN, 20));

        Border linBorderTitulo = BorderFactory.createLineBorder(new Color(0xBDC7E6), 2);
        Border emptyBorderTitulo = BorderFactory.createEmptyBorder(0,50, 0, 20);
        Border compoundBorderTitulo = BorderFactory.createCompoundBorder(linBorderTitulo, emptyBorderTitulo);

        
        Border lineBorder = BorderFactory.createLineBorder(Color.BLACK, 2);
        Border emptyBorder = BorderFactory.createEmptyBorder(0, 10, 0, 10);
        Border compoundBorder = BorderFactory.createCompoundBorder(lineBorder, emptyBorder);
        tituloLabel.setBorder(compoundBorderTitulo);
        tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);

        instituicaoLabel = new JLabel("Instituição:");
        instituicaoLabel.setFont(new Font("Arial", Font.BOLD, 12));
        instituicaoLabel.setBounds(20, 60, 100, 20);
        
        instituicaoTextField = new JTextField();
        instituicaoTextField.setBounds(150, 60, 200, 25);
        
        cursoLabel = new JLabel("Curso:");
        cursoLabel.setFont(new Font("Arial", Font.BOLD, 12));
        cursoLabel.setBounds(20, 100, 100, 20);
        
        cursoTextField = new JTextField();
        cursoTextField.setBounds(150, 100, 200, 25);
        
        grauLabel = new JLabel("Grau:");
        grauLabel.setFont(new Font("Arial", Font.BOLD, 12));
        grauLabel.setBounds(20, 140, 100, 20);
        
        grauTextField = new JTextField();
        grauTextField.setBounds(150, 140, 200, 25);
        
        anoLabel = new JLabel("Ano de Conclusão:");
        anoLabel.setFont(new Font("Arial", Font.BOLD, 12));
        anoLabel.setBounds(20, 180, 120, 20);
        
        anoTextField = new JTextField();
        anoTextField.setBounds(150, 180, 100, 25);
        
        certificacoesLabel = new JLabel("Certificações:");
        certificacoesLabel.setFont(new Font("Arial", Font.BOLD, 12));
        certificacoesLabel.setBounds(20, 220, 100, 20);
        
        certificacoesTextField = new JTextField();
        certificacoesTextField.setBounds(150, 220, 200, 25);
        
        especializacaoLabel = new JLabel("Especialização:");
        especializacaoLabel.setFont(new Font("Arial", Font.BOLD, 12));
        especializacaoLabel.setBounds(20, 260, 100, 20);
        
        especializacaoTextField = new JTextField();
        especializacaoTextField.setBounds(150, 260, 200, 25);


        formacaoPanel.setLayout(null);
        formacaoPanel.add(tituloLabel);
        formacaoPanel.add(instituicaoLabel);
        formacaoPanel.add(instituicaoTextField);
        formacaoPanel.add(cursoLabel);
        formacaoPanel.add(cursoTextField);
        formacaoPanel.add(grauLabel);
        formacaoPanel.add(grauTextField);
        formacaoPanel.add(anoLabel);
        formacaoPanel.add(anoTextField);
        formacaoPanel.add(certificacoesLabel);
        formacaoPanel.add(certificacoesTextField);
        formacaoPanel.add(especializacaoLabel);
        formacaoPanel.add(especializacaoTextField);

    }
}


