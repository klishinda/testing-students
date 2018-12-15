package scanner;

import ru.otus.model.Questionnaire;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class ScanStudentImplTest {

    private int correctAnswersCounter = 0;
    private Scanner inputStream;

    @Test
    void getName() {
        ByteArrayInputStream in = new ByteArrayInputStream(("Sergey" + System.lineSeparator() + "Sergeev").getBytes());
        inputStream = new Scanner(in);
        String name = inputStream.nextLine();
        String surname = inputStream.nextLine();
        assertThat(name + " " + surname).isEqualTo("Sergey Sergeev");
    }

    @Test
    void startQuestionnaire() {
        ArrayList<Questionnaire> quiz = new ArrayList();
        quiz.add(new Questionnaire("Тест?", "Да"));
        quiz.add(new Questionnaire("Сложный?", "Нет"));
        quiz.add(new Questionnaire("Много вопросов?", "Нет"));
        quiz.add(new Questionnaire("Сколько ответов на один вопрос?", "Один ответ"));

        ByteArrayInputStream in = new ByteArrayInputStream(("Да" + System.lineSeparator() + "Нет" + System.lineSeparator() + "0" + System.lineSeparator() + "XYZ").getBytes());
        inputStream = new Scanner(in);

        for (Questionnaire q : quiz) {
            String studentsAnswer = inputStream.nextLine();
            if (studentsAnswer.equals(q.getAnswer())) {
                correctAnswersCounter++;
            }
        }
        assertThat(correctAnswersCounter).isEqualTo(2);
        assertThat(quiz.size()).isEqualTo(4);
        assertTrue(quiz.contains(new Questionnaire("Сложный?", "Нет")));
    }
}