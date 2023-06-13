package org.lessons.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continua = true;

        while (continua) {
            System.out.println("Inserisci il titolo dell'evento:");
            String titolo = scanner.nextLine();

            System.out.println("Inserisci la data dell'evento (gg/mm/aaaa):");
            LocalDate data = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            System.out.println("Inserisci il numero di posti totali disponibili:");
            int postiTotali = Integer.parseInt(scanner.nextLine());

            try {
                Evento evento = new Evento(titolo, data, postiTotali);

                System.out.println("Vuoi effettuare delle prenotazioni? (S/N)");
                String sceltaPrenotazioni = scanner.nextLine();

                while (sceltaPrenotazioni.equalsIgnoreCase("S")) {
                    System.out.println("Quante prenotazioni vuoi effettuare?");
                    int numeroPrenotazioni = Integer.parseInt(scanner.nextLine());

                    for (int i = 0; i < numeroPrenotazioni; i++) {
                        try {
                            evento.prenota();
                            System.out.println("Prenotazione effettuata");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    System.out.println("Vuoi effettuare altre prenotazioni? (S/N)");
                    sceltaPrenotazioni = scanner.nextLine();
                }

                System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
                System.out.println("Posti disponibili: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));

                System.out.println("Vuoi disdire dei posti prenotati? (S/N)");
                String sceltaDisdette = scanner.nextLine();

                while (sceltaDisdette.equalsIgnoreCase("S")) {
                    System.out.println("Quanti posti vuoi disdire?");
                    int numeroDisdette = Integer.parseInt(scanner.nextLine());

                    for (int i = 0; i < numeroDisdette; i++) {
                        try {
                            evento.disdici();
                            System.out.println("Disdetta effettuata.");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    System.out.println("Vuoi effettuare altre disdette? (S/N)");
                    sceltaDisdette = scanner.nextLine();
                }

                System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
                System.out.println("Posti disponibili: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));

                System.out.println("Parametri dell'evento:");
                System.out.println("Titolo: " + evento.getTitolo());
                System.out.println("Data: " + data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                System.out.println("Posti totali: " + evento.getPostiTotali());
                System.out.println("Posti prenotati: " + evento.getPostiPrenotati());

                System.out.println("Vuoi creare un nuovo evento? (S/N)");
                String sceltaNuovoEvento = scanner.nextLine();
                if (!sceltaNuovoEvento.equalsIgnoreCase("S")) {
                    continua = false;
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }
}
