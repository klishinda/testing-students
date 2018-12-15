package ru.otus.questionService;

import org.springframework.stereotype.Service;
import ru.otus.dao.CsvReader;
import ru.otus.exceptions.CsvReaderException;
import ru.otus.model.Result;

@Service
public class QuestionServiceImpl implements QuestionService{
    private CsvReader reader;

    public QuestionServiceImpl(CsvReader reader) {this.reader = reader;}

    public Result startTesting() throws CsvReaderException {
        return reader.start();
    }
}
