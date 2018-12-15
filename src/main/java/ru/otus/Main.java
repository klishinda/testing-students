package ru.otus;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.otus.exceptions.CsvReaderException;
import ru.otus.exceptions.WrongInputsError;
import ru.otus.serviceRunner.ServiceRunnerImpl;


@Configuration
@ComponentScan
public class Main {

    public static void main(String[] args) throws WrongInputsError, CsvReaderException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);
        ServiceRunnerImpl service = new ServiceRunnerImpl();
        service.runService(context);
    }
}
