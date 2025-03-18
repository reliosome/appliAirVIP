import pages.AeroportPanel;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setTitle("AirVIP Gestionnaire");
        frame.setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        JTextArea mainTextArea = new JTextArea();
        mainTextArea.setText("Bienvenue sur l'application de gestion AirVIP");
        mainTextArea.setEditable(false);
        mainTextArea.setFont(new Font("Serif", Font.ITALIC, 32));
        mainTextArea.setForeground(Color.WHITE);
        mainTextArea.setBackground(Color.DARK_GRAY);
        mainTextArea.setFocusable(false);
        mainPanel.add(mainTextArea);
        mainPanel.setBackground(Color.DARK_GRAY);
        frame.add(mainPanel, BorderLayout.CENTER);

        // Retirer commentaire pour voir page AjoutAeroport
        //AeroportPanel aeroPanel = new AeroportPanel(frame);

        frame.setSize(new Dimension(800,600));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLocationRelativeTo(null);

        frame.setResizable(true);    // à voir

        frame.setVisible(true);

    }
}