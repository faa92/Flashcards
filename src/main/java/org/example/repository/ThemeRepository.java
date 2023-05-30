package org.example.repository;

import org.example.model.Theme;

import java.util.List;

public interface ThemeRepository {
    List<Theme> findThemeById(long idTheme);

    void save(String title);

    void remove(long idTheme);
}
