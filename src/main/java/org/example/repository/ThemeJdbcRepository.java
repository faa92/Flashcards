package org.example.repository;

import org.example.model.Theme;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThemeJdbcRepository implements IThemeRepository {
    private final DataSource db;

    public ThemeJdbcRepository(DataSource db) {
        this.db = db;
    }

    @Override
    public List<Theme> findThemeById(long idTheme) {
        String sql = """
                SELECT theme.id                                          AS id,
                       theme.theme_title                                 AS title,
                       count(card_id)                                    AS total_cards_count,
                       count(card_id) FILTER (WHERE card.learned)        AS learned_cards_count
                FROM theme
                            LEFT JOIN card ON theme.id = card.theme_id
                WHERE theme.id = ?
                GROUP BY theme.id;""";
        try (
                Connection connection = db.getConnection();
                PreparedStatement pStatement = connection.prepareStatement(sql);
        ) {
            pStatement.setLong(1, idTheme);

            ResultSet resultSet = pStatement.executeQuery();
            List<Theme> result = new ArrayList<>();
            while (resultSet.next()) {
                result.add(new Theme(
                        resultSet.getLong("id"),
                        resultSet.getString("title"),
                        resultSet.getLong("total_cards_count"),
                        resultSet.getLong("learned_cards_count")
                ));
            }
            return result;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(String title) {
        String sql = """
                INSERT INTO theme (theme_title)
                VALUES (?)
                """;
        try (
                Connection connection = db.getConnection();
                PreparedStatement pStatement = connection.prepareStatement(sql);
        ) {
            pStatement.setString(1, title);
            pStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void remove(long idTheme) {
        String sql = """
                DELETE FROM theme
                WHERE id = ?""";
        try (
                Connection connection = db.getConnection();
                PreparedStatement pStatement = connection.prepareStatement(sql);
        ) {
            pStatement.setLong(1, idTheme);
            pStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
