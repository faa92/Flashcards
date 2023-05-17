package org.example;

import org.example.repository.CardJdbcRepository;
import org.example.repository.ThemeJdbcRepository;
import org.postgresql.ds.PGSimpleDataSource;

import java.util.Scanner;

public class ApplicationFlashcards {

    public static void main(String[] args) {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setUrl(System.getenv("FLASH_CARDS_URL"));
        dataSource.setUser(System.getenv("FLASH_CARDS_USER"));
        dataSource.setPassword(System.getenv("FLASH_CARDS_PASSWORD"));

        ThemeJdbcRepository themeJdbcRepository = new ThemeJdbcRepository(dataSource);
        CardJdbcRepository cardJdbcRepository = new CardJdbcRepository(dataSource);
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                listThemes           <idTheme>
                getTheme             <idTheme>
                getLearnedCards      <idTheme> <idCard>
                getNotLearnedCards   <idTheme> <idCard>
                addTheme             <them> 
                removeThem           <idTheme>
                getCardsOfTheme      <idTheme> <idCard>
                addCard              <idTheme> <idCard>
                exit""");
        while (true) {
            System.out.println("> ");
            String command = scanner.nextLine();
            String[] parts = command.split("\\s+");
            switch (parts[0]) {
                case "listThemes" -> {

                }
            }
        }


    }
}
