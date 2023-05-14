package org.example;

import org.postgresql.ds.PGSimpleDataSource;

public class ApplicationFlashcards {

    public static void main(String[] args) {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setUrl(System.getenv("FLASH_CARDS_URL"));
        dataSource.setUser(System.getenv("FLASH_CARDS_USER"));
        dataSource.setPassword(System.getenv("FLASH_CARDS_PASSWORD"));
//
//        try {
//            Connection connection = dataSource.getConnection();
//            Statement statement = connection.createStatement();
//        }


    }
}