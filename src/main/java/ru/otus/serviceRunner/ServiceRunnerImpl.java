package ru.otus.serviceRunner;


import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.otus.exceptions.CsvReaderException;
import ru.otus.exceptions.WrongInputsError;
import ru.otus.localization.LocaleService;
import ru.otus.model.Language;
import ru.otus.model.Result;
import ru.otus.model.Student;
import ru.otus.questionService.QuestionService;
import ru.otus.studentService.StudentService;


public class ServiceRunnerImpl implements ServiceRunner {

    @Override
    public void runService(AnnotationConfigApplicationContext context) throws WrongInputsError, CsvReaderException {
        MessageSource ms = context.getBean(MessageSource.class);

        LocaleService localization = context.getBean(LocaleService.class);
        localization.setLocalization();

        StudentService studService = context.getBean(StudentService.class);
        Student st = studService.getCurrentStudent();

        QuestionService quizService = context.getBean(QuestionService.class);
        Result res = quizService.startTesting();
        System.out.println("_____________________________________________________________________");
        System.out.println(ms.getMessage("service_runner.results", null, Language.language));
        System.out.println(ms.getMessage("service_runner.results_detail_info", new String[] {st.getName(), st.getSurname(), String.valueOf(res.getCorrectAnswers()), res.getWordEnding(), String.valueOf(res.getAllQuestions())}, Language.language));
    }
}