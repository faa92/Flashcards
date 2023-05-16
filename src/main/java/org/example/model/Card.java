package org.example.model;

public class Card {
    private final long idTheme;
    private final long idCard;
    private final String question;
    private final String answer;
    private boolean learned;

    public Card(long idTheme, long idCard, String question, String answer, boolean learned) {
        this.idTheme = idTheme;
        this.idCard = idCard;
        this.question = question;
        this.answer = answer;
        this.learned = learned;
    }

    public long getIdCard() {
        return idCard;
    }

    public long getIdTheme() {
        return idTheme;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isLearned() {
        return learned;
    }

    @Override
    public String toString() {
        return "Card{" +
                "idCard=" + idCard +
                ", idTheme=" + idTheme +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", learned=" + learned +
                '}';
    }
}
