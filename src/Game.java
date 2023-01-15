import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Game {
    private static String[] getMovies() throws FileNotFoundException {
        File file = new File("movies.txt");
        Scanner scanner = new Scanner(file);
        String[] films = new String[25];
        int x = 0;
        while (scanner.hasNext()) {
            String film = scanner.nextLine();
            films[x] = film;
            x++;
        }
        return films;
    }
    public static String getSecretFilm() throws FileNotFoundException {
        int randomNumber = (int) (Math.random() * 25);
        return getMovies()[randomNumber];
    }
    public static String getClues (String film) throws FileNotFoundException{
        String clues = "";
        for (int i = 0; i < film.length(); i++) {
            if (film.charAt(i) == ' ') {
                clues += " ";
            } else {
                clues += "_";
            }
        }
        return clues;
    }
    public static String getUpdatedClues (String secretFilm, int index, String guess, String oldClues) throws FileNotFoundException {
        String clues = "";
        for (int i = 0; i < oldClues.length(); i++) {
            if (i == index) {
                clues += guess;
            } else if (oldClues.charAt(i) == ' '){
                clues += " ";
            } else if (oldClues.charAt(i) == '_') {
                clues += "_";
            } else {
                clues += oldClues.charAt(i);
            }
        }
        return clues;
    }
    public static int numOfSpacebars (String secretFilm) {
        int num = 0;
        for (int i = 0; i < secretFilm.length(); i++) {
            if (secretFilm.charAt(i) == ' ' ){
                num ++;
            }
        }
        return num;
    }
    public static int [] getIndexes (String secretFilm, String guess) {
        int [] Indexes = new int [secretFilm.length()];
        int j = 0;
        char charGuess = guess.charAt(0);
        for (int i = 0; i < secretFilm.length(); i++) {
            if (secretFilm.charAt(i) == charGuess) {
                Indexes[j] = i + 1;
                j++;
            }
        }
        return Indexes;
    }
}
