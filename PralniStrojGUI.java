import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
*
*	ElektricnaNaprava.java
*	
*	Opis: Program po navodilih naloge 35. Izbrana tema je bila PralniStroj. 
*	Izdelajte grafični uporabniški vmesnik (GUI) za delo z objekti in njihovim seznamom, ki ste jih implementirali od 27. vaje naprej. Razširite razred DefaultTableModel ter implementirajte vmesnik ActionListener tako, da bo program omogočal vnašanje seznama objektov z njihovimi lastnostmi, ki ste jih implementirali.
* 	@author Luka Leben
*	@version Primer 35 (GUI)
*	
*
*/

/**
 * Glavni razred za GUI aplikacijo, ki razsirja JFrame in implementira ActionListener za obdelavo dogodkov.
 */
// Glavni razred za GUI aplikacijo, ki razširja JFrame in implementira ActionListener za obdelavo dogodkov
public class PralniStrojGUI extends JFrame implements ActionListener {
    // Definiramo polja za vnos podatkov
    private JTextField znamkaField, kapacitetaField;
    // Definiramo ComboBox za izbiro tipa pralnega stroja
    private JComboBox<String> tipComboBox;
    // Definiramo gumb za dodajanje novih strojev
    private JButton dodajButton;
    // Definiramo model tabele za prikaz podatkov
    private DefaultTableModel tableModel;
    // Definiramo tabelo za prikaz seznama pralnih strojev
    private JTable table;
    // Seznam za shranjevanje objektov pralnih strojev
    private List<PralniStroj> pralniStroji;


    /**
     * Konstruktor za inicializacijo GUI-ja.
     */
    
    // Konstruktor za inicializacijo GUI-ja
    public PralniStrojGUI() {
        // Inicializiramo seznam pralnih strojev
        pralniStroji = new ArrayList<>();

        // Nastavitve za okno
        setTitle("Pralni Stroji GUI"); // Nastavimo naslov okna
        setSize(600, 400); // Nastavimo velikost okna
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Nastavimo privzeto vedenje ob zapiranju okna
        setLocationRelativeTo(null); // Nastavimo, da se okno prikaže na sredini zaslona

        // Ustvarimo panel za vnos podatkov
        JPanel inputPanel = new JPanel(new GridLayout(4, 2)); // Uporabimo GridLayout za razporeditev komponent v mreži

        // Dodamo oznako in ComboBox za izbiro tipa stroja
        inputPanel.add(new JLabel("Tip stroja:"));
        tipComboBox = new JComboBox<>(new String[]{"osnovni", "pametni", "industrijski"});
        inputPanel.add(tipComboBox);

        // Dodamo oznako in polje za vnos znamke
        inputPanel.add(new JLabel("Znamka:"));
        znamkaField = new JTextField();
        inputPanel.add(znamkaField);

        // Dodamo oznako in polje za vnos kapacitete
        inputPanel.add(new JLabel("Kapaciteta (kg):"));
        kapacitetaField = new JTextField();
        inputPanel.add(kapacitetaField);

        // Dodamo gumb za dodajanje strojev in dodamo ActionListener
        dodajButton = new JButton("Dodaj");
        dodajButton.addActionListener(this);
        inputPanel.add(dodajButton);

        // Ustvarimo model tabele in tabelo za prikaz podatkov
        tableModel = new DefaultTableModel(new String[]{"Tip", "Znamka", "Kapaciteta"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table); // Dodamo tabelo v JScrollPane za omogočanje drsenja

        // Dodamo vnosni panel in scrollPane v glavno okno
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    
    /**
     * Metoda za obdelavo dogodkov ob kliku na gumb "Dodaj".
     * @param e Objekt razreda ActionEvent, ki predstavlja dogodek.
     */
    
    // Metoda za obdelavo dogodkov ob kliku na gumb "Dodaj"
  
    public void actionPerformed(ActionEvent e) {
        // Preberemo vrednosti iz vnosnih polj
        String tip = (String) tipComboBox.getSelectedItem();
        String znamka = znamkaField.getText();
        int kapaciteta = Integer.parseInt(kapacitetaField.getText());

        // Inicializiramo spremenljivko za pralni stroj
        PralniStroj stroj = null;
        try {
            // Glede na izbran tip ustvarimo ustrezno vrsto pralnega stroja
            switch (tip) {
                case "osnovni":
                    stroj = new PralniStroj(znamka, kapaciteta);
                    break;
                case "pametni":
                    stroj = new PametniPralniStroj(znamka, kapaciteta);
                    break;
                case "industrijski":
                    stroj = new IndustrijskiPralniStroj(znamka, kapaciteta, 10); // Privzeta vrednost za stevilo programov
                    break;
            }
            // Dodamo pralni stroj v seznam
            pralniStroji.add(stroj);

            // Dodamo podatke o pralnem stroju v tabelo
            tableModel.addRow(new Object[]{tip, znamka, kapaciteta});
        } catch (Exception ex) {
            // Prikažemo sporočilo o napaki, če pride do izjeme
            JOptionPane.showMessageDialog(this, "Napaka pri dodajanju stroja: " + ex.getMessage());
        }
    }

    /**
     * Glavna metoda za zagon GUI aplikacije.
     * @param args Argumenti iz ukazne vrstice.
     */
    // Glavna metoda za zagon GUI aplikacije
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PralniStrojGUI gui = new PralniStrojGUI(); // Ustvarimo instanco GUI-ja
            gui.setVisible(true); // Prikažemo GUI
        });
    }
}