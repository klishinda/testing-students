package model;

public class Questionnaire {
    private String question;

    private String answer;

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public Questionnaire(String vQuestion, String vAnswer) {
        this.question = vQuestion;
        this.answer = vAnswer;
    }
}
