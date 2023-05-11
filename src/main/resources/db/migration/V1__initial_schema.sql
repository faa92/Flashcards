
-- DROP TABLE card;

CREATE TABLE theme
(
      theme_id    BIGSERIAL PRIMARY KEY,
      theme_title TEXT NOT NULL
);

CREATE TABLE card
(
      card_id  BIGSERIAL PRIMARY KEY,
      theme_id BIGINT  NOT NULL REFERENCES theme ON DELETE CASCADE,
      question TEXT    NOT NULL,
      answer   TEXT    NOT NULL,
      learned  BOOLEAN NOT NULL
);

INSERT INTO theme (theme_title)
VALUES ('ENGLISH');
INSERT INTO theme (theme_title)
VALUES ('MATHEMATICS');
INSERT INTO theme (theme_title)
VALUES ('JAVA');

INSERT INTO card (theme_id, question, answer, learned)
VALUES (1, 'RED', 'КРАСНЫЙ', false);
INSERT INTO card (theme_id, question, answer, learned)
VALUES (1, 'GREEN', 'ЗЕЛЁНЫЙ', false);
INSERT INTO card (theme_id, question, answer, learned)
VALUES (1, 'BLUE', 'СИНИЙ', false);
INSERT INTO card (theme_id, question, answer, learned)
VALUES (1, 'WHITE', 'БЕЛЫЙ', false);
INSERT INTO card (theme_id, question, answer, learned)
VALUES (1, 'BLACK', 'ЧЁРНЫЙ', false);

INSERT INTO card (theme_id, question, answer, learned)
VALUES (2, '1*1', '1', false);
INSERT INTO card (theme_id, question, answer, learned)
VALUES (2, '2*2', '4', false);
INSERT INTO card (theme_id, question, answer, learned)
VALUES (2, '3*3', '9', false);
INSERT INTO card (theme_id, question, answer, learned)
VALUES (2, '4*4', '16', false);
INSERT INTO card (theme_id, question, answer, learned)
VALUES (2, '5*5', '25', false);

INSERT INTO card (theme_id, question, answer, learned)
VALUES (3, '\s', 'ПРОБЕЛЬНЫЙ СИМВОЛ', false);
INSERT INTO card (theme_id, question, answer, learned)
VALUES (3, '^', 'НАЧАЛО СТРОКИ', false);
INSERT INTO card (theme_id, question, answer, learned)
VALUES (3, '$', 'КОНЕЦ СТРОКИ', false);
INSERT INTO card (theme_id, question, answer, learned)
VALUES (3, '\b', 'ГРАНИЦА СЛОВА', false);
INSERT INTO card (theme_id, question, answer, learned)
VALUES (3, '\.', 'ЭКРАНИРОВАНИЕ СПЕЦ.СИМВОЛОВ', false);





