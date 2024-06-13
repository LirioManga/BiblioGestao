package bibliotecario;


import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

public class Monografias extends JPanel implements ActionListener{

    
    JPanel panelTitle,panelItens, panelContent, panelCadastroLivros, submeterPanel;
   
    JPanel informacaoInternaPanel, informacaoAdicionalPanel;
    JTextField textCurso, textAutor, textSupervisor, textTitulo, textIdioma, textNumeroPaginas, textLocalizacaoFisica, textISBN, textDataAquisicao, textNumeroCopias, textCodigoBarras,textFaculdade, textAreaCategoria,textAnoPublicacao;
    JTextArea textResumo;
    CardLayout cardLayout;
    JButton submeterButton,cancelarButton;
    public Monografias(){
        setLayout(new BorderLayout());
        setBackground(Color.green);


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(cadastroMonografia());
        mainPanel.add(submeterPanel());


        add(mainPanel, BorderLayout.CENTER);

        repaint();
        revalidate();
    }




    public JPanel cadastroMonografia() {
        panelCadastroLivros = new JPanel();
        panelCadastroLivros.setPreferredSize(new Dimension(600, 650));
        panelCadastroLivros.setBackground(Color.green);
        panelCadastroLivros.setLayout(new BorderLayout());

        // Título
        JLabel tituloLabel = new JLabel();
        tituloLabel.setText("Informações do Monografia");
        tituloLabel.setPreferredSize(new Dimension(530, 40));
        tituloLabel.setFont(new Font("MV BOLI", Font.PLAIN, 20));
        tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);

        Border linBorderTitulo = BorderFactory.createLineBorder(new Color(0xBDC7E6), 2);
        Border emptyBorderTitulo = BorderFactory.createEmptyBorder(0, 50, 0, 20);
        Border compoundBorderTitulo = BorderFactory.createCompoundBorder(linBorderTitulo, emptyBorderTitulo);
        tituloLabel.setBorder(compoundBorderTitulo);

        panelCadastroLivros.add(tituloLabel, BorderLayout.NORTH);

      
        textTitulo = new JTextField();
        addLabelAndTextField(informacaoInternaPanel, "Título da Monografia", textTitulo);
    
        textAutor = new JTextField();
        addLabelAndTextField(informacaoInternaPanel, "Autor", textAutor);
    
        textSupervisor = new JTextField();
        addLabelAndTextField(informacaoInternaPanel, "Supervisor", textSupervisor);
    
        textCurso = new JTextField();
        addLabelAndTextField(informacaoInternaPanel, "Curso", textCurso);
    
        textFaculdade = new JTextField();
        addLabelAndTextField(informacaoInternaPanel, "Faculdade", textFaculdade);
    
        textAnoPublicacao = new JTextField();
        addLabelAndTextField(informacaoInternaPanel, "Ano de Publicação", textAnoPublicacao);
    
        textAreaCategoria = new JTextField();
        addLabelAndTextField(informacaoInternaPanel, "Área/Categoria", textAreaCategoria);
    
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


    private boolean validarCampos() {
        if (textTitulo.getText().trim().isEmpty() || 
            textAutor.getText().trim().isEmpty() || 
            textIdioma.getText().trim().isEmpty() || 
            textNumeroPaginas.getText().trim().isEmpty() || 
            textLocalizacaoFisica.getText().trim().isEmpty() || 
            textDataAquisicao.getText().trim().isEmpty() || 
            textNumeroCopias.getText().trim().isEmpty() || 
            textCodigoBarras.getText().trim().isEmpty() || 
            textResumo.getText().trim().isEmpty()) {
            return false;
        }
        return true;
    }
    
    private void addLabelAndTextField(JPanel parentPanel, String labelText, JTextField textField) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 10));

        JLabel label = new JLabel(labelText);
        textField.setPreferredSize(new Dimension(300, 30));
    
        panel.add(label);
        panel.add(textField);
    
        parentPanel.add(panel);
    }
}
