package ru.otus.questionService;

import ru.otus.exceptions.CsvReaderException;
import ru.otus.model.Result;

public interface QuestionService {
    Result startTesting() throws CsvReaderException;
}
