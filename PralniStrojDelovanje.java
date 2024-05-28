/**
*
*	PralniStrojDelovanje.java
*	
*	Opis: Program po navodilih naloge 34. Izbrana tema je bila PralniStroj. 
*	Izdelajte vsaj en vmesnik ali abstraktni razred, ki ga boste nato smiselno implementirali v vašem osnovnem razredu.
* 	@author Luka Leben
*	@version Primer 33 (Seznami in izpis)
*	V spodnji kodi sem v razredu PralniStrojDelovanje ustvaril tri objekte razreda PralniStroj in demonstiral uporabo metod na teh objektih
*
*/
import java.util.*;

/**
 * Razred ki prikazuje uporabo pralnih storjev
 * 
 */
// razred za prikaz uporabe PralniStroj
public class PralniStrojDelovanje {
	 /**
     * Metoda main, ki prikazuje uporabo pralnih strojev.
     * 
     * @param args Argumenti iz ukazne vrstice.
     */
	
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Ustvarimo scanner za branje vhodnih podatkov
        List<PralniStroj> pralniStroji = new ArrayList<>(); // Ustvarimo dinamični seznam za shranjevanje objektov

        while (true) {
            System.out.print("Vnesite tip pralnega stroja (osnovni, pametni, industrijski) ali pritisnite Enter za konec: ");
            String tip = scanner.nextLine(); // Preberemo tip pralnega stroja iz konzole
            if (tip.isEmpty()) {
                break; // Če je vnos prazen, prekinemo zanko
            }

            try {
                if (tip.equalsIgnoreCase("osnovni")) {
                    // Osnovni pralni stroj
                    System.out.print("Vnesite znamko osnovnega pralnega stroja: ");
                    String znamka = scanner.nextLine(); // Preberemo znamko osnovnega pralnega stroja
                    System.out.print("Vnesite kapaciteto osnovnega pralnega stroja: ");
                    int kapaciteta = Integer.parseInt(scanner.nextLine()); // Preberemo kapaciteto osnovnega pralnega stroja
                    PralniStroj stroj = new PralniStroj(znamka, kapaciteta); // Ustvarimo objekt osnovnega pralnega stroja
                    pralniStroji.add(stroj); // Dodamo stroj v seznam

                    stroj.vklopi(); // Vklopimo osnovni pralni stroj
                    System.out.print("Vnesite težo pranja za osnovni pralni stroj: ");
                    int tezaPranja = Integer.parseInt(scanner.nextLine()); // Preberemo težo pranja za osnovni pralni stroj
                    stroj.zacniPranje(tezaPranja); // Začnemo pranje z osnovnim pralnim strojem
                    stroj.izklopi(); // Izklopimo osnovni pralni stroj
                } else if (tip.equalsIgnoreCase("pametni")) {
                    // Pametni pralni stroj
                    System.out.print("Vnesite znamko pametnega pralnega stroja: ");
                    String znamka = scanner.nextLine(); // Preberemo znamko pametnega pralnega stroja
                    System.out.print("Vnesite kapaciteto pametnega pralnega stroja: ");
                    int kapaciteta = Integer.parseInt(scanner.nextLine()); // Preberemo kapaciteto pametnega pralnega stroja
                    PametniPralniStroj pametniStroj = new PametniPralniStroj(znamka, kapaciteta); // Ustvarimo objekt pametnega pralnega stroja
                    pralniStroji.add(pametniStroj); // Dodamo pametni stroj v seznam

                    pametniStroj.vklopi(); // Vklopimo pametni pralni stroj
                    pametniStroj.poveziNaWiFi(); // Povežemo pametni pralni stroj na WiFi
                    System.out.print("Vnesite težo pranja za pametni pralni stroj: ");
                    int tezaPranja = Integer.parseInt(scanner.nextLine()); // Preberemo težo pranja za pametni pralni stroj
                    pametniStroj.zacniPranje(tezaPranja); // Začnemo pranje z pametnim pralnim strojem
                    pametniStroj.odklopiIzWiFi(); // Odklopimo pametni pralni stroj iz WiFi
                    pametniStroj.izklopi(); // Izklopimo pametni pralni stroj
                } else if (tip.equalsIgnoreCase("industrijski")) {
                    // Industrijski pralni stroj
                    System.out.print("Vnesite znamko industrijskega pralnega stroja: ");
                    String znamka = scanner.nextLine(); // Preberemo znamko industrijskega pralnega stroja
                    System.out.print("Vnesite kapaciteto industrijskega pralnega stroja: ");
                    int kapaciteta = Integer.parseInt(scanner.nextLine()); // Preberemo kapaciteto industrijskega pralnega stroja
                    System.out.print("Vnesite število programov industrijskega pralnega stroja: ");
                    int steviloProgramov = Integer.parseInt(scanner.nextLine()); // Preberemo število programov industrijskega pralnega stroja
                    IndustrijskiPralniStroj industrijskiStroj = new IndustrijskiPralniStroj(znamka, kapaciteta, steviloProgramov); // Ustvarimo objekt industrijskega pralnega stroja
                    pralniStroji.add(industrijskiStroj); // Dodamo industrijski stroj v seznam

                    industrijskiStroj.vklopi(); // Vklopimo industrijski pralni stroj
                    System.out.print("Vnesite številko programa za industrijski pralni stroj: ");
                    int program = Integer.parseInt(scanner.nextLine()); // Preberemo številko programa za industrijski pralni stroj
                    industrijskiStroj.izberiProgram(program); // Izberemo program na industrijskem pralnem stroju
                    System.out.print("Vnesite težo pranja za industrijski pralni stroj: ");
                    int tezaPranja = Integer.parseInt(scanner.nextLine()); // Preberemo težo pranja za industrijski pralni stroj
                    industrijskiStroj.zacniPranje(tezaPranja); // Začnemo pranje z industrijskim pralnim strojem
                    industrijskiStroj.izklopi(); // Izklopimo industrijski pralni stroj
                } else {
                    System.out.println("Neveljaven tip pralnega stroja. Poskusite znova."); // Obvestimo uporabnika, če je vnesen neveljaven tip
                }
            } catch (Exception e) {
                System.out.println("Napaka: " + e.getMessage()); // Ujamemo in izpišemo izjemo
            }
        }

        // Izpis vseh objektov v seznamu
        System.out.println("\nIzpis vseh pralnih strojev:");
        for (PralniStroj stroj : pralniStroji) { // Iteriramo čez vse pralne stroje v seznamu
            System.out.println(stroj); // Izpišemo vsakega posebej
        }

        scanner.close(); // Zapremo scanner
    }
}