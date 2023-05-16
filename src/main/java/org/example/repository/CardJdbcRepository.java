package org.example.repository;

import org.example.model.Card;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CardJdbcRepository implements ICardRepository {
    private final DataSource db;

    public CardJdbcRepository(DataSource db) {
        this.db = db;
    }

    @Override
    public List<Card> findAllCardsByTheme(long idTheme, long idCard) {
        String sql = """
                SELECT card_id             AS id,
                       theme_id            AS theme_id,
                       question            AS question,
                       answer              AS answer,
                       learned             AS learned
                FROM card
                WHERE to_do_item.folder_id = ?""";
        try (
                Connection connection = db.getConnection();
                PreparedStatement pStatement = connection.prepareStatement(sql);
        ) {
            int i = 1;
            pStatement.setLong(i++, idTheme);
            pStatement.setLong(i++, idCard);

            ResultSet resultSet = pStatement.executeQuery();
            List<Card> result = new ArrayList<>();
            while (resultSet.next()) {
                result.add(new Card(
                        resultSet.getLong("id"),
                        resultSet.getLong("theme_id"),
                        resultSet.getString("question"),
                        resultSet.getString("answer"),
                        resultSet.getBoolean("learned")
                ));
            }
            return result;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(long idTheme, String question, String answer, boolean learned) {
        String sql = """
                INSERT INTO card (theme_id, question, answer, learned)
                VALUES (?, ?, ?, ?)""";
        try (
                Connection connection = db.getConnection();
                PreparedStatement pStatement = connection.prepareStatement(sql);
        ) {
            int i = 1;
            pStatement.setLong(i++, idTheme);
            pStatement.setString(i++, question);
            pStatement.setString(i++, answer);
            pStatement.setBoolean(i++, learned);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateIsLearned(long idCard, boolean learned) {
        String sql = """
                UPDATE card
                SET learned = ?
                WHERE card_id = ?""";
        try (
                Connection connection = db.getConnection();
                PreparedStatement pStatement = connection.prepareStatement(sql);
        ) {
            int i = 1;
            pStatement.setLong(i++, idCard);
            pStatement.setBoolean(i++, learned);
            pStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void remove(long idCard) {
        String sql = """
                DELETE FROM  card
                WHERE card_id = ?""";
        try (
                Connection connection = db.getConnection();
                PreparedStatement pStatement = connection.prepareStatement(sql);
        ) {
            pStatement.setLong(1, idCard);
            pStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
