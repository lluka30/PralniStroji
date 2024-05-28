/**
*
*	IndustrijskiPralniStroj.java
*	
*Opis: Program po navodilih naloge 34. Izbrana tema je bila PralniStroj. 
*	Izdelajte vsaj en vmesnik ali abstraktni razred, ki ga boste nato smiselno implementirali v vašem osnovnem razredu.
*  	@author Luka Leben
*	@version Primer 32 (Seznami in izpis)
*	
*	IndustrijskiPralniStroj: Podrazred, ki razširja PralniStroj in dodaja možnost izbire programa pranja.
*
*/

	// Razred IndustrijskiPralniStroj, ki deduje iz razreda PralniStroj
public class IndustrijskiPralniStroj extends PralniStroj {
    // Zasebna spremenljivka za število programov
    private int steviloProgramov;
    
    /**
     * Konstruktor, ki sprejme znamko, kapaciteto in število programov industrijskega pralnega stroja.
     * 
     * @param znamka Znamka industrijskega pralnega stroja.
     * @param kapaciteta Kapaciteta industrijskega pralnega stroja.
     * @param steviloProgramov Število programov industrijskega pralnega stroja.
     */

    // Konstruktor, ki sprejme znamko, kapaciteto in število programov industrijskega pralnega stroja
    public IndustrijskiPralniStroj(String znamka, int kapaciteta, int steviloProgramov) {
        // Kliče konstruktor nadrazreda PralniStroj z znamko in kapaciteto
        super(znamka, kapaciteta);
        // Inicializira število programov
        this.steviloProgramov = steviloProgramov;
    }

    /**
     * Metoda za izbiro programa pranja.
     * 
     * @param program Številka izbranega programa.
     * @throws Exception Vrne izjemo, če pralni stroj ni vklopljen ali če je izbran neveljaven program.
     */
    
    // Metoda za izbiro programa, ki sprejme številko programa
    public void izberiProgram(int program) throws Exception {
        // Preveri, če je pralni stroj vklopljen
        if (!vklopljena) {
            // Vrže izjemo, če pralni stroj ni vklopljen
            throw new Exception("Pralni stroj ni vklopljen.");
        }
        // Preveri, če je številka programa veljavna
        if (program < 1 || program > steviloProgramov) {
            // Vrže izjemo, če je številka programa izven dovoljenega obsega
            throw new Exception("Neveljaven program. Izberite program med 1 in " + steviloProgramov + ".");
        }
        // Izpiše izbrano številko programa
        System.out.println("Izbran je program številka " + program + ".");
    }

    
    /**
     * Preklicana metoda toString, ki vrne niz z informacijami o industrijskem pralnem stroju.
     * 
     * @return Vrne niz z informacijami o industrijskem pralnem stroju.
     */
    
    // Preklicana metoda toString, ki vrne niz z informacijami o industrijskem pralnem stroju
    public String toString() {
        return "IndustrijskiPralniStroj{" +
                "znamka='" + znamka + '\'' +
                ", kapaciteta=" + kapaciteta +
                ", vklopljena=" + vklopljena +
                ", steviloProgramov=" + steviloProgramov +
                '}';
    }
}