/**
*
*	IndustrijskiPralniStroj.java
*	
*	Opis: Program po navodilih naloge 34. Izbrana tema je bila PralniStroj. 
*	Izdelajte vsaj en vmesnik ali abstraktni razred, ki ga boste nato smiselno implementirali v vašem osnovnem razredu.
*  	@author Luka Leben
*	@version Primer 32 (Seznami in izpis)
*	PametniPralniStroj: Podrazred, ki razširja PralniStroj in dodaja funkcionalnosti za povezovanje in odklop iz WiFi.
*
*/

	// Definiramo podrazred PametniPralniStroj, ki deduje lastnosti iz razreda PralniStroj
public class PametniPralniStroj extends PralniStroj {
    // Zasebna spremenljivka za stanje povezave na WiFi
    private boolean povezanNaWiFi;
    
    /**
     * Konstruktor, ki sprejme znamko in kapaciteto pametnega pralnega stroja.
     * 
     * @param znamka Znamka pametnega pralnega stroja.
     * @param kapaciteta Kapaciteta pametnega pralnega stroja.
     */

    // Konstruktor, ki sprejme znamko in kapaciteto pametnega pralnega stroja
    public PametniPralniStroj(String znamka, int kapaciteta) {
        // Kliče konstruktor nadrazreda PralniStroj z znamko in kapaciteto
        super(znamka, kapaciteta);
        // Inicializira stanje povezave na WiFi kot nepriključeno
        this.povezanNaWiFi = false;
    }

    /**
     * Metoda za povezavo pralnega stroja na WiFi.
     * 
     * @throws Exception Vrne izjemo, če pralni stroj ni vklopljen.
     */
    // Metoda za povezavo pralnega stroja na WiFi
    public void poveziNaWiFi() throws Exception {
        // Preveri, če je pralni stroj vklopljen
        if (!vklopljena) {
            // Vrže izjemo, če pralni stroj ni vklopljen
            throw new Exception("Pralni stroj ni vklopljen.");
        }
        // Nastavi stanje povezave na WiFi kot priključeno
        povezanNaWiFi = true;
        // Izpiše, da je pralni stroj povezan na WiFi
        System.out.println(znamka + " pralni stroj je povezan na WiFi.");
    }

    /**
     * Metoda za odklop pralnega stroja iz WiFi.
     * 
     * @throws Exception Vrne izjemo, če pralni stroj ni povezan na WiFi.
     */
    // Metoda za odklop pralnega stroja iz WiFi
    public void odklopiIzWiFi() throws Exception {
        // Preveri, če je pralni stroj priključen na WiFi
        if (!povezanNaWiFi) {
            // Vrže izjemo, če pralni stroj ni povezan na WiFi
            throw new Exception("Pralni stroj ni povezan na WiFi.");
        }
        // Nastavi stanje povezave na WiFi kot nepriključeno
        povezanNaWiFi = false;
        // Izpiše, da je pralni stroj odklopljen iz WiFi
        System.out.println(znamka + " pralni stroj je odklopljen iz WiFi.");
    }

    
    /**
     * Preklicana metoda toString, ki vrne niz z informacijami o pametnem pralnem stroju.
     * 
     * @return Vrne niz z informacijami o pametnem pralnem stroju.
     */
    // Preklicana metoda toString, ki vrne niz z informacijami o pametnem pralnem stroju
  
    public String toString() {
        return "PametniPralniStroj{" +
                "znamka='" + znamka + '\'' +
                ", kapaciteta=" + kapaciteta +
                ", vklopljena=" + vklopljena +
                ", povezanNaWiFi=" + povezanNaWiFi +
                '}';
    }
}