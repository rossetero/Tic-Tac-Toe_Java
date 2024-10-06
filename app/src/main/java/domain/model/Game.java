package domain.model;

import java.util.ArrayList;
import java.util.UUID;

public class Game {
    private GameField field;
    private final UUID uuid;

    Game() {
        uuid = UUID.randomUUID();
        field = new GameField();
    }

    public int getFieldSize(){
        return field.data.size();
    }

    public void set(int row, int column, int value) {
        field.set(row, column, value);
    }

    public void set(int n, int value) {
        if(field.data.get(n)!=0)
            throw new RuntimeException("Illegal move");
        field.data.set(n, value);
    }

    public int getSpotValue(int n) {
        return field.data.get(n);
    }

    public ArrayList<Integer> getField(){
        return field.data;
    }


    public UUID getUUID() {
        return uuid;
    }

    @Override
    public String toString(){
        return field.toString();
    }
}
