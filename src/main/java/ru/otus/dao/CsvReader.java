package ru.otus.dao;

import ru.otus.exceptions.CsvReaderException;
import ru.otus.model.Questionnaire;

import java.util.ArrayList;

public interface CsvReader {
    ArrayList<Questionnaire> readCsv() throws CsvReaderException;
}
