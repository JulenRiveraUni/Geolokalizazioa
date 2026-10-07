package paagbi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // XMLtik herrialdeak irakurri
        List<Countries> herrialdeak = XMLReader.irakurriHerrialdeak();

        // Herrialdeak nahastu
        Collections.shuffle(herrialdeak);

        // 5 herrialde aukeratu
        List<Countries> aukeratutakoHerrialdeak = new ArrayList<>(herrialdeak.subList(0, 5));

        // Lehenengo 2 herrialdeak kutsatutakoak izango dira
        List<Countries> kutsatutakoHerrialdeak = new ArrayList<>(aukeratutakoHerrialdeak.subList(0, 2));

        // Aurkitutako herrialde kutsatuak
        List<Countries> aurkitutakoHerrialdeak = new ArrayList<>();

        // JOKOAREN HASIERA
        System.out.println("================================");
        System.out.println("       INBASIO ALIENIGENA");
        System.out.println("================================");
        System.out.println();
        System.out.println("5 herrialde agertuko dira.");
        System.out.println("Horietako 2 kutsatuta daude.");
        System.out.println("Zure helburua 2 herrialde kutsatuak aurkitzea da.");
        System.out.println();

        // 5 HERRIALDEAK ERAKUTSI
        System.out.println("================================");
        System.out.println("       HERRIALDEA AUKERATU");
        System.out.println("================================");

        for (int i = 0; i < aukeratutakoHerrialdeak.size(); i++) {
            System.out.println((i + 1) + ". " + aukeratutakoHerrialdeak.get(i).getIzena());
        }

        System.out.println();
        System.out.println("================================");
        System.out.println();

        // Lehenengo pista erakutsi
        erakutsiPista(kutsatutakoHerrialdeak,aurkitutakoHerrialdeak);

        // JOKOA
        while (aurkitutakoHerrialdeak.size() < 2) {

            System.out.print("Aukeratu herrialde bat (1-5): ");

            int aukera = sc.nextInt();

            // Aukera zuzena den egiaztatu
            if (aukera < 1 || aukera > 5) {
                System.out.println();
                System.out.println("Aukera okerra. 1 eta 5 arteko zenbaki bat sartu.");
                System.out.println();
                continue;
            }

            // Aukeratutako herrialdea lortu
            Countries aukeratutakoHerrialdea = aukeratutakoHerrialdeak.get(aukera - 1);

            // Herrialdea kutsatuta dagoen egiaztatu
            if (kutsatutakoHerrialdeak.contains(aukeratutakoHerrialdea)) {

                // Aurretik aurkitu den egiaztatu
                if (!aurkitutakoHerrialdeak.contains(aukeratutakoHerrialdea)) {

                    aurkitutakoHerrialdeak.add(aukeratutakoHerrialdea);

                    System.out.println();
                    System.out.println("AURKITU DUZU: " + aukeratutakoHerrialdea.getIzena()+ "!");
                    System.out.println("Aurkitutako herrialde kutsatuak: " + aurkitutakoHerrialdeak.size()+ "/2");
                    // Pista erakutsi
                    erakutsiPista(kutsatutakoHerrialdeak,aurkitutakoHerrialdeak);

                } else {
                    System.out.println();
                    System.out.println("Dagoeneko aurkitu duzu " + aukeratutakoHerrialdea.getIzena()+ ".");
                
                    // Pista erakutsi
                    erakutsiPista(kutsatutakoHerrialdeak,aurkitutakoHerrialdeak);
                }

            } else { // HUTS EGIN DU

                System.out.println();
                System.out.println("EZ DUZU ASMATU!");

                // Pista erakutsi
                erakutsiPista(kutsatutakoHerrialdeak,aurkitutakoHerrialdeak);
            }

            System.out.println();
        }

        // JOKOA AMAITU
        System.out.println("================================");
        System.out.println( "  2 HERRIALDEAK DESAGERRARAZI DITUZU!");
        System.out.println("================================");
        System.out.println();

        System.out.println("Zorionak! Inbasioa gelditu duzu.");

        sc.close();
    }

    //Pista erakusteko metodoa
    public static void erakutsiPista(List<Countries> kutsatutakoHerrialdeak,List<Countries> aurkitutakoHerrialdeak) {
        if(aurkitutakoHerrialdeak.size() != 2){
        // Oraindik aurkitu gabeko herrialde kutsatuak bilatu
        List<Countries> faltaDirenHerrialdeak = new ArrayList<>(kutsatutakoHerrialdeak);

        faltaDirenHerrialdeak.removeAll(aurkitutakoHerrialdeak);

        // Lehenengo falta den herrialde kutsatua hartu
        Countries pista = faltaDirenHerrialdeak.get(0);

        System.out.println();
        System.out.println("================================");
        System.out.println("              PISTA");
        System.out.println("================================");
        System.out.println("Latitudea: " + pista.getLatitudeMin() + " - " + pista.getLatitudeMax());
        System.out.println("Longitudea: " + pista.getLongitudeMin() + " - " + pista.getLongitudeMax());
        System.out.println("================================");
        System.out.println();
            
        }
        
    }
}