package administrador;
import bibliotecario.Home;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.*;

public class CadastroBibliotecario extends JFrame implements ActionListener, ItemListener{

    JLabel tituloLabel, idLabel, nomeLabel, emailLabel, senhaLabel, contactoLabel, sexoLabel;
    JTextField nomeTextField, emailTextField, contactoTextField, campoPesquisaTextField;
    JLabel labelImg, pesquisarLabelIcon;
    ImageIcon imagemBiliotecario, imagemBibliotecaria, pesquisarIcon;
    JRadioButton femininoRadioButton, masculinoRadioButton;
    ButtonGroup sexo;
    JPanel sexoPanel,tituloPanel;

    JButton concluirButton, excluirButton, pesquisarButton, voltarButton;
    DefaultTableModel modelo;
    JTable tabela;
    JScrollPane scrollPane;

    public CadastroBibliotecario() {

        // dados para cadastro

        tituloLabel = new JLabel();
        tituloLabel.setText("Cadastro de Bibliotecário");
        tituloLabel.setBounds(10, 10, 650, 40);
        tituloLabel.setFont(new Font("MV BOLI", Font.PLAIN, 20));

        Border linBorderTitulo = BorderFactory.createLineBorder(Color.BLACK, 2);
        Border emptyBorderTitulo = BorderFactory.createEmptyBorder(0,200, 0, 100);
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
        labelImg.setIcon(new ImageIcon(getScaledImage(imagemBiliotecario.getImage(), 150, 150))); // Redimensionando aqui


        nomeLabel = new JLabel("Nome");
        nomeLabel.setBounds(190, 80, 60,20);
        nomeLabel.setFont(new Font("Arial", Font.BOLD, 12));
        
        nomeTextField  = new JTextField();
        nomeTextField.setBounds(190, 110, 220,25);


        contactoLabel = new JLabel("Contacto");
        contactoLabel.setBounds(460,80,60,20);
        contactoLabel.setFont(new Font("Arial", Font.BOLD, 12));

        contactoTextField  = new JTextField();
        contactoTextField.setBounds(460, 110, 200,25);


        emailLabel = new JLabel("E-mail");
        emailLabel.setBounds(190,180,60,20);
        emailLabel.setFont(new Font("Arial", Font.BOLD, 12));

        emailTextField  = new JTextField();
        emailTextField.setBounds(190, 200, 220,25);
        
        
        
        masculinoRadioButton = new JRadioButton("Masculino");
        masculinoRadioButton.setFocusable(false);
        femininoRadioButton = new JRadioButton("Feminino");
        femininoRadioButton.setFocusable(false);

        sexo = new ButtonGroup();
        sexo.add(masculinoRadioButton);
        sexo.add(femininoRadioButton);

        masculinoRadioButton.addItemListener(this);
        femininoRadioButton.addItemListener(this);
        
        sexoPanel = new JPanel();
        sexoPanel.setBounds(460, 200, 200,50);
        sexoPanel.setBorder(compoundBorder);
        sexoPanel.add(masculinoRadioButton);
        sexoPanel.add(femininoRadioButton);
        
        sexoLabel = new JLabel("Sexo");
        sexoLabel.setBounds(460,180,60,20);
        sexoLabel.setFont(new Font("Arial", Font.BOLD, 12));

    
        concluirButton = new JButton("Concluir");
        concluirButton.setBounds(10,280,90,30);
        concluirButton.setFocusable(false);
        concluirButton.addActionListener(this);

        excluirButton = new JButton("Excluir");
        excluirButton.setBounds(140,280,90,30);
        excluirButton.setFocusable(false);
        excluirButton.addActionListener(this);

        pesquisarButton = new JButton(pesquisarIcon);
        pesquisarButton.setBounds(620,280,40,30);
        pesquisarButton.setFocusable(false);
        pesquisarButton.setIcon(new ImageIcon(getScaledImage(pesquisarIcon.getImage(), 40, 30)));
        pesquisarButton.addActionListener(this);

        voltarButton = new JButton("Voltar");
        voltarButton.setFocusable(false);
        voltarButton.setBounds(270, 280,90,30);
        voltarButton.addActionListener(this);


        campoPesquisaTextField = new JTextField();
        campoPesquisaTextField.setBounds(420,280,200,30);
        campoPesquisaTextField.addActionListener(this);
        //340
        // Tabela para visualizacao de dados
        modelo = new DefaultTableModel();

        modelo.addColumn("Nome");
        modelo.addColumn("Email");
        modelo.addColumn("Contacto");
        modelo.addColumn("Sexo");

        tabela = new JTable(modelo);

        scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(10, 320,660,140);

        // preenchendo a tabela com dados da base de dados
        buscarDadosBancoDeDados();

        // adicao de elementos

        add(tituloLabel);
        add(labelImg);
        add(nomeLabel);
        add(nomeTextField);
        add(contactoLabel);
        add(contactoTextField);
        add(emailLabel);
        add(emailTextField);
        add(sexoLabel);
        add(sexoPanel);
        add(concluirButton);
        add(excluirButton);
        add(scrollPane);
        add(campoPesquisaTextField);
        add(pesquisarButton);
        add(voltarButton);
        this.setTitle("Cadastro Bibliotecário");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(700, 500);
        this.setVisible(true);
    }

    private Image getScaledImage(Image srcImg, int width, int height) {

        return srcImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == concluirButton) {
            String nome = nomeTextField.getText();
            String contacto = contactoTextField.getText();
            String email = emailTextField.getText();
            String sexo = masculinoRadioButton.isSelected() ? "M" : "F";

           
            
            if (!contacto.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "O campo de contacto deve conter apenas números.", "Erro", JOptionPane.ERROR_MESSAGE);
            }else{
                inserirDadosBancoDeDados(nome, contacto, email, sexo);
            }
    
            System.out.print("dados obtidos");
            
        } else if(e.getSource() == pesquisarButton){
            String pesquisa = campoPesquisaTextField.getText();


            System.out.println("pesquisando");
            pesquisarNaBaseDeDados(pesquisa);

        }else if(e.getSource()== excluirButton){

            int rowIndex = tabela.getSelectedRow();
            if (rowIndex != -1) {
                String nome = (String) tabela.getValueAt(rowIndex, 0); // obtém o nome na coluna 0 (nome)
                removerDoBancoDeDados(nome);
                ((DefaultTableModel) tabela.getModel()).removeRow(rowIndex); // remove a linha da tabela
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um registro para excluir.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }else if(e.getSource()==voltarButton){
            dispose();
            new Home();
        }
    }



    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {

            if (e.getSource() == masculinoRadioButton) {
                labelImg.setIcon(new ImageIcon(getScaledImage(imagemBiliotecario.getImage(), 150, 150)));

            } else if (e.getSource() == femininoRadioButton) {
                labelImg.setIcon(new ImageIcon(getScaledImage(imagemBibliotecaria.getImage(), 150, 150)));
            }
        }
    }

    private void inserirDadosBancoDeDados(String nome, String contacto, String email, String sexo) {
        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String usuario = "root";
        String senha = "";
        
        String sql = "INSERT INTO bibliotecario (nome, contacto, email, sexo) VALUES (?, ?, ?, ?)";

        try (Connection conexao = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement declaracao = conexao.prepareStatement(sql)) {

            declaracao.setString(1, nome);
            declaracao.setString(2, contacto);
            declaracao.setString(3, email);
            declaracao.setString(4, sexo);

            declaracao.executeUpdate();

            JOptionPane.showMessageDialog(this, "Dados inseridos com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            Object[] novaLinha = {nome, email, contacto, sexo};
            modelo.addRow(novaLinha);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao inserir dados no banco de dados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void buscarDadosBancoDeDados() {
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


    private void pesquisarNaBaseDeDados(String pesquisa) {
        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String usuario = "root";
        String senha = "";
        
        String sql = "SELECT nome, contacto, email, sexo FROM bibliotecario WHERE nome LIKE ?";
    
        try (Connection conexao = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement declaracao = conexao.prepareStatement(sql)) {
    
         
            declaracao.setString(1, "%" + pesquisa + "%");
    
        
            ResultSet resultado = declaracao.executeQuery();
    
         
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
            JOptionPane.showMessageDialog(this, "Erro ao pesquisar na base de dados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void removerDoBancoDeDados(String nome) {
        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String usuario = "root";
        String senha = "";
        String sql = "DELETE FROM bibliotecario WHERE nome = ?";
    
        try (Connection conexao = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement declaracao = conexao.prepareStatement(sql)) {
    
            declaracao.setString(1, nome);
            declaracao.executeUpdate();
    
            JOptionPane.showMessageDialog(this, "Registro excluído com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao excluir registro do banco de dados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
