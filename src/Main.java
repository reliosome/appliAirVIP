import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setTitle("AirVIP Gestionnaire");
        frame.setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        frame.add(mainPanel, BorderLayout.CENTER);

        frame.setSize(new Dimension(1280,720));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLocationRelativeTo(null);

        frame.setResizable(true);    // à voir

        frame.setVisible(true);

    }
}