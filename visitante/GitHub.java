package visitante;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.*;

public class GitHub extends JPanel{
    public GitHub(){
        setLayout(new BorderLayout());
        setBackground(Color.decode("#3442ab"));

        ImageIcon imageIcon = new ImageIcon("D:\\LICENCIATURA EM INFORMATICA\\3ANO\\1st\\JAVA\\projecto\\javaIconsProj\\github.png");

        Image scaledImage = getScaledImage(imageIcon.getImage(), 900, 300);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel imageLabel = new JLabel(scaledIcon);
        add(imageLabel, BorderLayout.CENTER);
    }

    private Image getScaledImage(Image srcImg, int width, int height) {
        return srcImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }

   

}
