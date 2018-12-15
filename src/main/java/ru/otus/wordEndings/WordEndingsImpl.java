package ru.otus.wordEndings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.messageManager.MessageManager;

import java.util.Locale;

@Service
public class WordEndingsImpl implements WordEndings {
    @Autowired
    private MessageManager messageManager;

    @Override
    public String getWordEnding (int correctAnswers) {
        Locale local = messageManager.getLocale();

        if (local != Locale.ENGLISH) {
            if (correctAnswers >= 11 && correctAnswers <= 19) {
                return messageManager.getMessage("result.ending_ov");
            } else {
                int mod = correctAnswers % 10;

                if (mod == 2 || mod == 3 || mod == 4) {
                    return messageManager.getMessage("result.ending_a");
                } else if (mod == 1) {
                    return "";
                } else {
                    return messageManager.getMessage("result.ending_ov");
                }
            }
        }
        else {
            System.out.println("%%%%%%");
            if (correctAnswers != 1) {
                return messageManager.getMessage("result.ending_many");
            }
            else {
                return "";
            }
        }
    }
}
