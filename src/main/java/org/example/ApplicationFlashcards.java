package org.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.example.model.Card;
import org.example.model.Theme;
import org.example.repository.CardJdbcRepository;
import org.example.repository.ThemeJdbcRepository;

import java.util.List;

public class ApplicationFlashcards {

    public static void main(String[] args) {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(System.getenv("FLASH_CARDS_URL"));
        hikariConfig.setUsername(System.getenv("FLASH_CARDS_USER"));
        hikariConfig.setPassword(System.getenv("FLASH_CARDS_PASSWORD"));

        try (HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig)) {

            ThemeJdbcRepository themeJdbcRepository = new ThemeJdbcRepository(hikariDataSource);
            CardJdbcRepository cardJdbcRepository = new CardJdbcRepository(hikariDataSource);

            List<Theme> allThemes = themeJdbcRepository.findThemeById(1);
            List<Card> allCardsByTheme = cardJdbcRepository.findAllCardsByTheme(1);

//        themeJdbcRepository.save("History");
//        themeJdbcRepository.remove(4);

//        cardJdbcRepository.save(2, "FWFWFWF", "12345", true);
//        cardJdbcRepository.remove(17);
//        cardJdbcRepository.updateIsLearned(1, true);

            System.out.println(allThemes);
            System.out.println(allCardsByTheme);
        }
    }
}
