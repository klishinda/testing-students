package ru.otus.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class ResultTest {
    private Result res = new Result(3, 5);

    @Test
    void getCorrectAnswers() {
        assertThat(res.getCorrectAnswers()).isEqualTo(3);
    }

    @Test
    void getAllQuestions() {
        assertThat(res.getAllQuestions()).isEqualTo(5);
    }

    @Test
    void getWordEnding() {
        Assertions.assertAll(
                () -> assertThat(res.setCorrectAnswers(1)).isEqualTo(""),
                () -> assertThat(res.setCorrectAnswers(5)).isEqualTo("ов"),
                () -> assertThat(res.setCorrectAnswers(14)).isEqualTo("ов"),
                () -> assertThat(res.setCorrectAnswers(15)).isEqualTo("ов"),
                () -> assertThat(res.setCorrectAnswers(22)).isEqualTo("а"),
                () -> assertThat(res.setCorrectAnswers(100)).isEqualTo("ов"),
                () -> assertThat(res.setCorrectAnswers(101)).isEqualTo(""),
                () -> assertThat(res.setCorrectAnswers(102)).isEqualTo("а"),
                () -> assertThat(res.setCorrectAnswers(2018)).isEqualTo("ов"),
                () -> assertThat(res.setCorrectAnswers(444444)).isEqualTo("а"),

                () -> assertThat(res.setCorrectAnswers(0)).isNotEqualTo(""),
                () -> assertThat(res.setCorrectAnswers(11)).isNotEqualTo("а"),
                () -> assertThat(res.setCorrectAnswers(21)).isNotEqualTo("ов")
        );
    }
}