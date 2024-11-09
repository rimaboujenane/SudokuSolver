/**
 * Sudoku application (Main class)
 *
 * @author      Morteza Mahdiani (for TP1-IFT2015-A24)
 * @author      modified by Francois Major, on 24.10.25)
 *              
 * @version     1.1 (25 october 2024)
 * @since       1.0 (22 October 2024)
 */

public class SudokuApp {

    public void testCase1() {
	System.out.println( "*** Test Case 1 ***" );
        Integer[][] puzzle = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        GameBoard<Integer> board = new IntegerBoard( puzzle );
        GameSolver solver = new SudokuSolver( board );
	solver.solve();
	solver.printSolution();
    }

    public void testCase2() {
	System.out.println( "*** Test Case 2 ***" );
        Integer[][] puzzle = {
            {0, 0, 0, 0, 0, 0, 0, 1, 0},
            {4, 0, 3, 0, 0, 5, 0, 0, 0},
            {0, 0, 0, 0, 3, 0, 0, 6, 0},
            {0, 5, 0, 4, 6, 0, 0, 0, 0},
            {0, 0, 0, 3, 0, 8, 0, 0, 0},
            {0, 0, 0, 0, 9, 7, 0, 8, 0},
            {0, 6, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 5, 0, 0, 2, 0, 9},
            {0, 8, 0, 0, 0, 0, 0, 0, 0}
        };
        GameBoard<Integer> board = new IntegerBoard( puzzle );
        GameSolver solver = new SudokuSolver( board );
	solver.solve();
	solver.printSolution();
    }

    public void testCase3() {
	System.out.println( "*** Test Case 3 ***" );
	Integer[][] puzzle = {
	    {5, 1, 6, 8, 4, 9, 7, 3, 2},
	    {3, 0, 7, 6, 0, 5, 0, 0, 0},
	    {8, 0, 9, 7, 0, 0, 0, 6, 5},
	    {1, 3, 5, 0, 6, 0, 9, 0, 7},
	    {4, 7, 2, 5, 9, 1, 0, 0, 6},
	    {9, 6, 8, 3, 7, 0, 0, 5, 0},
	    {2, 5, 3, 1, 8, 6, 0, 7, 4},
	    {6, 8, 4, 2, 0, 7, 5, 0, 0},
	    {7, 9, 1, 0, 5, 0, 6, 0, 0}
	};
        GameBoard<Integer> board = new IntegerBoard( puzzle );
        GameSolver solver = new SudokuSolver( board );
	solver.solve();
	solver.printSolution();
    }

    public void testCase4() {
	System.out.println( "*** Test Case 4 ***" );
        Integer[][] puzzle = {
            {0, 0, 0, 0, 0, 0, 0, 0, 2},
            {0, 0, 0, 0, 0, 0, 6, 0, 0},
            {0, 0, 0, 5, 0, 9, 0, 0, 0},
            {6, 0, 0, 0, 4, 0, 0, 0, 0},
            {0, 7, 0, 0, 0, 0, 0, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 3, 0},
            {9, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 7, 0, 0, 0, 0},
            {0, 0, 8, 0, 0, 0, 0, 0, 0}
        };
        GameBoard board = new IntegerBoard( puzzle );
        GameSolver solver = new SudokuSolver( board );
	solver.solve();
	solver.printSolution();
    }

    public void testCase5() {
	System.out.println( "*** Test Case 5 ***:" );
        Integer[][] puzzle = {
            {1, 2, 3, 4},
            {3, 4, 0, 0},
            {0, 0, 0, 0},
            {4, 3, 2, 1}
        };
        GameBoard board = new IntegerBoard( puzzle );
        GameSolver solver = new SudokuSolver( board );
	solver.solve();
	solver.printSolution();
    }

    // Solvable puzzle with minimal clues
    public void testCase6() {
        System.out.println("*** Test Case 6: Minimal Clues ***");
        Integer[][] puzzle = {
                {0, 0, 0, 0, 0, 0, 0, 1, 2},
                {0, 0, 0, 0, 0, 0, 3, 0, 0},
                {0, 0, 4, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 5, 0, 0, 0, 0, 0},
                {6, 0, 0, 0, 7, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 8, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 9},
                {0, 0, 5, 0, 0, 0, 0, 0, 0},
                {3, 4, 0, 0, 0, 0, 0, 0, 0}
        };
        GameBoard board = new IntegerBoard( puzzle );
        GameSolver solver = new SudokuSolver( board );
        solver.solve();
        solver.printSolution();
    }

    // Invalid puzzle with duplicate in a row
    public void testCase7() {
        System.out.println("*** Test Case 7: Invalid Puzzle with Duplicate in Row ***");
        Integer[][] puzzle = {
                {5, 3, 0, 0, 7, 0, 0, 0, 5}, // Invalid: duplicate '5' in row
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        GameBoard board = new IntegerBoard( puzzle );
        GameSolver solver = new SudokuSolver( board );
        solver.solve();
        solver.printSolution();
    }

    // Invalid puzzle with duplicate in a column
    public void testCase8() {
        System.out.println("*** Test Case 8: Invalid Puzzle with Duplicate in Column ***");
        Integer[][] puzzle = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {5, 0, 0, 0, 8, 0, 0, 7, 9}  // Invalid: duplicate '5' in column
        };
        GameBoard<Integer> board = new IntegerBoard(puzzle);
        GameSolver solver = new SudokuSolver(board);
        solver.solve();
        solver.printSolution();
    }

    // Invalid puzzle with duplicate in a subgrid
    public void testCase9() {
        System.out.println("*** Test Case 9: Invalid Puzzle with Duplicate in Subgrid ***");
        Integer[][] puzzle = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 5, 6, 0, 0, 0, 3}, // Invalid: duplicate '5' in subgrid
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        GameBoard<Integer> board = new IntegerBoard(puzzle);
        GameSolver solver = new SudokuSolver(board);
        solver.solve();
        solver.printSolution();
    }

    // Non-standard size 4x4 puzzle
    public void testCase10() {
        System.out.println("*** Test Case 10: 4x4 Puzzle ***");
        Integer[][] puzzle = {
                {1, 0, 3, 0},
                {0, 2, 0, 4},
                {3, 0, 4, 0},
                {0, 1, 0, 2}
        };
        GameBoard<Integer> board = new IntegerBoard(puzzle);
        GameSolver solver = new SudokuSolver(board);
        solver.solve();
        solver.printSolution();
    }

    // Invalid size puzzle (5x5), should trigger an error
    public void testCase11() {
        System.out.println("*** Test Case 11: Invalid Size (5x5 Puzzle) ***");
        Integer[][] puzzle = {
                {1, 2, 3, 4, 5},
                {5, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {4, 0, 0, 0, 0},
                {0, 0, 0, 0, 1}
        };
        try {
            GameBoard<Integer> board = new IntegerBoard(puzzle);
            GameSolver solver = new SudokuSolver(board);
            solver.solve();
            solver.printSolution();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public void testCase12() {
        System.out.println( "*** Test Case 12 ***" );
        Integer[][] puzzle = {
                {9, 0, 0, 0, 0, 8, 0, 0, 1},
                {6, 0, 0, 4, 1, 0, 0, 2, 0},
                {0, 0, 1, 0, 9, 0, 3, 0, 6},
                {0, 0, 0, 0, 0, 3, 0, 0, 0},
                {4, 2, 9, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 5, 0, 0, 0, 8},
                {0, 3, 0, 0, 0, 9, 1, 0, 0},
                {0, 0, 0, 0, 8, 7, 0, 5, 0},
                {0, 0, 7, 0, 0, 6, 0, 0, 0}
        };
        GameBoard board = new IntegerBoard( puzzle );
        GameSolver solver = new SudokuSolver( board );
        solver.solve();
        solver.printSolution();
    }



    public static void main( String[] args ) {
        SudokuApp test = new SudokuApp();
        test.testCase1();
        test.testCase2();
        test.testCase3();
        test.testCase4();
	    test.testCase5();
        test.testCase6();
        test.testCase7();
        test.testCase8();
        test.testCase9();
        test.testCase10();
        test.testCase11();
        test.testCase12();

    }
}
