package org.example;

import org.example.model.Theme;
import org.example.repository.CardJdbcRepository;
import org.example.repository.ThemeJdbcRepository;
import org.postgresql.ds.PGSimpleDataSource;

import java.util.List;

public class ApplicationFlashcards {

    public static void main(String[] args) {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setUrl(System.getenv("FLASH_CARDS_URL"));
        dataSource.setUser(System.getenv("FLASH_CARDS_USER"));
        dataSource.setPassword(System.getenv("FLASH_CARDS_PASSWORD"));


        ThemeJdbcRepository themeJdbcRepository = new ThemeJdbcRepository(dataSource);
        CardJdbcRepository cardJdbcRepository = new CardJdbcRepository(dataSource);

        List<Theme> allThemes = themeJdbcRepository.findAllThemes(1);
//        List<Card> allCardsByTheme = cardJdbcRepository.findAllCardsByTheme(1);

//        themeJdbcRepository.save("History");
//        themeJdbcRepository.remove(4);

//        cardJdbcRepository.save(2, "FWFWFWF", "12345", true);
//        cardJdbcRepository.remove(17);
//        cardJdbcRepository.updateIsLearned(1, true);

        System.out.println(allThemes);
//        System.out.println(allCardsByTheme);


    }
}
