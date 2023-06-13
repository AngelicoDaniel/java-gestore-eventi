package org.lessons.java;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            Evento concerto = new Evento("Concerto Live", LocalDate.of(2023, 9, 15), 100);

            System.out.println(concerto);

            concerto.prenota();
            System.out.println(concerto.getPostiPrenotati());

            concerto.disdici();
            System.out.println(concerto.getPostiPrenotati());

            try {
                concerto.setData(LocalDate.of(2023, 6, 13));
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
