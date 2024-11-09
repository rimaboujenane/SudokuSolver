public class IntegerBoard implements GameBoard<Integer> {
    private Integer[][] grid;
    private int size;      // Total size of the board (e.g., 9 for 9x9, 16 for 16x16)
    private int subgridSize; // Size of the smaller subgrid (e.g., 3 for 9x9, 4 for 16x16)

    // Constructor
    public IntegerBoard(Integer[][] initialGrid) {
        size = initialGrid.length;
        // Check if size is a perfect square
        double sqrt = Math.sqrt(size);
        if ((sqrt - Math.floor(sqrt)) != 0) {
            throw new IllegalArgumentException("Invalid grid dimensions: size must be a perfect square");
        }
        subgridSize = (int) sqrt;
        grid = new Integer[size][size];
        for (int i = 0; i < size; i++) {
            if (initialGrid[i].length != size) {
                throw new IllegalArgumentException("Invalid grid dimensions: size must be " + size + "x" + size);
            }
            System.arraycopy(initialGrid[i], 0, grid[i], 0, size);
        }
    }

    @Override
    public Integer getCell(int x, int y) {
        if (x >= 0 && x < size && y >= 0 && y < size) {
            return grid[x][y];
        } else {
            throw new IndexOutOfBoundsException("Cell position out of bounds");
        }
    }

    @Override
    public void setCell(int x, int y, Integer value) {
        if (x >= 0 && x < size && y >= 0 && y < size) {
            grid[x][y] = value;
        } else {
            throw new IndexOutOfBoundsException("Cell position out of bounds");
        }
    }

    @Override
    public int getWidth() {
        return size;
    }

    @Override
    public int getHeight() {
        return size;
    }

    @Override
    public void display() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public IntegerBoard clone() {
        Integer[][] clonedGrid = new Integer[size][size];
        for (int i = 0; i < size; i++) {
            System.arraycopy(grid[i], 0, clonedGrid[i], 0, size);
        }
        return new IntegerBoard(clonedGrid);
    }

    public boolean isFilled() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
