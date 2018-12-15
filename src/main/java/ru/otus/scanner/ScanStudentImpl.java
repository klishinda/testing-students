package ru.otus.scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.model.Language;
import ru.otus.model.Questionnaire;
import ru.otus.model.Result;
import ru.otus.model.Student;

import java.util.ArrayList;
import java.util.Scanner;

@Service
public class ScanStudentImpl implements ScanStudent {

    private int correctAnswersCounter = 0;
    private Scanner inputStream;

    @Autowired
    private MessageSource ms;

    public Student getName() {
        inputStream = new Scanner(System.in);
        System.out.println(ms.getMessage("scan_student.name", null, Language.language));
        String name = inputStream.nextLine();
        System.out.println(ms.getMessage("scan_student.surname", null, Language.language));
        String surname = inputStream.nextLine();
        return new Student(name, surname);
    }

    public Result startQuestionnaire(ArrayList<Questionnaire> quizArray) {
        for (Questionnaire q : quizArray) {
            System.out.println(ms.getMessage("scan_student.question", null, Language.language) + " " + q.getQuestion());
            String studentsAnswer = inputStream.nextLine();
            if (studentsAnswer.equals(q.getAnswer())) {
                correctAnswersCounter++;
            }
        }

        return new Result(correctAnswersCounter, quizArray.size());
    }
}
