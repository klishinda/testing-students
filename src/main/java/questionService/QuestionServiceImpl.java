package questionService;

import dao.CsvReader;
import model.Result;

public class QuestionServiceImpl implements QuestionService{
    private CsvReader reader;

    public QuestionServiceImpl(CsvReader reader) {this.reader = reader;}

    public Result startTesting() {
        return reader.start();
    }
}
