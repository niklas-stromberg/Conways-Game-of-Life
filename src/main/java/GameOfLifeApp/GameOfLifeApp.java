package GameOfLifeApp;

import GameOfLifeController.GameOfLifeController;

public class GameOfLifeApp {

    public GameOfLifeApp() {

    }

    public static void main(String[] args) {
        new GameOfLifeController(500, 10000);
    }
}
