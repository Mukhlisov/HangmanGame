package hangman;

import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);


    static void start(){
        boolean gameState = true;
        String answer;
        try {
            while (gameState) {
                System.out.print("\nDo u wanna play a game?\n[Y]es / [N]o: ");
                answer = scan.next();

                if (answer.equalsIgnoreCase("y")) {
                    Game.run();
                }
                else {
                    if (answer.equalsIgnoreCase("n")) {
                        gameState = false;
                        scan.close();
                    }
                }
            }
        } catch (Exception e){
            System.out.print(e.getMessage());
        }
    }
    public static void main(String[] args){
        start();
    }
}