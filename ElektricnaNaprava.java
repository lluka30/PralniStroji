/**
*
*	ElektricnaNaprava.java
*	
*	Opis: Program po navodilih naloge 34. Izbrana tema je bila PralniStroj. 
*	Izdelajte vsaj en vmesnik ali abstraktni razred, ki ga boste nato smiselno implementirali v vašem osnovnem razredu.
* 	@author Luka Leben
*	@version Primer 34 (Seznami in izpis)
*	V spodnji kodi sem v razredu PralniStrojDelovanje ustvaril tri objekte razreda PralniStroj in demonstiral uporabo metod na teh objektih
*
*/

// Abstraktni razred ElektricnaNaprava
public abstract class ElektricnaNaprava {
    protected boolean vklopljena;

    // Abstraktna metoda za vklop naprave
    public abstract void vklopi();

    // Abstraktna metoda za izklop naprave
    public abstract void izklopi();

    // Preveri, ali je naprava vklopljena
    public boolean jeVklopljena() {
        return vklopljena;
    }
}