-- Создать схему
CREATE SCHEMA questions;

-- Создать таблицу с вопросами
CREATE TABLE questions.questions (
    question_id    SERIAL        NOT NULL,
    question_text  VARCHAR(256)  NOT NULL,
    group_id       INTEGER       NOT NULL,
    is_active 	   BOOLEAN 	     NOT NULL DEFAULT TRUE
);
ALTER TABLE ONLY questions.questions
    ADD CONSTRAINT questions_pk PRIMARY KEY (question_id);

-- Создать таблицу с ответами
CREATE TABLE questions.answers (
    question_id  INTEGER       NOT NULL,
    answer_id    INTEGER       NOT NULL,
	answer_text  VARCHAR(256)  NOT NULL,
    is_correct 	 BOOLEAN 	   NOT NULL,
    is_active 	 BOOLEAN 	   NOT NULL DEFAULT TRUE
);
ALTER TABLE ONLY questions.answers
    ADD CONSTRAINT answers_pk
	PRIMARY KEY (question_id, answer_id);
ALTER TABLE questions.answers
    ADD CONSTRAINT fk_answers_question_id
	FOREIGN KEY (question_id)
	REFERENCES questions.questions(question_id)
	ON DELETE CASCADE;

-- Добавить в таблицу тестовые данные
INSERT INTO questions.questions(question_text, group_id, is_active)
VALUES
('Вопрос 1', 1, true),
('Вопрос 2', 2, true),
('Вопрос 3', 3, false);

-- Добавить в таблицу тестовые данные
INSERT INTO questions.answers(question_id, answer_id, answer_text, is_correct, is_active)
VALUES
(1, 1, 'Ответ 1', true, true),
(1, 2, 'Ответ 2', false, true),
(1, 3, 'Ответ 3', false, true),
(2, 1, 'Ответ 1', true, true),
(2, 2, 'Ответ 2', false, true),
(2, 3, 'Ответ 3', false, true),
(2, 4, 'Ответ 3', false, true),
(2, 5, 'Ответ 3', false, false),
(3, 1, 'Ответ 1', true, true),
(3, 2, 'Ответ 2', false, true),
(3, 3, 'Ответ 3', false, true);
