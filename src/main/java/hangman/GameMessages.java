package hangman;

import hangman.data.WordToGuess;

import java.util.Set;

public class GameMessages {
    static public void status(WordToGuess word, int missCounter, Set<String> usedLetters){
        System.out.printf("\nCurrent misses: %d%n%s", missCounter, word.getMask());
        System.out.println("\nLetters used: " + usedLetters);
    }
    static public void endGameMessage(String state, WordToGuess word){
        String BORDER = "-".repeat(20);
        System.out.printf("%s\n%s!\nHidden word is %s\n%s",
                BORDER, state, word.getCurrentWord(), BORDER);
    }
}
