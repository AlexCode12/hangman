import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class hangman {
    public static void main(String[] args) {
        Scanner inputFile;
        Scanner in = new Scanner(System.in);
        {
            try {
                inputFile = new Scanner(new File("test1.txt"));
            } catch (FileNotFoundException e) {
                System.out.println("Filen finns inte, använd tangentbordet istället...");
                inputFile = new Scanner(System.in);
            }
        }
        ArrayList<String> test1 = new ArrayList<>();
        while (inputFile.hasNextLine()) {
            test1.add(inputFile.nextLine());
        }
        System.out.println(test1);
        Math.random();
        Random R = new Random();
        int rnd = R.nextInt(test1.size());
        String word = test1.get(rnd);
        System.out.println(word);
        System.out.println(test1.get(rnd).length());
        int count = 0;
        int lives = 10;
        String resultat = "";

        for (int b = 0; b < word.length(); b++) {
            resultat += '_';
        }

        ArrayList<Character> lista = new ArrayList<>();

        while (lives>0) {
            System.out.println("What is your guess?" + "\n");
            String guess = in.nextLine();

            if (guess.equals(word)) {
                System.out.println("Congratulations, you won the game!");
                System.exit(0);
            }

            char a = guess.charAt(0);
            if (lista.contains(a)) {
                System.out.println("You have already used this character." + "\n");
            }

            else {
                lista.add(a);
                boolean found = false;

                for (int b = 0; b < word.length(); b++) {
                    if (a == word.charAt(b)) {
                        resultat = resultat.substring(0, b) + a + resultat.substring(b + 1);
                        found = true;
                    }
                }

                if (!found) {
                    lives--;
                }

                if (resultat.equals(word)) {
                    System.out.println("Congratulations, you won the game!");
                    System.exit(0);
                }

                count++;
                System.out.println("You have figured out:" + "\n" + resultat + "\n" + "on " + count + " guess/guesses.");
                System.out.println("You have " + lives + " lives left." + "\n");
            }
        }
        System.out.println("Game over. You lost");
    }
}