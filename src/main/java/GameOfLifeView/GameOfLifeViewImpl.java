package GameOfLifeView;

import edu.princeton.cs.introcs.StdDraw;

public class GameOfLifeViewImpl implements GameOfLifeView {

    private final int size;

    public GameOfLifeViewImpl(final int size) {
        this.size = size;
        initCanvas();
    }

    private void initCanvas() {
        StdDraw.setCanvasSize(size, size);
        StdDraw.setXscale(0, size);
        StdDraw.setYscale(0, size);
        StdDraw.setPenColor(StdDraw.BOOK_BLUE);
        StdDraw.setPenRadius(0);
    }

    @Override
    public void drawGeneration(final boolean[][] generation) {
        StdDraw.show(0);
        StdDraw.clear();
        drawEachCell(generation);
    }

    private void drawEachCell(final boolean[][] generation) {
        for (int y = 0; y < generation.length; y++) {
            for (int x = 0; x < generation.length; x++) {
                if (generation[x][y]) {
                    StdDraw.point(x, y);
                }
            }
        }
    }

    @Override
    public int getSize() {
        return this.size;
    }

}
