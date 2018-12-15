package ru.otus.localization;

import ru.otus.exceptions.WrongInputsError;
import ru.otus.model.Language;

public interface LocaleService {
    Language setLocalization() throws WrongInputsError;
}