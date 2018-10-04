package GameOfLifeModel;

import java.util.Random;

public class GameOfLifeModel {

    boolean[][] currentGeneration, nextGeneration;

    public GameOfLifeModel(final int gameSize, final boolean randomStartSeed) {
        currentGeneration = new boolean[gameSize][gameSize];
        if (randomStartSeed) {
            randomStartSeed();
        }
    }

    public boolean[][] nextGeneration() {
        nextGeneration = new boolean[currentGeneration.length][currentGeneration.length];

        for (int y = 0; y < currentGeneration.length; y++) {
            for (int x = 0; x < currentGeneration.length; x++) {
                nextGeneration = updateCell(x, y);
            }
        }
        currentGeneration = nextGeneration;
        return nextGeneration;
    }

    private boolean[][] updateCell(final int currX, final int currY) {
        int neighborAmount = countNeighbors(currX, currY);
        boolean cellAlive = currentGeneration[currX][currY];

        if (cellAlive) {
            nextGeneration[currX][currY] = neighborAmount == 2 || neighborAmount == 3;
        } else {
            nextGeneration[currX][currY] = neighborAmount == 3;
        }
        return nextGeneration;
    }

    int countNeighbors(final int currX, final int currY) {
        int neighborAmount = 0;
        {
            for (int x = -1; x < 2; x++) {
                for (int y = -1; y < 2; y++) {
                    if (isWithinBorder(currX + x, currY + y)) {
                        if (!(currX + x == currX && currY + y == currY)) {
                            neighborAmount += currentGeneration[(currX + x)][(currY + y)] ? 1 : 0;
                        }
                    }
                }
            }
        }
        return neighborAmount;
    }

    private boolean isWithinBorder(final int x, final int y) {
        if (x >= 0 && x < currentGeneration.length && y >= 0 && y < currentGeneration.length) {
            return true;
        }
        return false;
    }

    private void randomStartSeed() {
        Random random = new Random();
        for (int y = 0; y < currentGeneration.length; y++) {
            for (int x = 0; x < currentGeneration.length; x++) {
                currentGeneration[x][y] = random.nextBoolean();
            }
        }
    }
}

