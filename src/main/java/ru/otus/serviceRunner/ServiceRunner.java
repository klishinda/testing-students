package ru.otus.serviceRunner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.otus.exceptions.CsvReaderException;
import ru.otus.exceptions.WrongInputsError;

public interface ServiceRunner {
    void runService(AnnotationConfigApplicationContext context) throws WrongInputsError, CsvReaderException;
}
