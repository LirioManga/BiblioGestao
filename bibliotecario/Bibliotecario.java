package bibliotecario;

import javax.swing.*;
import java.awt.*;

public class Bibliotecario extends JPanel {
    public Bibliotecario() {
        setLayout(new BorderLayout());
        JLabel label = new JLabel("Bibliotecario Panel");
        add(label, BorderLayout.CENTER);
    }
}

