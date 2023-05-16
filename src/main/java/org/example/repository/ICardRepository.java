package org.example.repository;

import org.example.model.Card;

import java.util.List;

public interface ICardRepository {
    List<Card> findAllCardsByTheme(long idTheme, long idCard);

    void save(long idTheme, String question, String answer boolean learned);

    void updateIsLearned(long idCard, boolean learned);

    void remove(long idCard);
}
