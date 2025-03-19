package pages;

import javax.swing.*;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AeroportPanel {
    private JPanel panelAjout;
    private JLabel labelAero; // "Nouvel Aéroport"
    private JLabel labelVille;
    private JTextField txtVille;
    private JLabel labelPays;
    private JTextField txtPays;
    private JLabel labelDistanceMTL;
    private JTextField txtDistanceMTL;
    private JButton btnConfirm;
    private JButton btnCancel;
    private GridBagConstraints gbc;

    public AeroportPanel(JFrame frame){
        panelAjout = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();

        labelAero = new JLabel("Nouvel Aéroport");
        labelAero.setForeground(Color.WHITE);
        labelAero.setFont(new Font("Serif", Font.BOLD, 24));
        labelVille = new JLabel("Ville : ");
        labelVille.setForeground(Color.WHITE);
        txtVille = new JTextField(20);
        labelPays = new JLabel("Pays : ");
        labelPays.setForeground(Color.WHITE);
        txtPays = new JTextField(20);
        labelDistanceMTL = new JLabel("Distance de Montréal (km) : ");
        labelDistanceMTL.setForeground(Color.WHITE);
        txtDistanceMTL = new JTextField(20);
        btnConfirm = new JButton("Confirmer");
        btnCancel = new JButton("Annuler");

        btnConfirm.setBackground(Color.GREEN);
        btnCancel.setBackground(Color.RED);
        btnConfirm.setActionCommand("confirm");
        btnCancel.setActionCommand("cancel");

        // Partie ChatGPT
        // Configuration du labelAero pour occuper deux colonnes
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Étend sur deux colonnes
        gbc.anchor = GridBagConstraints.CENTER; // Centrer le texte
        gbc.insets = new Insets(5, 5, 5, 5); // Espacement
        panelAjout.add(labelAero, gbc);

        // Reset gridwidth pour les autres composants (qui seront sur 2 colonnes)
        gbc.gridwidth = 1;

        // Ligne 1 : Label Ville + TextField Ville
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panelAjout.add(labelVille, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panelAjout.add(txtVille, gbc);

        // Ligne 2 : Label Pays + TextField Pays
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        panelAjout.add(labelPays, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panelAjout.add(txtPays, gbc);

        // Ligne 3 : Label Distance + TextField Distance
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        panelAjout.add(labelDistanceMTL, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panelAjout.add(txtDistanceMTL, gbc);

        // Ligne 4 : Boutons Cancel et Confirm
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        panelAjout.add(btnCancel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panelAjout.add(btnConfirm, gbc);

        // Fin partie chatGPT

//        panelAjout.add(labelAero);
//        panelAjout.add(labelVille);
//        panelAjout.add(txtVille);
//        panelAjout.add(labelPays);
//        panelAjout.add(txtPays);
//        panelAjout.add(labelDistanceMTL);
//        panelAjout.add(txtDistanceMTL);
//        panelAjout.add(btnConfirm);
//        panelAjout.add(btnCancel);

        panelAjout.setBackground(Color.DARK_GRAY);

        frame.add(panelAjout);
    }

    public void actionPerformed(ActionEvent event){
        if ("confirm".equals(event.getActionCommand())){
            // Ferme le panel et envoyer les données
        }
        if ("cancel".equals(event.getActionCommand())){
            // Fermer le panel, oublie les données
        }
    }
}
