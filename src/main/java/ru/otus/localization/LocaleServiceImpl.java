package ru.otus.localization;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.exceptions.WrongInputsError;
import ru.otus.messageManager.MessageManager;

import java.util.Locale;
import java.util.Scanner;

@Service
public class LocaleServiceImpl implements LocaleService {
    private static final int MAX_ERROR_ATTEMPTS = 3;
    private int errorCounts = 0;

    @Autowired
    private MessageManager messageManager;

    @Override
    public void setLocalization() throws WrongInputsError {
        checkWrongAttempts();

        Scanner inputStream = new Scanner(System.in);
        System.out.println("Enter your preferred language, EN (english) or RU (russian):");
        String lang = inputStream.nextLine();

        if (lang.equals("EN")) {
            messageManager.setLocale(Locale.ENGLISH);
        }
        else if (lang.equals("RU")) {
            messageManager.setLocale(new Locale("ru"));
        }
        else {
            System.out.println("Your input is wrong, please try again.");
            errorCounts++;
            setLocalization();
        }
    }

    private void checkWrongAttempts() throws WrongInputsError {
        if (errorCounts >= MAX_ERROR_ATTEMPTS) {
            throw new WrongInputsError("You are too stupid for this test, go away!!!");
        }
    }
}
