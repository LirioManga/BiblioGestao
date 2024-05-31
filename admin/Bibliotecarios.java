package admin;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Bibliotecarios extends JPanel implements ActionListener{

    JPanel navegationPanel,contentPanel;

    JPanel messagePanel,searchPanel,deletePanel, mainActivosPanel, tableActivosPanel;
    JButton cadastroButton,bibliotecarioButton,actividadeButton;
    JTextField searchField;
    JButton submeterButton,deleteButton, cancelelarButton;
    JButton pesquisarButtonIcon,escolherImagemButton;
    ImageIcon pesquisarIcon;
    JPanel cadastroPanel, dadosPanel,formacaoPanel,dadosPessoaisPanel;

      // para o panel dos dados pessoais
      JLabel tituloLabel, idLabel, nomeLabel, emailLabel, senhaLabel, contactoLabel, sexoLabel;
      JTextField nomeTextField, emailTextField, contactoTextField, campoPesquisaTextField;
      JLabel labelImg, pesquisarLabelIcon;
      ImageIcon imagemBiliotecario, imagemBibliotecaria;
      JRadioButton femininoRadioButton, masculinoRadioButton;
      ButtonGroup sexo;
      JPanel sexoPanel,actividadePanel, activosPanel, submeterPanel;


    // tabela de activos
    DefaultTableModel modelo;
    JTable tabela;
    JScrollPane scrollPane;

    CardLayout cardLayout;

    public Bibliotecarios(){
        setLayout(new BorderLayout());
       // setBackground(Color.BLUE);

        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);

        // painéis individuais para cada botão
        cadastroPanel = new JPanel();
        //cadastroPanel.setBackground(Color.CYAN);
        // dados bibliotecario
        dadosPanel = new JPanel();
        dadosPanel.setBackground(Color.white);
        dadosPanel.setPreferredSize(new Dimension(935, 450));
        dadosPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 15));
        cadastroPanel.add(dadosPanel);

        dadosPessoaisPanel = new JPanel();
        dadosPessoaisPanel.setPreferredSize(new Dimension(450, 380));
        dadosPessoaisPanel.setBackground(Color.decode("#edf2f2"));

        formacaoPanel = new JPanel();
        formacaoPanel.setPreferredSize(new Dimension(450, 380));
        formacaoPanel.setBackground(Color.decode("#edf2f2"));

        dadosPanel.add(itensDadosPessoais());
        dadosPanel.add(formacaoAcademica());
        

        submeterPanel = new JPanel();
        submeterPanel.setPreferredSize(new Dimension(935,60));
        submeterPanel.setLayout(new FlowLayout(FlowLayout.CENTER,15,20));
        
        submeterButton = new JButton("Submeter");
        submeterButton.setPreferredSize(new Dimension(100,30));
        submeterButton.setFocusable(false);
        submeterButton.addActionListener(this);
        submeterPanel.add(submeterButton);
          
        
        cancelelarButton = new JButton("Cancelar");
        cancelelarButton.setPreferredSize(new Dimension(100,30));
        cancelelarButton.setFocusable(false);
        cancelelarButton.addActionListener(this);
        submeterPanel.add(cancelelarButton);

        cadastroPanel.add(submeterPanel, BorderLayout.SOUTH);
        

        // panel dos activos ou disponiveis
        activosPanel = new JPanel();
       // activosPanel.setBackground(Color.DARK_GRAY);
        activosPanel.setLayout(new BorderLayout());
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

       
        mainActivosPanel = new JPanel();
        //mainActivosPanel.setBackground(Color.LIGHT_GRAY);
        mainActivosPanel.setPreferredSize(new Dimension(935, 400));
        mainActivosPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        activosPanel.add(mainActivosPanel);

        tableActivosPanel = new JPanel();
        //tableActivosPanel.setPreferredSize(new Dimension(950, 450));
        //tableActivosPanel.setBackground(Color.green);


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
      
        buscarDadosBaseDeDados();

        tableActivosPanel.add(scrollPane);
        mainActivosPanel.add(tableActivosPanel);
        
        JPanel deletePanel = new JPanel();
        deletePanel.setPreferredSize(new Dimension(935,60));
        deletePanel.setLayout(new FlowLayout(FlowLayout.CENTER,5,20));
        
        deleteButton = new JButton("Excluir");
        deleteButton.setPreferredSize(new Dimension(100,30));
        deleteButton.setFocusable(false);
        deleteButton.addActionListener(this);
        deletePanel.add(deleteButton);
        activosPanel.add(deletePanel, BorderLayout.SOUTH);
        activosPanel.add(searchPanel, BorderLayout.NORTH);

        actividadePanel = new JPanel();
        actividadePanel.setBackground(Color.ORANGE);

        contentPanel.add(cadastroPanel, "Cadastro");
        contentPanel.add(activosPanel, "Activos");
        contentPanel.add(actividadePanel, "Actividade");


         add(navegacaoBibliotecarioPanel(),BorderLayout.NORTH); 
         add(contentPanel,BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == cadastroButton) {
            cardLayout.show(contentPanel, "Cadastro");
        } else if (e.getSource() == bibliotecarioButton) {
            cardLayout.show(contentPanel, "Activos");
        } else if (e.getSource() == actividadeButton) {
            cardLayout.show(contentPanel, "Actividade");
        }else if(e.getSource() == escolherImagemButton){

            JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    ImageIcon newImageIcon = new ImageIcon(selectedFile.getAbsolutePath());
                    labelImg.setIcon(new ImageIcon(getScaledImage(newImageIcon.getImage(), 120, 120)));
                }
        }else if(e.getSource() == pesquisarButtonIcon){
            pesquisarBibliotecario();
        }else if(e.getSource() == deleteButton){
            int rowIndex = tabela.getSelectedRow();
            if (rowIndex != -1) {
                String nome = (String) tabela.getValueAt(rowIndex, 0); 
                excluirBibliotecario(nome);
               
                ((DefaultTableModel) tabela.getModel()).removeRow(rowIndex); 
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um registro para excluir.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }else if(e.getSource() == submeterButton){
            enviarDadosParaBase();
        }else if(e.getSource() == cancelelarButton){
            nomeTextField.setText("");
            emailTextField.setText("");
            contactoTextField.setText("");
        }
    }

    public JPanel navegacaoBibliotecarioPanel(){
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


        return navegationPanel;
    }


    private Image getScaledImage(Image srcImg, int width, int height) {

        return srcImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        
    }

    public JPanel itensDadosPessoais(){

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

        escolherImagemButton = new JButton("Escolher Imagem");
        escolherImagemButton.setBounds(10, 260, 150, 25);
        escolherImagemButton.setFocusable(false);
        escolherImagemButton.addActionListener(this);
          

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
        dadosPessoaisPanel.add(escolherImagemButton);
       
       
        return dadosPessoaisPanel;
        
    }


    public JPanel formacaoAcademica(){

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


        return formacaoPanel;
    }


    public void pesquisarBibliotecario() {
        String searchTerm = searchField.getText().trim();
        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String usuario = "root";
        String senha = "";
        
        String sql = "SELECT nome, email, contacto, sexo FROM bibliotecario WHERE nome LIKE ?";
        
        try (Connection conn = DriverManager.getConnection(url, usuario, senha);
        PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, "%" + searchTerm + "%");
            ResultSet rs = stmt.executeQuery();
            
            DefaultTableModel model = (DefaultTableModel) tabela.getModel();
            model.setRowCount(0);
            
            
            while (rs.next()) {
                
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String contacto = rs.getString("contacto");
                String sexo = rs.getString("sexo");
                
                
                
                Object[] linha = {nome, email, contacto, sexo};
                model.addRow(linha);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao buscar os dados: " + ex.getMessage());
        }
    }


    private void excluirBibliotecario(String nome) {
        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String usuario = "root";
        String senha = "";
        String sql = "DELETE FROM bibliotecario WHERE nome = ?";
    
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


    private void buscarDadosBaseDeDados() {
        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String usuario = "root";
        String senha = "";
        
        String sql = "SELECT nome, contacto, email, sexo FROM bibliotecario";
        
        try (Connection conexao = DriverManager.getConnection(url, usuario, senha);
        PreparedStatement declaracao = conexao.prepareStatement(sql);
        ResultSet resultado = declaracao.executeQuery()) {

     
            DefaultTableModel model = (DefaultTableModel) tabela.getModel();
            model.setRowCount(0);

            
            while (resultado.next()) {
                String nome = resultado.getString("nome");
                String contacto = resultado.getString("contacto");
                String email = resultado.getString("email");
                String sexo = resultado.getString("sexo");

                Object[] linha = {nome, email, contacto, sexo};
                model.addRow(linha);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar dados no banco de dados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void enviarDadosParaBase() {
        String nome = nomeTextField.getText();
        String email = emailTextField.getText();
        String contacto = contactoTextField.getText();
        String sexo = masculinoRadioButton.isSelected() ? "M" : "F";

        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String usuario = "root";
        String senha = "";

        

        
        try {
            Connection conn = DriverManager.getConnection(url, usuario, senha);
            String sql = "INSERT INTO bibliotecario (nome, email, contacto, sexo) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, contacto);
            stmt.setString(4, sexo);

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Dados inseridos com sucesso!");

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao inserir os dados: " + ex.getMessage());
        }
        nomeTextField.setText("");
        emailTextField.setText("");
        contactoTextField.setText("");
         
        buscarDadosBaseDeDados();
    }
  
}
