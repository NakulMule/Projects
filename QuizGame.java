import java.util.ArrayList;
import java.util.Scanner;

class Question {
    String questionText;
    String[] options;
    char correctAnswer;

    public Question(String questionText, String[] options, char correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public boolean isCorrect(char answer) {
        return Character.toUpperCase(answer) == correctAnswer;
    }

    public void displayQuestion() {
        System.out.println(questionText);
        for (int i = 0; i < options.length; i++) {
            System.out.println((char)('A' + i) + ": " + options[i]);
        }
    }
}

public class QuizGame {
    private ArrayList<Question> questions;
    private int score;
    private Scanner scanner;

    public QuizGame() {
        questions = new ArrayList<>();
        score = 0;
        scanner = new Scanner(System.in);
        loadQuestions();
    }

    private void loadQuestions() {
        questions.add(new Question("What is the capital of France?", new String[]{"Berlin", "London", "Paris", "Rome"}, 'C'));
        questions.add(new Question("Who developed Java?", new String[]{"Microsoft", "Sun Microsystems", "Google", "Apple"}, 'B'));
        questions.add(new Question("Which planet is known as the Red Planet?", new String[]{"Earth", "Mars", "Jupiter", "Saturn"}, 'B'));
        questions.add(new Question("How many continents are there?", new String[]{"5", "6", "7", "8"}, 'C'));
        questions.add(new Question("What is the largest ocean on Earth?", new String[]{"Atlantic", "Indian", "Arctic", "Pacific"}, 'D'));
    }

    public void startQuiz() {
        System.out.println("Welcome to the Quiz Game!");
        System.out.println("Try your best to answer each question correctly. Good luck!\n");

        for (Question question : questions) {
            question.displayQuestion();
            System.out.print("Your answer (A/B/C/D): ");
            char answer = scanner.nextLine().trim().charAt(0);

            if (question.isCorrect(answer)) {
                System.out.println("Correct! Well done.");
                score++;
            } else {
                System.out.println("Oops! That's not quite right.");
            }
            System.out.println();  // Extra space for readability
        }

        displayScore();
    }

    private void displayScore() {
        System.out.println("Quiz Over!");
        System.out.println("Your final score: " + score + "/" + questions.size());
        System.out.println("Thank you for playing!");
        if (score == questions.size()) {
            System.out.println("Amazing! You got everything correct!");
        } else if (score >= questions.size() / 2) {
            System.out.println("Great job! Keep practicing to improve.");
        } else {
            System.out.println("Don’t worry, you’ll get better with practice!");
        }
    }

    public static void main(String[] args) {
        QuizGame quizGame = new QuizGame();
        quizGame.startQuiz();
    }
}