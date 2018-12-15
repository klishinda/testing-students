package ru.otus.model;

public class Result {
    private int correctAnswers;
    private int allQuestions;

    public Result (int correctAnswers, int allQuestions) {
        this.correctAnswers = correctAnswers;
        this.allQuestions = allQuestions;
    }

    public int getCorrectAnswers() { return correctAnswers;}

    public int getAllQuestions() {return allQuestions;}

    public String getWordEnding () {
        if (this.correctAnswers >= 11 && this.correctAnswers <= 19) {
            return "ов";
        }
        else {
            int mod = this.correctAnswers % 10;

            if (mod == 2 || mod == 3 || mod == 4) {
                return "а";
            }
            else if (mod == 1) {
                return "";
            }
            else {
                return "ов";
            }
        }
    }

    // Pseudo function was created just for tests
    public String setCorrectAnswers(int newCorrectAnswers) {
        this.correctAnswers = newCorrectAnswers;
        return getWordEnding ();
    }
}
