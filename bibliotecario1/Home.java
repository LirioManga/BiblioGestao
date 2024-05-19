package bibliotecario1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import visit.RegistoVisitante;
import visit.Visitante;

import java.net.URI;

public class Home extends JFrame implements ActionListener, MouseListener{
    JMenuBar menu;
    JMenu home;
    JMenuItem adminItem, bibliotecarioItem, exitItem, outroItem;
    JPanel panel;
    ImageIcon logoUP;

    JLabel bem_vindo, frase_motivacional, logo;
    JButton botao_entrar, login, sobre;
    JButton livroButton,artigoButton,monografiaButton,gitHubButton;
    JPanel panelHome;

    
    public Home(){
        //panelHome = new JPanel();
        //panelHome.setBounds(0,0,1100,680);
       
        // menu
        menu = new JMenuBar();
        home = new JMenu("Menu");
        adminItem = new JMenuItem("Admin");
        bibliotecarioItem = new JMenuItem("Bibliotecario");
        exitItem = new JMenuItem("Sair");
        outroItem = new JMenuItem("Outro");

		// eventos
        adminItem.addActionListener(this);
		bibliotecarioItem.addActionListener(this);
		exitItem.addActionListener(this);
        outroItem.addActionListener(this);


        // panel
        panel = new JPanel(null);
        panel.setBounds(0,0,1085,80);
        panel.setBackground(new Color(11, 77, 156));

        logoUP = new ImageIcon("D:\\LICENCIATURA EM INFORMATICA\\3ANO\\1st\\JAVA\\projecto\\javaIconsProj\\up.png");
        logo = new JLabel(logoUP);
        logo.setIcon(new ImageIcon(getScaledImage(logoUP.getImage(), 80, 80)));
        logo.setBounds(10, 4, 80, 80);
        panel.add(logo);
        

        // elementos no frame
        bem_vindo = new JLabel();
        bem_vindo.setText("Biblioteca UP");
        bem_vindo.setBounds(400, 180, 350, 150);
        bem_vindo.setFont(new Font("Consola", Font.PLAIN, 50));
      

        frase_motivacional = new JLabel();
        frase_motivacional.setText("CPED");
        frase_motivacional.setBounds(500,250, 500, 150);
        frase_motivacional.setFont(new Font("Consola", Font.ITALIC, 30));
       

        botao_entrar = new JButton("Entrar");
        botao_entrar.setFocusable(false);
        botao_entrar.setBackground(new Color(11, 77, 156));
        botao_entrar.setBounds(390, 400, 100, 35);
		botao_entrar.addActionListener(this);


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(null); 
        buttonPanel.setBackground(new Color(11, 77, 156));
        buttonPanel.setBounds(800, 4, 300, 80);
        panel.add(buttonPanel);

        login = new JButton("Login");
        login.setBounds(30, 15, 80, 30);
        login.setContentAreaFilled(false);
        login.setFocusable(false);
        login.setBorder(null);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.addMouseListener(this);
        buttonPanel.add(login);

        sobre = new JButton("Sobre");
        sobre.setBounds(150, 15, 80, 30); 
        sobre.setContentAreaFilled(false);
        sobre.setFocusable(false);
        sobre.setBorder(null);
        sobre.setForeground(Color.WHITE);
        sobre.addActionListener(this);
        sobre.addMouseListener(this);
        buttonPanel.add(sobre);


        livroButton= new JButton("Livros");
        livroButton.setBounds(180, 500, 100, 30); 
        livroButton.setContentAreaFilled(false);
        livroButton.setFocusable(false);
        livroButton.setBorder(null);
        livroButton.setForeground(new Color(11,77,156));
        livroButton.setFont(new Font("Serif",Font.BOLD,15));
        livroButton.addActionListener(this);
        livroButton.addMouseListener(this);
        add(livroButton);
        
        artigoButton= new JButton("Artigos");
        artigoButton.setBounds(400, 500, 100, 30); 
        artigoButton.setContentAreaFilled(false);
        artigoButton.setFocusable(false);
        artigoButton.setBorder(null);
        artigoButton.setForeground(new Color(11,77,156));
        artigoButton.setFont(new Font("Serif",Font.BOLD,15));
        artigoButton.addActionListener(this);
        artigoButton.addMouseListener(this);
        add(artigoButton);
  
        
        monografiaButton = new JButton("Monografias");
        monografiaButton.setBounds(600, 500, 100, 30); 
        monografiaButton.setContentAreaFilled(false);
        monografiaButton.setFocusable(false);
        monografiaButton.setBorder(null);
        monografiaButton.setForeground(new Color(11,77,156));
        monografiaButton.setFont(new Font("Serif",Font.BOLD,15));
        monografiaButton.addActionListener(this);
        monografiaButton.addMouseListener(this);
        add(monografiaButton);
        
        gitHubButton = new JButton("GitHub");
        gitHubButton.setBounds(800, 500, 100, 30); 
        gitHubButton.setContentAreaFilled(false);
        gitHubButton.setFocusable(false);
        gitHubButton.setBorder(null);
        gitHubButton.setForeground(new Color(11,77,156));
        gitHubButton.setFont(new Font("Serif",Font.BOLD,15));
        gitHubButton.addActionListener(this);
        gitHubButton.addMouseListener(this);
        add(gitHubButton);
        

        panel.add(buttonPanel);
     



        // Adicionando elementos ao frame
        home.add(adminItem);
        home.add(bibliotecarioItem);
        home.add(exitItem);
        home.add(outroItem);
       // menu.add(home);
        add(panel);
        add(bem_vindo);
        add(frase_motivacional);
        //this.add(botao_entrar);
		
        
        // frame settings
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1100, 680);
        this.setJMenuBar(menu);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }		

    private Image getScaledImage(Image srcImg, int width, int height) {

        return srcImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
  
    }

    @Override
    public void actionPerformed (ActionEvent e){
        // NOVO
            if(e.getSource() == login){
                this.setTitle("Autenticação");
                //Admin admin = new Admin();
                //admin.setBounds(0,0,1100,600);
                getContentPane().removeAll();
                //getContentPane().add(admin);
                repaint();
                revalidate();

            }else if(e.getSource() == sobre){
                Sobre sobrePanel = new Sobre();
                sobrePanel.setBounds(0, 0, 400, 400);
              
                System.out.println("Entrei");
                getContentPane().removeAll();
                getContentPane().add(sobrePanel);
                repaint();
                revalidate();
            }else if(e.getSource() == livroButton || e.getSource() == artigoButton || e.getSource() == monografiaButton){

                new RegistoVisitante(this);
            }



        // ANTIGO 
        if(e.getSource() == adminItem){
            dispose();
           // new Admin();
            System.out.print("entrando como administrador");
        }else if(e.getSource() == bibliotecarioItem){
			dispose();
            new Bibliotecario();
        }else if(e.getSource() == exitItem){
            dispose();
        }
        else if(e.getSource() == botao_entrar){
           
			//new RegistoVisitante();
		}else if(e.getSource() == outroItem){
        
            System.out.println("OUTRO ADICIONADO");
            new Outro();
            dispose();
        }else if(e.getSource() == gitHubButton){
            openRepository("https://github.com/LirioManga/BibliotecaRepositorio");
        }
    }

     private void openRepository(String link) {
        try {
            Desktop.getDesktop().browse(new URI(link));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == login){
            login.setForeground(Color.YELLOW);
        }else if(e.getSource() == sobre){
            sobre.setForeground(Color.YELLOW);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == login){
            login.setForeground(Color.WHITE);
          }else if(e.getSource() == sobre){
            sobre.setForeground(Color.WHITE);
          }else if(e.getSource() == artigoButton){
            artigoButton.setForeground(new Color(11,77,156));
          }else if(e.getSource() == livroButton){
            livroButton.setForeground(new Color(11,77,156));
          }else if(e.getSource() == monografiaButton){
            monografiaButton.setForeground(new Color(11,77,156));
          }else{
            gitHubButton.setForeground(new Color(11,77,156));
          }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
        if(e.getSource() == monografiaButton){
            monografiaButton.setForeground(new Color(252, 213, 18));
        }else if(e.getSource() == artigoButton){
            artigoButton.setForeground(new Color(252, 213, 18));
        }else if(e.getSource() == livroButton){
            livroButton.setForeground(new Color(252, 213, 18));
        }else if(e.getSource() == gitHubButton){
            gitHubButton.setForeground(new Color(252, 213, 18));
          
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {}

    public void showVisitantePanel() {
        Visitante visitantePanel = new Visitante(this);
        visitantePanel.setBounds(0, 0, 1100, 680);
        getContentPane().removeAll();
        getContentPane().add(visitantePanel);
        repaint();
        revalidate();
    }

}
