public class IntegerBoard implements GameBoard<Integer> {

    private Integer[][] grid;
    private int size;      
    private int subgridSize; 



    public IntegerBoard(Integer[][] initialGrid) {
        size = initialGrid.length;
        
        // Check if size is a perfect square
        double sqrt = Math.sqrt(size);
        if ((sqrt - Math.floor(sqrt)) != 0) {
            throw new IllegalArgumentException("Grid size not valid, it must be a perfect square.");
        }
        subgridSize = (int) sqrt;
        grid = new Integer[size][size];
        for (int i = 0; i < size; i++) {
            if (initialGrid[i].length != size) {
                throw new IllegalArgumentException("Grid dimensions are invalid, the size should be " + size + "x" + size);
            }
            System.arraycopy(initialGrid[i], 0, grid[i], 0, size);
        }
    }

    @Override
    public Integer getCell(int x, int y) {
        // Make sure x and y are in the board limits
        if (x >= 0 && x < size && y >= 0 && y < size) {
            return grid[x][y];
        } else {
            throw new IndexOutOfBoundsException("You are trying to access a cell that doesn't exist");
        }
    }

    @Override
    public void setCell(int x, int y, Integer value) {
        // Make sure x and y are in the board limits
        if (x >= 0 && x < size && y >= 0 && y < size) {
            grid[x][y] = value;
        } else {
            throw new IndexOutOfBoundsException("You're trying to access a cell that doesn't exist");
        }}

    @Override
    public int getWidth() {
        return size;}

    @Override
    public int getHeight() {
        return size; }

    @Override
    // Print out the grid row by row
    public void display() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
}


    public IntegerBoard clone() {
        // Create a copy of the board, so the original stays safe
        Integer[][] clonedGrid = new Integer[size][size];
        for (int i = 0; i < size; i++) {
            System.arraycopy(grid[i], 0, clonedGrid[i], 0, size);
        }
        return new IntegerBoard(clonedGrid);
        }

    public boolean isFilled() {
        // Check if there are any empty cells (cells with 0)
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                // If any cell is empty, the board is not filled
                if (grid[i][j] == 0) { 
                    return false;
                }
            }
        }
        return true; // Board is all filled.
    }
}
