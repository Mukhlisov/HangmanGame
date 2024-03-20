package hangman.data;

import hangman.Game;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataContainer {
    private final List<String> storage = new ArrayList<>();
    public DataContainer(String file){
        Path path = FileSystems.getDefault()
                .getPath(System.getProperty("user.dir"), Game.RESUORCE_PATH, file);

        try{
            Scanner scan = new Scanner(path, "UTF-8");
            while (scan.hasNextLine()){
                this.storage.addLast(scan.nextLine());
            }
            scan.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getData(int index){
        return this.storage.get(index);
    }

    public int getSize(){
        return this.storage.size();
    }

    public boolean contains(String letter){
        return this.storage.contains(letter);
    }

}
