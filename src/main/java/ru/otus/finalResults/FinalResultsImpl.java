package ru.otus.finalResults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.model.Result;
import ru.otus.model.Student;
import ru.otus.messageManager.MessageManager;

@Service
public class FinalResultsImpl implements FinalResults{
    @Autowired
    private MessageManager messageManager;

    public void printResults(Student student, Result result, String wordEnding) {
        System.out.println("_____________________________________________________________________");
        System.out.println(messageManager.getMessage("service_runner.results"));
        System.out.println(messageManager.getMessage("service_runner.results_detail_info", new String[] {student.getName(), student.getSurname(), String.valueOf(result.getCorrectAnswers()), wordEnding, String.valueOf(result.getAllQuestions())}));

    }
}
