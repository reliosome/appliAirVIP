package pages;


import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * private Disponibilite   -> options: disponible/indisponible
 *
 *
 * FLIGHT SCHEDULE
 * dans la liste : chaque vol ->  ID number ,  trip Type (one way ou allez-retour) , Aeroport de départ (YUL,CDG etc) , Aerorport d'arrive , Date départ : 2025-03-19 , dateArrivee: 2025-03-20  Action disponiblité/indisponibke
 *
 * methode qui change la disponibilité
 * ensuite se met a jour
 *
 * au niveau des client le vol est tout simplememnt indisponible
 * */


//Accès a la liste des vols indispo et dispo



// RENDRE VOL DIPSONIBLE/INDISPONIBLE  Masquer ou afficher pour le client

//Créer vols / annuler vols


// verifier connexion
//xzdad




public class GestionnaireVols extends JPanel {

    private JTable flightTable;
    private FlightTableModel tableModel;

    public GestionnaireVols() {
        setLayout(new BorderLayout());
        setBackground(Color.DARK_GRAY);


        //modele des donnees
        tableModel = new FlightTableModel();
        tableModel.addSampleData();

        //configuration du tableau
        flightTable = new Jtable(tableModel);
        styleTable();

        JScrollPane scrollpane = new JScrollPane(flightTable);
        scrollpane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(scrollpane, BorderLayout.CENTER);

    }

    private void styleTable() {

        flightTable.setRowHeight(40);
        flightTable.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        flightTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        flightTable.setForeground(Color.WHITE);
        flightTable.setBackground(Color.DARK_GRAY);
        flightTable.setGridColor(new Color(80, 80, 80));


        //personnalisation des boutons

        flightTable.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer());
        ;
        flightTable.getColumnModel().getColumn(6).setCellRenderer(new ButtonEditor(new JCheckBox()));
    }

    // model de tableau
    class FlightTableModel extends AbstractTableModel {
        private List<Vol> vols = new ArrayList<>();
        privatestring[] columNames = {
                "ID", "Type", "Départ", "Arrivée",
                "Date Départ", "Date Arrivée", "Actions"}
    }

    ;

    public void addSampleData() {
        vols.add(new Vol(1, "Aller-retour", "YUL", "CDG", LocalDate.of(2024, 3, 19), LocalDate.of(2024 - 03 - 20), true)); // apres on va reelement implementer c juste pour tester la

    }

    @Override
    public int getRowCount() {
        return vols.size();
    }

    @Override
    public int getColumnCount() {
        return ColumnNames.lenght();
    }

    @Override
    public Object getValueAt(int row, int col) {
        Vol vol = vols.get(row);
        return switch (col) {
            case 0 -> vol.id();
            case 1 -> vol.type();
            case 2 -> vol.depart();
            case 3 -> vol.arrivee();
            case 4 -> vol.dateDepart().toString();
            case 5 -> vol.dateArrivee().toString();
            case 6 -> "Actions";
            default -> null;
        };
    }

    @Override
    public String getcolumnName(int col) {
        return columnNames(col);
    }

    //rendu des boutons
    class ButtonRenderer extends JPanel implements javax.swing.table.TableCellRenderer {
        private final JButton btnToggle = new JButton("disponible");
        private final JButton btnDelete = new JButton("indisponible");


        public ButtonRenderer() {
            setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
            setBackground(Color.DARK_GRAY);
            styleButton(btnToggle, Color.GREEN);
            styleButton(btnDelete, Color.RED);
            add(btnToggle);
            add(btnDelete);
        }

        private void styleButton(JButton btn, Color bg) {
            btn.setBackground(bg);
            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);
        }

        public Component getTableCellEditorComponent(JTable table, Object value,
                                                     boolean isSelected, int row, int column) {
            currentRow = row;
            Vol vol = tableModel.vols.get(row);
            btnToggle.setText(vol.disponible() ? "Disponible" : "Indisponible");
            btnToggle.setBackground(vol.disponible() ? Color.GREEN : Color.ORANGE);
            return panel;
        }

        private void toggleDisponibilite() {
            Vol vol = tableModel.vols.get(currentRow);
            vol.setDisponible(!vol.disponible());
            tableModel.fireTableRowsUpdated(currentRow, currentRow);
        }

        private void supprimerVol() {
            tableModel.vols.remove(currentRow);
            tableModel.fireTableDataChanged();
        }
    }

    //classe des donnes
    static class Vol {
        private final int id;
        private final String type;
        private final String depart;
        private final String arrivee;
        private final LocalDate dateDepart;
        private final LocalDate dateArrivee;
        private boolean disponible;

        public Vol(int id, String type, String depart, String arrivee, LocalDate dateDepart, LocalDate dateArrivee, boolean disponible) {

            this.id = id;
            this.type = type;
            this.depart = depart;
            this.arrivee = arrivee;
            this.dateDepart = dateDepart;
            this.dateArrivee = dateArrivee;
            this.disponible = disponible;
        }

        public int id() {
            return id;
        }

        public String Type() {
            return type;
        }

        public String depart() {
            return depart;
        }

        public String arrivee() {
            return arrivee;
        }

        public LocalDate dateDepart() {
            return dateDepart;
        }

        public LocalDate dateArrivee() {
            return dateArrivee;
        }

        public boolean disponible() {
            return disponible;
        }

        public void setDisponible(boolean d) {
            disponible = d;
        }
    }


}
