package ru.otus.serviceRunner;


import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.otus.dao.CsvReader;
import ru.otus.exceptions.CsvReaderException;
import ru.otus.exceptions.WrongInputsError;
import ru.otus.finalResults.FinalResultsImpl;
import ru.otus.localization.LocaleService;
import ru.otus.model.Questionnaire;
import ru.otus.model.Result;
import ru.otus.model.Student;
import ru.otus.scanner.ScanStudentImpl;
import ru.otus.studentService.StudentService;
import ru.otus.wordEndings.WordEndings;

import java.util.ArrayList;


public class ServiceRunnerImpl implements ServiceRunner {

    @Override
    public void runService(AnnotationConfigApplicationContext context) throws WrongInputsError, CsvReaderException {
        context.getBean(MessageSource.class);

        LocaleService localization = context.getBean(LocaleService.class);
        localization.setLocalization();

        StudentService studService = context.getBean(StudentService.class);
        Student st = studService.getCurrentStudent();

        CsvReader reader = context.getBean(CsvReader.class);
        ArrayList<Questionnaire> quizArray = reader.readCsv();

        ScanStudentImpl testing = context.getBean(ScanStudentImpl.class);
        Result res = testing.startQuestionnaire(quizArray);

        WordEndings end = context.getBean(WordEndings.class);
        String ending = end.getWordEnding(res.getCorrectAnswers());

        FinalResultsImpl results = context.getBean(FinalResultsImpl.class);
        results.printResults(st, res, ending);

    }
}