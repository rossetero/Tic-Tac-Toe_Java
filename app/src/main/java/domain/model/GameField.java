package domain.model;

//1 - X
//0 - empty
//-1 - O

import java.util.ArrayList;

class GameField {
    ArrayList<Integer> data;

    GameField(){
       data = new ArrayList<>(9);
        for (int i = 0; i < 9; i++) {
            data.add(0);
        }
    }


    public int get(int row, int column) {
        return data.get(row * 3 + column);
    }

    public void set(int row, int column, int value) {
        data.set(row * 3 + column,value);
    }


    public boolean EqMatrix(GameField other){
        return this.data.equals(other.data);
    }

    @Override
    public String toString(){
        StringBuilder s= new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char ch;
                if(get(i,j)==1){
                    ch='X';
                } else if(get(i,j)==-1){
                    ch='O';
                }else{
                    ch='.';
                }
                s.append(ch);
                s.append(' ');
            }
            s.append('\n');
        }
        return s.toString();
    }

}


//class GameField {
//    private int[] matrix;
//
//    GameField(){
//        matrix = new int[9];
//    }
//
//    public int size(){
//        return matrix.length;
//    }
//
//    public int get(int row, int column) {
//        return matrix[row * 3 + column];
//    }
//
//    public void set(int row, int column, int value) {
//        matrix[row * 3 + column] = value;
//    }
//
//    public int get(int n) {
//        return matrix[n];
//    }
//
//    public void set(int n, int value) {
//        matrix[n] = value;
//    }
//
//    public boolean EqMatrix(GameField other){
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                if(this.get(i,j)!= other.get(i,j)){
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    @Override
//    public String toString(){
//        StringBuilder s= new StringBuilder();
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                s.append(get(i,j));
//                s.append(' ');
//            }
//            s.append('\n');
//        }
//        return s.toString();
//    }
//
//}
