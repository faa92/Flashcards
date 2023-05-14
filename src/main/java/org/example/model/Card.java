package org.example.model;

public class Card {
    private final long idCard;
    private final long idTheme;
    private final String question;
    private final String answer;
    private boolean learned;

    public Card(long idCard, long idTheme, String question, String answer, boolean learned) {
        this.idCard = idCard;
        this.idTheme = idTheme;
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
