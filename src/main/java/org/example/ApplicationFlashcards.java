package org.example;

import org.postgresql.ds.PGSimpleDataSource;

public class ApplicationFlashcards {

    public static void main(String[] args) {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();

        dataSource.getUrl();
        dataSource.getUser();
        dataSource.getPassword();
//
//        try {
//            Connection connection = dataSource.getConnection();
//            Statement statement = connection.createStatement();
//        }


    }
}