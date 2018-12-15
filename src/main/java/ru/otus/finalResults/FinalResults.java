package ru.otus.finalResults;

import ru.otus.model.Result;
import ru.otus.model.Student;

public interface FinalResults {
    void printResults(Student student, Result result, String wordEnding);
}
