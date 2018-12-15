package ru.otus.dao;

import ru.otus.exceptions.CsvReaderException;
import ru.otus.model.Result;

public interface CsvReader {
    Result start() throws CsvReaderException;
}
