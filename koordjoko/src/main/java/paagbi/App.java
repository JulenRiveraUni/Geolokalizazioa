package paagbi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Leer todos los países del XML
        List<Countries> paises = XMLReader.leerPaises();

        // Elegir 3 países aleatorios
        Collections.shuffle(paises);

        List<Countries> paisesObjetivo = new ArrayList<>(
                paises.subList(0, 3)
        );

        // ----------------------------------------
        // ELEGIR LOS 2 PAÍSES PISTA
        // ----------------------------------------

        // Copiamos todos los países
        List<Countries> paisesPista = new ArrayList<>(paises);

        // Quitamos los 3 países objetivo
        paisesPista.removeAll(paisesObjetivo);

        // Mezclamos los países restantes
        Collections.shuffle(paisesPista);

        // Elegimos las 2 primeras pistas
        List<Countries> pistas = new ArrayList<>(
                paisesPista.subList(0, 2)
        );

        // Lista de países encontrados
        List<Countries> paisesDone = new ArrayList<>();

        // ----------------------------------------
        // INICIO DEL JUEGO
        // ----------------------------------------

        System.out.println("================================");
        System.out.println("       INVASIÓN ALIENÍGENA");
        System.out.println("================================");
        System.out.println();
        System.out.println("Tienes que encontrar 3 países.");
        System.out.println("Introduce coordenadas para intentar localizarlos.");
        System.out.println();

        // ----------------------------------------
        // MOSTRAR LOS PAÍSES OBJETIVO
        // ----------------------------------------

        System.out.println("================================");
        System.out.println("       PAÍSES A EXTERMINAR");
        System.out.println("================================");

        for (Countries pais : paisesObjetivo) {
            System.out.println("- " + pais.getName());
        }

        System.out.println();

        // ----------------------------------------
        // MOSTRAR LAS PISTAS
        // ----------------------------------------

        System.out.println("================================");
        System.out.println("           PAÍSES PISTA");
        System.out.println("================================");

        for (Countries pista : pistas) {

            System.out.println();
            System.out.println(pista.getName());

            System.out.println(
                    "Latitud: "
                    + pista.getLatitudeMin()
                    + " - "
                    + pista.getLatitudeMax()
            );

            System.out.println(
                    "Longitud: "
                    + pista.getLongitudeMin()
                    + " - "
                    + pista.getLongitudeMax()
            );
        }

        System.out.println();
        System.out.println("================================");
        System.out.println();

        // ----------------------------------------
        // JUEGO
        // ----------------------------------------

        // Mientras no encontremos los 3 países
        while (paisesDone.size() < paisesObjetivo.size()) {

            System.out.print("Introduce la latitud: ");
            double latitude = sc.nextDouble();

            System.out.print("Introduce la longitud: ");
            double longitude = sc.nextDouble();

            boolean encontrado = false;

            // Comprobar la coordenada contra los países objetivo
            for (Countries pais : paisesObjetivo) {

                if (pais.contains(latitude, longitude)) {

                    encontrado = true;

                    // Comprobar que no lo hayamos encontrado antes
                    if (!paisesDone.contains(pais)) {

                        paisesDone.add(pais);

                        System.out.println();
                        System.out.println(
                                "¡HAS ENCONTRADO " + pais.getName() + "!"
                        );

                        System.out.println(
                                "Países encontrados: "
                                + paisesDone.size()
                                + "/"
                                + paisesObjetivo.size()
                        );

                    } else {

                        System.out.println();
                        System.out.println(
                                "Ya habías encontrado "
                                + pais.getName()
                                + "."
                        );
                    }

                    break;
                }
            }

            if (!encontrado) {

                System.out.println();
                System.out.println("No has encontrado ningún país.");
            }

            System.out.println();
        }

        System.out.println("================================");
        System.out.println("¡HAS EXTERMINADO LOS 3 PAÍSES!");
        System.out.println("================================");

        sc.close();
    }
}