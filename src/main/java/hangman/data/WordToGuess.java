package hangman.data;

import java.util.Random;

public class WordToGuess {
    private final String currentWord;
    private final StringBuilder word;
    private final StringBuilder mask;
    private final static String SPACE = "_";
    private static final DataContainer wordList = new DataContainer("words.txt");

    public WordToGuess(){
        Random index = new Random(System.currentTimeMillis());

        this.currentWord = wordList
                .getData(index.nextInt(wordList.getSize())).toLowerCase();
        this.word = new StringBuilder(currentWord);

        this.mask = new StringBuilder(SPACE
                .repeat(this.currentWord.length()));
    }

    public StringBuilder getMask(){
        return this.mask;
    }

    public boolean contains(String letter){
        return this.word.indexOf(letter) > -1;
    }

    public boolean maskContainsSpaces(){
        return this.mask.indexOf(SPACE) > -1;
    }

    public void excludeLetter(String letter){
        int index = this.word.indexOf(letter);

        while (index > -1){
            this.mask.setCharAt(index, this.word.charAt(index));
            this.word.setCharAt(index, '_');
            index = this.word.indexOf(letter);
        }
    }

    public String getCurrentWord(){
        return this.currentWord;
    }

}
