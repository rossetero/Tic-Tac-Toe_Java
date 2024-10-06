package domain.service;
import domain.model.Game;

public interface GameService {
    int getNextStepFor(Game game);
    boolean isFieldValidFor(Game game);
    int isGameOver(Game game);
}
