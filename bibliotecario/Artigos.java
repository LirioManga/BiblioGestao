package bibliotecario;



import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class Artigos extends JFrame implements ActionListener{
    
    JButton adicionar,voltar;
	public static JTable tabela;
	public static DefaultTableModel modelo;
	public static JScrollPane scrollPane;
	public static JPanel tabelaPanel;

    public Artigos(){

        modelo = new DefaultTableModel();
		modelo.addColumn("Autor");
		modelo.addColumn("Titulo");
		modelo.addColumn("Editora");
		modelo.addColumn("Categoria");
		
		
			tabela = new JTable(modelo);
			tabela.setBounds(0,0, 400, 400);
			tabela.setFocusable(false);
			scrollPane = new JScrollPane(tabela);
		
		
			tabelaPanel = new JPanel();
			tabelaPanel.setBounds(0,0,700,400);
			tabelaPanel.setLayout(new BorderLayout());
			tabelaPanel.add(scrollPane);
			


		// Botao adicionar
		
		adicionar = new JButton("Adicionar");
		adicionar.setBounds(160, 430, 150,30);
		adicionar.setFocusable(false);
		adicionar.addActionListener(this);
		
		voltar = new JButton("Voltar");
		voltar.setBounds(350, 430,150,30);
		voltar.setFocusable(false);
		voltar.addActionListener(this);
		
		// adicionando 
		
		add(tabelaPanel);
		add(adicionar);
		add(voltar);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
        this.setTitle("Artigos");
		this.setSize(700,500);
		this.setVisible(true);
	}
	
	FormArtigos form;
	
	@Override
	public void actionPerformed (ActionEvent e){
		if(e.getSource() == adicionar){
			form = new FormArtigos();
			
		}else{
			
			new Home();
			dispose();
		}
		
	}
}

