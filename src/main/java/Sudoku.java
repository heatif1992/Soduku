/**
 *
 *The Sudoku Class
 * @author Houssam
 */

public class Sudoku {

    /*
    this array will memorize by index the different values in a line or sub grid 3x3. the indexes of the indexMemory
        represent the values of the elements in a line or column or sub grid 3x3 of the grid, and the values of the indexMemory represent
        how many time this value of a line is occurred.
        */
    private int[] indexMemory =new int[9];

    /*
    I add this variable to make this solution more efficient, I don't want to initialize the values of the array indexMemory to zero
        in each Iteration (each verification of a line or column or sub grid 3x3), so I try to increment this variable in each iteration
        and compare the value of it with the values of the array indexMemory, to check if there is duplication
         */
    private int duplicationMemory=1;


    // getter and setter
    public int[] getIndexMemory() {
        return indexMemory;
    }

    public void setIndexMemory(int index, int value) {
        this.indexMemory[index] = value;
    }

    public int getDuplicationMemory() {
        return duplicationMemory;
    }

    public void setDuplicationMemory(int duplicationMemory) {
        this.duplicationMemory = duplicationMemory;
    }


    /**
     * this method will check if the Soduku Grid is correct
     * @param grid a matrix of integer represent the Soduku table
     * @return true if it's correct, false if it's not
     */
    public static boolean checkSudoku(int[][] grid) {

        Sudoku table=new Sudoku();

        /*
        this condition will check the line and the column of the grid by the helper function checkLine, if it's false
        it will return false else it will execute the code that check all the sub grid 3x3 of the sudoku grid
         */
        if(checkLine(table, grid, false) && checkLine(table, grid, true)){
            for(int i=0;i<9;i++) {
                for(int j=0+(i%3)*3;j<3+(i%3)*3;j++) {
                    for(int k=0+(i/3)*3;k<3+(i/3)*3;k++) {
                        if(table.indexMemory[grid[j][k]-1]==table.duplicationMemory) {
                            return false;
                        }
                        else table.indexMemory[grid[j][k]-1]++;
                    }
                }
                table.duplicationMemory++;
            }
        }
        else
            return false;

        return true;
    }

    /**
     * this is a helper method that will check each line and column of the grid
     * @param sudoku object of the Sudoku class
     * @param grid a matrix of integer represent the Soduku table
     * @param isRow a boolean value: true => to check the rows | false => to check the columns
     * @return a boolean value: true => there is no duplicated values in all the row or column | false => there is
     * a duplicated value in a column or a row
     */
    public static boolean checkLine(Sudoku sudoku, int[][] grid, boolean isRow){
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                if(isRow){
                    if(!checkDuplicate(sudoku,grid[i][j]-1)){
                        return false;
                    }
                }
                else{
                    if(!checkDuplicate(sudoku,grid[j][i]-1)){
                        return false;
                    }
                }

            }
            sudoku.setDuplicationMemory(sudoku.getDuplicationMemory()+1);
        }
        return true;
    }

    /**
     * this is a helper method of the checkLine method that detect the duplicated values
     * @param sudoku object of the Sudoku class
     * @param gridValue a matrix of integer represent the Soduku table
     * @return boolean value: true=> if the value is not duplicated | false=> if the value is duplicated
     */
    public static boolean checkDuplicate(Sudoku sudoku, int gridValue){
        if(sudoku.getIndexMemory()[gridValue]==sudoku.getDuplicationMemory()) {
            return false;
        }
        else sudoku.setIndexMemory(gridValue,sudoku.getIndexMemory()[gridValue]+1);
        return true;
    }


    /**
     * The main method
     * @param args
     */
    public static void main(String[] args) {

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

        System.out.println(checkSudoku(d));


    }

}
