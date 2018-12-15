package ru.otus.scanner;


import ru.otus.model.Questionnaire;
import ru.otus.model.Result;
import ru.otus.model.Student;

import java.util.ArrayList;

public interface ScanStudent {
    Student getName();

    Result startQuestionnaire(ArrayList<Questionnaire> quizArray);
}
