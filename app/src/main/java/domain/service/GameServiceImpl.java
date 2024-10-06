package domain.service;

import domain.model.Game;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class GameServiceImpl implements GameService  {

    private int score=0;
    private final Integer aiPlayer = -1;
    private final Integer huPlayer = 1; //human player plays with crosses
    private final int[][] winCombos = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {6, 4, 2}
    };


    ArrayList<Integer> getEmptySpots(Game game){
        ArrayList<Integer> l = new ArrayList<>();
        for (int i = 0; i < game.getFieldSize(); i++) {
            if(game.getSpotValue(i)==0){
                l.add(i);
            }
        }
        return l;
    }
    

    public Map<Integer,Integer> checkWin(Game game,Integer player){
        ArrayList<Integer> playersCombos = new ArrayList<>();
        for (int i = 0; i < game.getFieldSize();i++) {
            if(game.getSpotValue(i)==player){
                playersCombos.add(i);
            }
        }
        for(int i =0;i<winCombos.length;++i){
            int cnt=0;
            for (int spot: winCombos[i]){
                if (playersCombos.contains(spot)){
                    cnt++;
                }
            }
            if(cnt==3) return Map.of(i,player);
        }
        return null;
    }

    @Override
    public int getNextStepFor(Game game) {
        ArrayList<Integer> availSpots = getEmptySpots(game);
//        if (checkWin(game, huPlayer)!=null) {
//            // отнимаем от результата 10 очков
//            score -=10;
//            // если выиграет компьютер
//        } else if (checkWin(game, aiPlayer)!=null) {
//            // прибавляем 10 очков
//            score+=10;
//            // если ничья, то не менеяем очки
//        }
////        else if (availSpots.isEmpty()) {
//        }
        Random random = new Random();
        int s;
        do {
            s = random.nextInt(9);
        } while(!availSpots.contains(s));
        return s;
    }

    @Override
    public boolean isFieldValidFor(Game game) {
        return true;
    }

    @Override
    public int isGameOver(Game game) {
        if (checkWin(game,huPlayer)!=null){
            return 1;
        } else if(checkWin(game,aiPlayer)!=null){
            return -1;
        } else if(getEmptySpots(game).isEmpty()){
            return 0;
        }
        return 2;//game is not over
    }

}
