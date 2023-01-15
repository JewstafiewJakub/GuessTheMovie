import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String secretFilm = Game.getSecretFilm();
        Scanner scanner = new Scanner(System.in);
        boolean hasWon = false;
        System.out.println(secretFilm);
        String clues = Game.getClues(secretFilm);
        int numGuessedLetters = 0;
        String alreadyGuessedLetters = "";
        for (int i = 10; i > 0; i--) {
            System.out.println(clues);
            System.out.println("You have " + i + " guesses left");
            String guess = scanner.next();
            int num = 0;
            if (alreadyGuessedLetters.contains(guess)) {
                i++;
                System.out.println("You've already guessed this letter!");
                System.out.println();
            } else {
                if (secretFilm.contains(guess)) {
                    System.out.println("That's right!");
                    System.out.println();
                    for (int j = 0; j <= Game.getIndexes(secretFilm, guess).length; j++) {
                        if (Game.getIndexes(secretFilm, guess)[j] == 0) {
                            break;
                        }
                        int index = Game.getIndexes(secretFilm, guess)[j];
                        clues = Game.getUpdatedClues(secretFilm, index - 1, guess, clues);
                        num++;
                    }

                    i++;
                    numGuessedLetters += num;
                    alreadyGuessedLetters += guess;
                } else {
                    System.out.println("Wrong!");
                    System.out.println();
                    alreadyGuessedLetters += guess;
                }
            }
            if (numGuessedLetters == secretFilm.length() - Game.numOfSpacebars(secretFilm)) {
                hasWon = true;
                break;
            }
        }
        if (hasWon) {
            System.out.println(secretFilm +
                    "\n " +
                    "\nYou win, you've guessed the film title!");
        } else {
            System.out.println("You've run out of guesses. Try again!");
            System.out.println("The name of the film was: ");
        }
    }
}