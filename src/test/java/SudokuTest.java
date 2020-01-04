import org.junit.Test;

import static org.junit.Assert.*;

public class SudokuTest {

    int a[][]={
            {5,6,1,8,4,7,9,2,3},
            {3,7,9,5,2,1,6,8,4},
            {4,2,8,9,6,3,1,7,5},
            {6,1,3,7,8,9,5,4,2},
            {7,9,4,6,5,2,3,1,8},
            {8,5,2,1,3,4,7,9,6},
            {9,3,5,4,7,8,2,6,1},
            {1,4,6,2,9,5,8,3,7},
            {2,8,7,3,1,6,4,5,9}
    };

    int b[][]={
        {1,2,3,4,5,6,7,8,9},
        {2,3,4,5,6,7,8,9,1},
        {3,4,5,6,7,8,9,1,2},
        {4,5,6,7,8,9,1,2,3},
        {5,6,7,8,9,1,2,3,4},
        {6,7,8,9,1,2,3,4,5},
        {7,8,9,1,2,3,4,5,6},
        {8,9,1,2,3,4,5,6,7},
        {9,1,2,3,4,5,6,7,8}
    };

    int c[][]={
            {1,2,3,4,5,6,7,8,9},
            {4,5,6,1,2,3,7,8,9},
            {7,8,9,4,5,6,1,2,3},
            {1,2,3,4,5,6,7,8,9},
            {4,5,6,1,2,3,7,8,9},
            {7,8,9,4,5,6,1,2,3},
            {1,2,3,4,5,6,7,8,9},
            {4,5,6,1,2,3,7,8,9},
            {7,8,9,4,5,6,1,2,3},
    };

    int d[][]={
            {1,4,7,1,4,7,1,4,7},
            {2,5,8,2,5,8,2,5,8},
            {3,6,9,3,6,9,3,6,9},
            {4,7,1,4,7,1,4,7,1},
            {5,8,2,5,8,2,5,8,2},
            {6,9,3,6,9,3,6,9,3},
            {7,1,4,7,1,4,7,1,4},
            {8,2,5,8,2,5,8,2,5},
            {9,3,6,9,3,6,9,3,6},
    };

    Sudoku sd = new Sudoku();

    /**
     * check the case when there is duplication in rows
     */
    @Test
    public void checkSudokuWithDuplicationInRows(){
        assertFalse(sd.checkSudoku(d));
    }

    /**
     * check the case when there is duplication in Columns
     */
    @Test
    public void checkSudokuWithDuplicationInCloumns(){
        assertFalse(sd.checkSudoku(c));
    }

    /**
     * check the case when there is duplication in subGrid
     */
    @Test
    public void checkSudokuWithDuplicationInSubGrid(){
        assertFalse(sd.checkSudoku(b));
    }


    /**
     * check the valid case: no duplication
     */
    @Test
    public void checkSudokuWithoutDuplications() {
        assertTrue(sd.checkSudoku(a));
    }

}