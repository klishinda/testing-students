package ru.otus.localization;

import ru.otus.exceptions.WrongInputsError;

public interface LocaleService {
    void setLocalization() throws WrongInputsError;
}