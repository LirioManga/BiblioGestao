package bibliotecario;


import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

public class Artigos extends JPanel implements ActionListener{

    
    JPanel panelTitle,panelItens, panelContent, panelCadastroLivros, submeterPanel;
   
    JPanel informacaoInternaPanel, informacaoAdicionalPanel;
    JTextField textEditora, textAutor, textArea, textTitulo, textIdioma, textNumeroPaginas, textLocalizacaoFisica, textISBN, textDataAquisicao, textNumeroCopias, textCodigoBarras;
    JTextArea textResumo;
    CardLayout cardLayout;
    JButton submeterButton,cancelarButton;
    public Artigos(){
        setLayout(new BorderLayout());
        setBackground(Color.green);


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(cadastroArtigo());
        mainPanel.add(submeterPanel());


        add(mainPanel, BorderLayout.CENTER);

        repaint();
        revalidate();
    }




    public JPanel cadastroArtigo() {
        panelCadastroLivros = new JPanel();
        panelCadastroLivros.setPreferredSize(new Dimension(600, 650));
        panelCadastroLivros.setBackground(Color.green);
        panelCadastroLivros.setLayout(new BorderLayout());

        // Título
        JLabel tituloLabel = new JLabel();
        tituloLabel.setText("Informações do Artigo");
        tituloLabel.setPreferredSize(new Dimension(530, 40));
        tituloLabel.setFont(new Font("MV BOLI", Font.PLAIN, 20));
        tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);

        Border linBorderTitulo = BorderFactory.createLineBorder(new Color(0xBDC7E6), 2);
        Border emptyBorderTitulo = BorderFactory.createEmptyBorder(0, 50, 0, 20);
        Border compoundBorderTitulo = BorderFactory.createCompoundBorder(linBorderTitulo, emptyBorderTitulo);
        tituloLabel.setBorder(compoundBorderTitulo);

        panelCadastroLivros.add(tituloLabel, BorderLayout.NORTH);

      
        // Painel de referencias
            informacaoInternaPanel = new JPanel();
            informacaoInternaPanel.setLayout(new GridLayout(7, 1, 10, 10));
            informacaoInternaPanel.setBorder(BorderFactory.createTitledBorder("Referências"));

            // Criando e adicionando pequenos painéis para cada campo
            addLabelAndTextField(informacaoInternaPanel, "Título do Livro");
            addLabelAndTextField(informacaoInternaPanel, "Autor");
            addLabelAndTextField(informacaoInternaPanel, "Ano de Publicação");
            addLabelAndTextField(informacaoInternaPanel, "Área/Categoria");
            addLabelAndTextField(informacaoInternaPanel, "Idioma");
          

                    // Painel de Informações Adicionais
        informacaoAdicionalPanel = new JPanel();
        informacaoAdicionalPanel.setLayout(new GridLayout(8, 2, 10, 10));
        informacaoAdicionalPanel.setBorder(BorderFactory.createTitledBorder("Informação Interna"));

        informacaoAdicionalPanel.add(new JLabel("Código"));
        textCodigoBarras = new JTextField();
        textCodigoBarras.setPreferredSize(new Dimension(300, 30));
        informacaoAdicionalPanel.add(textCodigoBarras);

        
        informacaoAdicionalPanel.add(new JLabel("Número de Páginas"));
        textNumeroPaginas = new JTextField();
        textNumeroPaginas.setPreferredSize(new Dimension(300, 30));
        informacaoAdicionalPanel.add(textNumeroPaginas);
        
        informacaoAdicionalPanel.add(new JLabel("Localização Física"));
        textLocalizacaoFisica = new JTextField();
        textLocalizacaoFisica.setPreferredSize(new Dimension(300, 30));
        informacaoAdicionalPanel.add(textLocalizacaoFisica);
        
    
        informacaoAdicionalPanel.add(new JLabel("Data de Aquisição"));
        textDataAquisicao = new JTextField();
        textDataAquisicao.setPreferredSize(new Dimension(300, 30));
        informacaoAdicionalPanel.add(textDataAquisicao);

        
        informacaoAdicionalPanel.add(new JLabel("Número de Cópias"));
        textNumeroCopias = new JTextField();
        textNumeroCopias.setPreferredSize(new Dimension(300, 30));
        informacaoAdicionalPanel.add(textNumeroCopias);

        informacaoAdicionalPanel.add(new JLabel("Resumo"));
        textResumo = new JTextArea();
        JScrollPane scrollResumo = new JScrollPane(textResumo);
        scrollResumo.setPreferredSize(new Dimension(300, 75));
        informacaoAdicionalPanel.add(scrollResumo);


        // Adiciona os paineis de informações interna e adicional ao painel principal
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(1, 2, 20, 0));
        infoPanel.add(informacaoInternaPanel);
        infoPanel.add(informacaoAdicionalPanel);

        

        panelCadastroLivros.add(infoPanel, BorderLayout.CENTER);


        return panelCadastroLivros;
    }

    public JPanel submeterPanel(){

        submeterPanel = new JPanel();
        submeterPanel.setPreferredSize(new Dimension(935,60));
        submeterPanel.setLayout(new FlowLayout(FlowLayout.CENTER,15,20));

        cancelarButton = new JButton("Cancelar");
        cancelarButton.setPreferredSize(new Dimension(100,30));
        cancelarButton.setFocusable(false);
        cancelarButton.addActionListener(this);
        submeterPanel.add(cancelarButton);
        
        submeterButton = new JButton("Submeter");
        submeterButton.setPreferredSize(new Dimension(100,30));
        submeterButton.setFocusable(false);
        submeterButton.addActionListener(this);
        submeterPanel.add(submeterButton);


        submeterPanel.revalidate();
        submeterPanel.repaint();

        return submeterPanel;
    }


    private void addLabelAndTextField(JPanel parentPanel, String labelText) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.RIGHT,20,10));
        
        JLabel label = new JLabel(labelText);
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(300, 30));
        
        panel.add(label);
        panel.add(textField);
        
        parentPanel.add(panel);
    }
    @Override 
    public void actionPerformed(ActionEvent e){
        
    }
}
