package org.example.repository;

import org.example.model.Card;

import java.util.List;

public interface ICardRepository {
    List<Card> findAllCardsByTheme(long idTheme);

    void save(long idTheme, boolean done, String title);

    void updateIsDone(long idCard, boolean done);

    void remove(long idCard);
}
