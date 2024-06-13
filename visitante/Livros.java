package visitante;


import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Livros extends JPanel implements ActionListener{

    
    JPanel panelTitle,panelItens, panelContent, panelCadastroLivros, submeterPanel;
   
    JPanel informacaoInternaPanel, informacaoAdicionalPanel,searchPanel;
    JTextField textEditora, textAutor, textTitulo, textIdioma, textNumeroPaginas, textLocalizacaoFisica, textISBN, textDataAquisicao, textNumeroCopias, textCodigoBarras;
    JTextArea textResumo;
    CardLayout cardLayout;
    JButton submeterButton,cancelarButton,pesquisarButtonIcon;
    JLabel labelImg, pesquisarLabelIcon;
    ImageIcon pesquisarIcon;
    JTextField searchField;
    JList<String> list;
    JScrollPane listScrollPane;
    JTextArea textArea;

   
    

    public Livros(){
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
        
        informacaoAdicionalPanel = new JPanel(new FlowLayout());
        informacaoInternaPanel = new JPanel();
        informacaoInternaPanel.setBackground(Color.lightGray);
        informacaoInternaPanel.setPreferredSize(new Dimension(600, 400));


        JPanel informacaoAdicionalPanel1 = new JPanel();
        //informacaoAdicionalPanel1.setBackground(Color.yellow);
        informacaoAdicionalPanel1.setPreferredSize(new Dimension(650, 400));
        list = new JList<>();
        JScrollPane listScrollPane = new JScrollPane(list);
        listScrollPane.setPreferredSize(new Dimension(650,390));
        informacaoAdicionalPanel1.add(listScrollPane);

        JPanel informacaoAdicionalPanel2 = new JPanel();
        //informacaoAdicionalPanel2.setBackground(Color.blue);
        informacaoAdicionalPanel2.setPreferredSize(new Dimension(253, 250));
        TitledBorder titledBorder = BorderFactory.createTitledBorder("Detalhes");       
        informacaoAdicionalPanel2.setBorder(titledBorder);
        textArea = new JTextArea(); 
        textArea.setPreferredSize(new Dimension(245,220));
        textArea.setEditable(false);
        textArea.setLineWrap(true); 
        textArea.setWrapStyleWord(true); 
        JScrollPane scrollPane = new JScrollPane(textArea);
        informacaoAdicionalPanel2.add(scrollPane);

        informacaoAdicionalPanel.add(Box.createVerticalGlue());
        
        informacaoAdicionalPanel.add(informacaoAdicionalPanel1);
        informacaoAdicionalPanel.add(Box.createRigidArea(new Dimension(10, 50)));
        informacaoAdicionalPanel.add(informacaoAdicionalPanel2);
       
        JPanel panelMensagem = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelMensagem.setPreferredSize(new Dimension(600, 100));
        //panelMensagem.setBackground(Color.PINK);

       
        JTextArea mensagemTextArea = new JTextArea(5, 40); 
        mensagemTextArea.setLineWrap(true);
        mensagemTextArea.setWrapStyleWord(true);
        mensagemTextArea.setEditable(false);
        JButton enviarButton = new JButton("Enviar");

        panelMensagem.add(new JScrollPane(mensagemTextArea));
        panelMensagem.add(Box.createRigidArea(new Dimension(0, 50))); 
        panelMensagem.add(enviarButton);

      
       panelCadastroLivros.add(searchPanel, BorderLayout.NORTH);
       panelCadastroLivros.add(informacaoAdicionalPanel,BorderLayout.CENTER);
       panelCadastroLivros.add(panelMensagem, BorderLayout.SOUTH);

       list.addListSelectionListener(e -> {
        if (!e.getValueIsAdjusting()) {
            String selectedTitle = list.getSelectedValue();
            if (selectedTitle != null) {
                mostrarDetalhesDoLivro(selectedTitle);
            }
        }
    });

        return panelCadastroLivros;
    }

  

   
    private Image getScaledImage(Image srcImg, int width, int height) {

        return srcImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        
    }

    @Override 
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == pesquisarButtonIcon){
            pesquisarLivro();
        }
    }


    private void pesquisarLivro() {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        String searchText = searchField.getText().trim();

        if (searchText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um termo de pesquisa.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "")) {
            String query = "SELECT titulo FROM livros WHERE titulo LIKE ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, "%" + searchText + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String titulo = rs.getString("titulo");
                listModel.addElement(titulo);
            }

            if (listModel.isEmpty()) {
                listModel.addElement("Nenhum livro encontrado.");
            }

            list.setModel(listModel);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao acessar a base de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void mostrarDetalhesDoLivro(String titulo) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "")) {
            String query = "SELECT * FROM livros WHERE titulo = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, titulo);
            ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            String detalhes = "Título: " + rs.getString("titulo") + "\n"
                    + "Autor: " + rs.getString("autor") + "\n"
                    + "Editora: " + rs.getString("editora") + "\n";                   
                   
            textArea.setText(detalhes);
        } else {
            textArea.setText("Detalhes do livro não encontrados.");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Erro ao acessar a base de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
    }

    }
    
}
