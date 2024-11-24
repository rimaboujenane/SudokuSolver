public class SudokuSolver implements GameSolver {

    private IntegerBoard board;
    private IntegerBoard solution;
    private LinkedGeneralTree<IntegerBoard> stateTree;
    private Position<IntegerBoard> rootPosition;
    private int size;       
    private int subgridSize; 
    private long solveTime;  
   
    public SudokuSolver(GameBoard<Integer> board) {
        if (board instanceof IntegerBoard) {
            this.board = (IntegerBoard) board;
            this.solution = this.board.clone();
            this.size = this.board.getWidth(); // Board is square
            this.subgridSize = (int) Math.sqrt(size); // Size of the smaller subgrid
            this.stateTree = new LinkedGeneralTree<>();
            this.rootPosition = stateTree.addRoot(this.board.clone());
        } 
        else {
            throw new IllegalArgumentException("Board must be an IntegerBoard");
        }}


    // Method to get the time taken to solve the puzzle in milliseconds
    public double getSolveTimeMillis() {
        return solveTime / 1_000_000.0;
    }


    @Override
    public boolean solve() {
        long startTime = System.nanoTime();   
        boolean solved = solveBoard(rootPosition);
        long endTime = System.nanoTime();     
        solveTime = endTime - startTime;   // Calculate time taken to solve
        return solved;
    }


    @Override
    public void printSolution() {
        if (solution.isFilled()) {
            System.out.println("Sudoku puzzle solved:");
            solution.display();
            System.out.println("This sudoku took " + getSolveTimeMillis() + " ms to be solved");
        } 
        else {
            System.out.println("There are no solutions for this sudoku");
        }
    }



    private boolean solveBoard(Position<IntegerBoard> currentPosition) {
        IntegerBoard currentBoard = currentPosition.getElement();
        // Find the next empty cell on the board
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (currentBoard.getCell(row, col) == 0) {  // Check if the cell is empty

                    // Try every possible number in this empty cell
                    for (int num = 1; num <= size; num++) {

                        // Check if num can be placed at this position
                        if (isValidPlacement(currentBoard, row, col, num)) {

                            // Create a new board configuration with 'num' 
                            // placed in the empty cell and add as child in the tree
                            IntegerBoard newBoard = currentBoard.clone();
                            newBoard.setCell(row, col, num);
                            Position<IntegerBoard> newPosition = stateTree.addChild(currentPosition, newBoard);

                            // Recursively try solving with the updated board
                            if (solveBoard(newPosition)) {return true;}  // Puzzle solved
                            
                        }
                    }
                    // No valid number could be placed in this cell, backtrack
                    return false;
                }}
            }
        // If there are no empty cells, the puzzle is solved
        this.solution = currentBoard;
        return true;
}


    // Verifies if a number can be placed at a position while respecting Sudoku rules
    public boolean isValidPlacement(IntegerBoard board, int row, int col, Integer value) {
        // Check row and column
        for (int i = 0; i < size; i++) {
            if (board.getCell(row, i).equals(value) || board.getCell(i, col).equals(value)) {
                return false;
            }   }

        // Check subgrid
        int subRowStart = (row / subgridSize) * subgridSize;
        int subColStart = (col / subgridSize) * subgridSize;

        for ( int r = subRowStart; r < subRowStart + subgridSize; r++ ) {
            for ( int c = subColStart; c < subgridSize + subColStart; c++ ) {
                if ( board.getCell(r, c).equals(value) )
                     { return false; }
                }} return true;
        }
}
