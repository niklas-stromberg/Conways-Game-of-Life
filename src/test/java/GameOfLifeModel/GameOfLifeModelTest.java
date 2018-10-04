package GameOfLifeModel;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameOfLifeModelTest {

    @Test //Any live cell with fewer than two live neighbors dies, as if by under population.
    public void cellAlive_fewerThanTwoLiveNeighborsDies_oneNeighbor() {
        GameOfLifeModel gameOfLifeModel = new GameOfLifeModel(3, false);
        gameOfLifeModel.currentGeneration[0][0] = true;
        gameOfLifeModel.currentGeneration[2][2] = true;
        gameOfLifeModel.nextGeneration();

        assertEquals(gameOfLifeModel.currentGeneration[1][1], false);
    }

    @Test //Any live cell with fewer than two live neighbors dies, as if by under population.
    public void cellAlive_fewerThanTwoLiveNeighborsDies_zeroNeighbor() {
        GameOfLifeModel gameOfLifeModel = new GameOfLifeModel(3, false);
        gameOfLifeModel.currentGeneration[2][2] = true;
        gameOfLifeModel.nextGeneration();

        assertEquals(gameOfLifeModel.currentGeneration[1][1], false);
    }

    @Test //Any live cell with two or three live neighbors lives on to the next generation.
    public void cellAlive_twoOrThreeLiveNeighborsLivesOn_twoNeighbors() {
        GameOfLifeModel gameOfLifeModel = new GameOfLifeModel(3, false);
        gameOfLifeModel.currentGeneration[0][0] = true;
        gameOfLifeModel.currentGeneration[1][1] = true;
        gameOfLifeModel.currentGeneration[2][1] = true;
        gameOfLifeModel.nextGeneration();

        assertEquals(gameOfLifeModel.currentGeneration[1][1], true);
    }

    @Test //Any live cell with two or three live neighbors lives on to the next generation.
    public void cellAlive_twoOrThreeLiveNeighborsLivesOn_threeNeighbors() {
        GameOfLifeModel gameOfLifeModel = new GameOfLifeModel(3, false);
        gameOfLifeModel.currentGeneration[0][0] = true;
        gameOfLifeModel.currentGeneration[1][1] = true;
        gameOfLifeModel.currentGeneration[1][2] = true;
        gameOfLifeModel.currentGeneration[2][1] = true;
        gameOfLifeModel.nextGeneration();

        assertEquals(gameOfLifeModel.currentGeneration[1][1], true);
    }

    @Test //Any live cell with more than three live neighbors dies, as if by overpopulation.
    public void cellAlive_moreThanThreeLiveNeighborsDies_fourNeighbors() {
        GameOfLifeModel gameOfLifeModel = new GameOfLifeModel(3, false);
        gameOfLifeModel.currentGeneration[0][0] = true;
        gameOfLifeModel.currentGeneration[0][1] = true;
        gameOfLifeModel.currentGeneration[1][1] = true;
        gameOfLifeModel.currentGeneration[1][2] = true;
        gameOfLifeModel.currentGeneration[2][1] = true;
        gameOfLifeModel.nextGeneration();

        assertEquals(gameOfLifeModel.currentGeneration[1][1], false);
    }

    @Test //Any live cell with more than three live neighbors dies, as if by overpopulation.
    public void cellAlive_moreThanThreeLiveNeighborsDies_sevenNeighbors() {
        GameOfLifeModel gameOfLifeModel = new GameOfLifeModel(3, false);
        gameOfLifeModel.currentGeneration[0][0] = true;
        gameOfLifeModel.currentGeneration[0][1] = true;
        gameOfLifeModel.currentGeneration[0][2] = true;
        gameOfLifeModel.currentGeneration[1][0] = true;
        gameOfLifeModel.currentGeneration[1][1] = true;
        gameOfLifeModel.currentGeneration[1][2] = true;
        gameOfLifeModel.currentGeneration[2][0] = true;
        gameOfLifeModel.currentGeneration[2][1] = true;
        gameOfLifeModel.nextGeneration();

        assertEquals(gameOfLifeModel.currentGeneration[1][1], false);
    }

    @Test //Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
    public void cellDead_exactlyThreeLiveNeighborsBecomesAlive() {
        GameOfLifeModel gameOfLifeModel = new GameOfLifeModel(3, false);
        gameOfLifeModel.currentGeneration[1][1] = false;
        gameOfLifeModel.currentGeneration[1][2] = true;
        gameOfLifeModel.currentGeneration[2][0] = true;
        gameOfLifeModel.currentGeneration[2][1] = true;
        gameOfLifeModel.nextGeneration();

        assertEquals(gameOfLifeModel.currentGeneration[1][1], true);
    }

    @Test
    public void countNeighbors_zeroNeighbors()
    {
        GameOfLifeModel gameOfLifeModel = new GameOfLifeModel(3, false);
        assertEquals(gameOfLifeModel.countNeighbors(0,0), 0);
    }

    @Test
    public void countNeighbors_threeNeighbors()
    {
        GameOfLifeModel gameOfLifeModel = new GameOfLifeModel(3, false);
        gameOfLifeModel.currentGeneration[0][1] = true;
        gameOfLifeModel.currentGeneration[1][1] = true;
        gameOfLifeModel.currentGeneration[1][0] = true;

        assertEquals(gameOfLifeModel.countNeighbors(0,0), 3);
    }

    @Test
    public void countNeighbors_eightNeighbors()
    {
        GameOfLifeModel gameOfLifeModel = new GameOfLifeModel(4, false);
        gameOfLifeModel.currentGeneration[0][0] = true;
        gameOfLifeModel.currentGeneration[0][1] = true;
        gameOfLifeModel.currentGeneration[0][2] = true;
        gameOfLifeModel.currentGeneration[1][0] = true;
        gameOfLifeModel.currentGeneration[1][1] = true;
        gameOfLifeModel.currentGeneration[1][2] = true;
        gameOfLifeModel.currentGeneration[2][0] = true;
        gameOfLifeModel.currentGeneration[2][1] = true;
        gameOfLifeModel.currentGeneration[2][2] = true;
        gameOfLifeModel.currentGeneration[3][0] = true;
        gameOfLifeModel.currentGeneration[3][1] = true;
        gameOfLifeModel.currentGeneration[3][2] = true;

        assertEquals(gameOfLifeModel.countNeighbors(1,1), 8);
    }
}