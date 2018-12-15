package ru.otus.messageManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import ru.otus.localization.LocaleServiceImpl;

import java.util.Locale;

@Component
public class MessageManagerImpl implements MessageManager {
    private Locale language;

    @Autowired
    LocaleServiceImpl localeService;

    @Autowired
    private MessageSource messageSource;


    @Override
    public String getMessage(String parameterName) {
        return messageSource.getMessage(parameterName, null, language);
    }

    @Override
    public String getMessage(String parameterName, Object[] listOfParameters) {
        return messageSource.getMessage(parameterName, listOfParameters, language);
    }

    @Override
    public void setLocale(Locale language) {
        this.language = language;
    }

    @Override
    public Locale getLocale() {
        return language;
    }
}
