package GameOfLifeController;

import GameOfLifeModel.GameOfLifeModel;
import GameOfLifeView.GameOfLifeViewImpl;
import GameOfLifeView.GameOfLifeView;

public class GameOfLifeController {

    private final GameOfLifeView gameOfLifeView;
    private final GameOfLifeModel gameOfLifeModel;

    public GameOfLifeController(final int size, final int amountOfGenerations) {
        if (size < 1) {
            throw new IllegalArgumentException("Size must be bigger than 1");
        }
        this.gameOfLifeView = new GameOfLifeViewImpl(size);
        this.gameOfLifeModel = new GameOfLifeModel(size, true);
        this.startEvolving(amountOfGenerations);
    }

    public void startEvolving(final int amountOfGenerations) {
        for (int i = 0; i < amountOfGenerations; i++) {
            gameOfLifeView.drawGeneration(gameOfLifeModel.nextGeneration());
        }
    }
}
