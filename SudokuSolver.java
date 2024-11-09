public class SudokuSolver implements GameSolver {

    private IntegerBoard board;
    private IntegerBoard solution;
    private LinkedGeneralTree<IntegerBoard> stateTree;
    private Position<IntegerBoard> rootPosition;
    private int size;       // Size of the board
    private int subgridSize; // Size of the subgrid
    private long solveTime;  // Variable to store the solution time in nanoseconds

    // Constructor
    public SudokuSolver(GameBoard<Integer> board) {
        if (board instanceof IntegerBoard) {
            this.board = (IntegerBoard) board;
            this.solution = this.board.clone();
            this.size = this.board.getWidth();       // Assume square board
            this.subgridSize = (int) Math.sqrt(size); // Calculate subgrid size

            // Initialize the tree and set the root position with the initial board state
            this.stateTree = new LinkedGeneralTree<>();
            this.rootPosition = stateTree.addRoot(this.board.clone());
        } else {
            throw new IllegalArgumentException("Board must be an IntegerBoard");
        }
    }

    // Method to return the solve time in milliseconds
    public double getSolveTimeMillis() {
        return solveTime / 1_000_000.0;
    }

    @Override
    public boolean solve() {
        long startTime = System.nanoTime();   // Start the timer
        boolean solved = solveBoard(rootPosition);
        long endTime = System.nanoTime();     // End the timer
        solveTime = endTime - startTime;      // Calculate total time in nanoseconds
        return solved;
    }

    @Override
    public void printSolution() {
        if (solution.isFilled()) {
            System.out.println("Puzzle Solved:");
            solution.display();
            System.out.println("Time taken to solve: " + getSolveTimeMillis() + " ms");
        } else {
            System.out.println("No solution exists.");
        }
    }

    // (rest of the SudokuSolver code remains the same)


    private boolean solveBoard(Position<IntegerBoard> currentPosition) {
        IntegerBoard currentBoard = currentPosition.getElement();

        // Find the next empty cell on the board
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (currentBoard.getCell(row, col) == 0) {  // Check if the cell is empty
                    // Try placing each possible number in this empty cell
                    for (int num = 1; num <= size; num++) {
                        // Validate if 'num' can be placed at (row, col) without violating Sudoku rules
                        if (isValidPlacement(currentBoard, row, col, num)) {
                            // Create a new board configuration with 'num' placed in the empty cell
                            IntegerBoard newBoard = currentBoard.clone();
                            newBoard.setCell(row, col, num);

                            // Add this new configuration as a child in the tree
                            Position<IntegerBoard> newPosition = stateTree.addChild(currentPosition, newBoard);

                            // Recursively attempt to solve using this new board configuration
                            if (solveBoard(newPosition)) {
                                return true;  // Puzzle solved
                            }
                            // If solving from this configuration fails, it will return here and try the next number
                        }
                    }
                    // No valid number could be placed in this cell, so we must backtrack
                    return false;
                }
            }
        }

        // If no empty cells remain, we have completed the board successfully
        this.solution = currentBoard;
        return true;
    }


    public boolean isValidPlacement(IntegerBoard board, int row, int col, Integer value) {
        // Check row and column
        for (int i = 0; i < size; i++) {
            if (board.getCell(row, i).equals(value) || board.getCell(i, col).equals(value)) {
                return false;
            }
        }

        // Check subgrid
        int subRowStart = (row / subgridSize) * subgridSize;
        int subColStart = (col / subgridSize) * subgridSize;
        for (int r = subRowStart; r < subRowStart + subgridSize; r++) {
            for (int c = subColStart; c < subgridSize + subColStart; c++) {
                if (board.getCell(r, c).equals(value)) {
                    return false;
                }
            }
        }
        return true;
    }
}
