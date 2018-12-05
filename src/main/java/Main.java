import model.Result;
import model.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import questionService.QuestionService;
import studentService.StudentService;


public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("/spring-context.xml");
        StudentService studService = context.getBean(StudentService.class);
        Student st = studService.getCurrentStudent();

        QuestionService quizService = context.getBean(QuestionService.class);
        Result res = quizService.startTesting();
        System.out.println("_____________________________________________________________________");
        System.out.println("Итог опроса : ");
        System.out.println("Студент " + st.getName() + " " + st.getSurname() + " ответил правильно на " + res.getCorrectAnswers() + " вопросов(-а) из " + res.getAllQuestions());
    }
}
