package biblioteca;

import javax.swing.*;
import java.awt.*;

public class LivrosPanel extends JPanel {

    JPanel searchPanel, resultPanel,messagePanel;
    JTextField searchField;
    JButton searchButton;

    public LivrosPanel() {
       // setLayout(new BorderLayout());
        setBackground(Color.RED);
        
        
        searchPanel = new JPanel();
        searchPanel.setPreferredSize(new Dimension(935,70));
        searchPanel.setBackground(Color.lightGray);
        searchPanel.setLayout(new FlowLayout());


        


        
        add(searchPanel,BorderLayout.NORTH);
    }
}
