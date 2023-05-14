package org.example.model;

public class Theme {
    private final long idTheme;
    private final String title;
    private final long totalCardsCount;
    private final long doneCardsCount;

    public Theme(long idTheme, String title, long totalCardsCount, long doneCardsCount) {
        this.idTheme = idTheme;
        this.title = title;
        this.totalCardsCount = totalCardsCount;
        this.doneCardsCount = doneCardsCount;
    }

    public long getIdTheme() {
        return idTheme;
    }

    public String getTitle() {
        return title;
    }

    public long getTotalCardsCount() {
        return totalCardsCount;
    }

    public long getDoneCardsCount() {
        return doneCardsCount;
    }

    @Override
    public String toString() {
        return "Theme{" +
                "idTheme=" + idTheme +
                ", title='" + title + '\'' +
                ", totalCardsCount=" + totalCardsCount +
                ", doneCardsCount=" + doneCardsCount +
                '}';
    }
}
