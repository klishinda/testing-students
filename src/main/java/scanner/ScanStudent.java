package scanner;

import model.Questionnaire;
import model.Result;
import model.Student;

import java.util.ArrayList;

public interface ScanStudent {
    Student getName();

    Result startQuestionnaire(ArrayList<Questionnaire> quizArray);
}
