package hangman;

import hangman.data.DataContainer;
import hangman.data.WordToGuess;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Game {
    static public String RESUORCE_PATH = "\\src\\main\\resources\\";
    static final private int maxMiss = 6;
    static final private DataContainer alphabet = new DataContainer("alphabetRus.txt");

    static public void run(){
        String letter;
        int missCounter = 0;
        WordToGuess word = new WordToGuess();
        Set<String> usedLetters = new HashSet<>();

        while ((missCounter < maxMiss) && (word.maskContainsSpaces())){
            System.out.print("Enter a letter: ");
            letter = Main.scan.next().toLowerCase();

            while (usedLetters.contains(letter) || !alphabet.contains(letter)){
                System.out.println("Only russian letters should be entered!\nOr you entered this letter before: "
                        + usedLetters);
                System.out.print("Enter another letter: ");
                letter = Main.scan.next();
            }

            usedLetters.add(letter);
            if (word.contains(letter)){
                word.excludeLetter(letter);
            }
            else{
                missCounter ++;
                drawHangMan(missCounter);
            }
            GameMessages.status(word, missCounter, usedLetters);
        }
        if (missCounter == 6){
            GameMessages.endGameMessage("Game Over", word);
        } else{
            GameMessages.endGameMessage("Congratulation", word);
        }
    }

    static private void drawHangMan(int missCounter){
        Path path = FileSystems.getDefault()
                .getPath(System.getProperty("user.dir"),
                        RESUORCE_PATH, String.format("models\\hangman%d.txt", missCounter));

        try{
            Scanner scan = new Scanner(path);

            while (scan.hasNextLine()){
                System.out.println(scan.nextLine());
            }
            scan.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}