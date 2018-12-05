package model;

public class Result {
    private int correctAnswers;
    private int allQuestions;

    public Result (int vCorrectAnswers, int vAllQuestions) {
        this.correctAnswers = vCorrectAnswers;
        this.allQuestions = vAllQuestions;
    }

    public int getCorrectAnswers() { return correctAnswers;}

    public int getAllQuestions() {return allQuestions;}
}
