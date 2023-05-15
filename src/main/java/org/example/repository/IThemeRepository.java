package org.example.repository;

import org.example.model.Theme;

import java.util.List;

public interface IThemeRepository {
    List<Theme> findAllThemes(long idTheme);

    void save(String title);

    void remove(long idTheme);
}
