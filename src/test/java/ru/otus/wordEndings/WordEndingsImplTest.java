package ru.otus.wordEndings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WordEndingsImplTest {

    @Test
    void getWordEnding() {
        Assertions.assertAll(
                () -> assertThat(1).isEqualTo(""),
                () -> assertThat(5).isEqualTo("ов"),
                () -> assertThat(14).isEqualTo("ов"),
                () -> assertThat(15).isEqualTo("ов"),
                () -> assertThat(22).isEqualTo("а"),
                () -> assertThat(100).isEqualTo("ов"),
                () -> assertThat(101).isEqualTo(""),
                () -> assertThat(102).isEqualTo("а"),
                () -> assertThat(2018).isEqualTo("ов"),
                () -> assertThat(44444).isEqualTo("а"),

                () -> assertThat(0).isNotEqualTo(""),
                () -> assertThat(11).isNotEqualTo("а"),
                () -> assertThat(21).isNotEqualTo("ов")
        );
    }
}
