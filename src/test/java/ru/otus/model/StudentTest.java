package ru.otus.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Testing @DisplayName =)")
class StudentTest {
    private Student student = new Student("Sergeev", "Sergey");

    @Test
    @DisplayName("Surname return testing")
    void getSurname() {
        assertThat(student.getSurname()).isNotEqualTo("Ivanov");
    }

    @Test
    void getName() {
        assertThat(student.getName()).isNotEqualTo("Serg");
        assertThat(student.getName()).isEqualTo("Sergey");
    }
}