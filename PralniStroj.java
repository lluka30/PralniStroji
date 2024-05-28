/**
*
*	PralniStroj.java
*	
*	Opis: Program po navodilih naloge 34. Izbrana tema je bila PralniStroj. 
*	Izdelajte vsaj en vmesnik ali abstraktni razred, ki ga boste nato smiselno implementirali v vašem osnovnem razredu.
* 	@author Luka Leben
*	@version Primer 32 (Seznami in izpis)
*	
*	V spodnji kodi sem definiral razred PralniStroj z lastnostmi znamka, kapaciteta in vklopljen. Imamo tri metode, ki implementirajo poslovno logiko: vklopi, izklopi in zacniPranje
*/

// Definiramo razred PralniStroj, ki deduje iz abstraktnega razreda ElektricnaNaprava
public class PralniStroj extends ElektricnaNaprava {
    // Zavarovane spremenljivke za znamko in kapaciteto pralnega stroja
    protected String znamka;
    protected int kapaciteta;

    
    /**
     * Konstruktor, ki sprejme znamko in kapaciteto pralnega stroja.
     * 
     * @param znamka Znamka pralnega stroja.
     * @param kapaciteta Kapaciteta pralnega stroja.
     */
    // Konstruktor, ki sprejme znamko in kapaciteto pralnega stroja
    public PralniStroj(String znamka, int kapaciteta) {
        // Inicializira znamko in kapaciteto pralnega stroja
        this.znamka = znamka;
        this.kapaciteta = kapaciteta;
        // Inicializira stanje pralnega stroja kot izklopljeno
        this.vklopljena = false;
    }

    /**
     * Metoda za vklop pralnega stroja.
     */
    // Metoda za vklop pralnega stroja
    public void vklopi() {
        // Preveri, če pralni stroj ni že vklopljen
        if (!vklopljena) {
            // Nastavi stanje pralnega stroja kot vklopljeno
            vklopljena = true;
            // Izpiše, da je pralni stroj vklopljen
            System.out.println(znamka + " pralni stroj je vklopljen.");
        } else {
            // Izpiše, da je pralni stroj že vklopljen
            System.out.println(znamka + " pralni stroj je že vklopljen.");
        }
    }

    /**
     * Metoda za izklop pralnega stroja.
     */
    // Metoda za izklop pralnega stroja
    public void izklopi() {
        // Preveri, če pralni stroj ni že izklopljen
        if (vklopljena) {
            // Nastavi stanje pralnega stroja kot izklopljeno
            vklopljena = false;
            // Izpiše, da je pralni stroj izklopljen
            System.out.println(znamka + " pralni stroj je izklopljen.");
        } else {
            // Izpiše, da je pralni stroj že izklopljen
            System.out.println(znamka + " pralni stroj je že izklopljen.");
        }
    }

    
    /**
     * Metoda za začetek pranja, ki sprejme težo perila.
     * 
     * @param tezaPerila Teža perila, ki se bo pralo.
     * @throws Exception Vrne izjemo, če pralni stroj ni vklopljen ali je teža perila prevelika.
     */
    // Metoda za začetek pranja, ki sprejme težo perila
    public void zacniPranje(int tezaPerila) throws Exception {
        // Preveri, če je pralni stroj vklopljen
        if (!vklopljena) {
            // Vrže izjemo, če pralni stroj ni vklopljen
            throw new Exception("Pralni stroj ni vklopljen.");
        }
        // Preveri, če teža perila presega kapaciteto pralnega stroja
        if (tezaPerila > kapaciteta) {
            // Vrže izjemo, če je teža perila prevelika
            throw new Exception("Preobremenitev! Kapaciteta stroja je " + kapaciteta + " kg.");
        }
        // Izpiše, da se je pranje začelo s podano težo perila
        System.out.println("Pranje se je začelo s težo " + tezaPerila + " kg.");
    }

    /**
     * Preklicana metoda toString, ki vrne niz z informacijami o pralnem stroju.
     * 
     * @return Vrne niz z informacijami o pralnem stroju.
     */
    
    // Preklicana metoda toString, ki vrne niz z informacijami o pralnem stroju
   
    public String toString() {
        return "PralniStroj{" +
                "znamka='" + znamka + '\'' +
                ", kapaciteta=" + kapaciteta +
                ", vklopljena=" + vklopljena +
                '}';
    }
}