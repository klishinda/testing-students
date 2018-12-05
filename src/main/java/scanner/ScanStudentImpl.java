package scanner;

import model.Questionnaire;
import model.Result;
import model.Student;

import java.util.ArrayList;
import java.util.Scanner;


public class ScanStudentImpl implements ScanStudent {

    private int correctAnswersCounter = 0;
    private Scanner inputStream;

    public Student getName() {
        inputStream = new Scanner(System.in);
        System.out.println("Имя опрашиваемого : ");
        String name = inputStream.nextLine();
        System.out.println("Фамилия опрашиваемого : ");
        String surname = inputStream.nextLine();
        return new Student(name, surname);
    }

    public Result startQuestionnaire(ArrayList<Questionnaire> quizArray) {
        for (Questionnaire q : quizArray) {
            System.out.println("Вопрос : " + q.getQuestion());
            String studentsAnswer = inputStream.nextLine();
            if (studentsAnswer.equals(q.getAnswer())) {
                correctAnswersCounter++;
            }
        }

        return new Result(correctAnswersCounter, quizArray.size());
    }
}
