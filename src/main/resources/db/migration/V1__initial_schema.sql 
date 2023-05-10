
DROP TABLE theme;

CREATE TABLE theme (
      theme_id         BIGSERIAL PRIMARY KEY,
      theme_title      TEXT NOT NULL
);

CREATE TABLE sub_theme(
    sub_theme_id        BIGSERIAL PRIMARY KEY,
    sub_theme_title     TEXT NOT NULL,
    theme_id            BIGINT       NOT NULL REFERENCES theme (theme_id)
);

CREATE TABLE card(
    card_id             BIGSERIAL PRIMARY KEY,
    question            TEXT NOT NULL,
    answer              TEXT NOT NULL,
    is_remember         BOOLEAN NOT NULL,
    sub_theme_id        BIGINT NOT NULL REFERENCES sub_theme(sub_theme_id)
);

INSERT INTO theme (theme_title) VALUES ('ENGLISH');
INSERT INTO theme (theme_title) VALUES ('IT');
INSERT INTO theme (theme_title) VALUES ('HISTORY');

INSERT INTO sub_theme (sub_theme_title, theme_id) VALUES ('COLOR', 1);
INSERT INTO sub_theme (sub_theme_title, theme_id) VALUES ('ANIMAL', 1);
INSERT INTO sub_theme (sub_theme_title, theme_id) VALUES ('VEGETABLES', 1);


