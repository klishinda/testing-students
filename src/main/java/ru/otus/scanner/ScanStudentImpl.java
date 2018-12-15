package ru.otus.scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.model.Questionnaire;
import ru.otus.model.Result;
import ru.otus.model.Student;
import ru.otus.messageManager.MessageManager;

import java.util.ArrayList;
import java.util.Scanner;

@Service
public class ScanStudentImpl implements ScanStudent {

    private int correctAnswersCounter = 0;
    private Scanner inputStream;

    @Autowired
    private MessageManager messageManager;

    public Student getName() {
        inputStream = new Scanner(System.in);
        System.out.println(messageManager.getMessage("scan_student.name"));
        String name = inputStream.nextLine();
        System.out.println(messageManager.getMessage("scan_student.surname"));
        String surname = inputStream.nextLine();
        return new Student(name, surname);
    }

    public Result startQuestionnaire(ArrayList<Questionnaire> quizArray) {
        System.out.println(messageManager.getMessage("scan_student.questions_ready"));
        for (Questionnaire q : quizArray) {
            System.out.println(messageManager.getMessage("scan_student.question") + " " + q.getQuestion());
            String studentsAnswer = inputStream.nextLine();
            if (studentsAnswer.equals(q.getAnswer())) {
                correctAnswersCounter++;
            }
        }

        return new Result(correctAnswersCounter, quizArray.size());
    }
}
