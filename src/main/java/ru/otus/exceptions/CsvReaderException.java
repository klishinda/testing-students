package ru.otus.exceptions;

public class CsvReaderException extends Exception {
    public CsvReaderException(String errorMsg) {
        super(errorMsg);
    }
}
