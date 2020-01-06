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
    public boolean checkSudoku(int[][] grid){


        /*
        this condition will handel the exception if the dimension of the grid is different to 9x9
         */
        if(grid.length!=9 || grid[0].length != 9)
            throw new InvalidSudokuDimension("invalid dimensions");

        /*
        this condition will check the rows, the columns and the subGrid if there is no duplication it will return true
         */
        if(checkRows(grid) && checkColumns(grid)&& checkSubGrid(grid))
            return true;
        else
            return false;
    }


    /**
     * this method checks the rows of the sudoku grid
     * @param grid a matrix of integer represent the Soduku table
     * @return boolean value: true=> if the values is not duplicated in each row | false=> if the values is duplicated
     */
    public boolean checkRows(int[][] grid){
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                    if(grid[i][j]<1 || grid[i][j]>9)
                        throw new OutOfRangeElement(grid[i][j]+" is a wrong value it should be between 1 and 9");
                    if(!checkDuplicate(grid[i][j]-1)){
                        return false;
                    }
            }
            setDuplicationMemory(getDuplicationMemory()+1);
        }
        return true;
    }

    /**
     * this method checks the columns of the sudoku grid
     * @param grid a matrix of integer represent the Soduku table
     * @return boolean value: true=> if the values is not duplicated in each column | false=> if the values is duplicated
     */
    public boolean checkColumns(int[][] grid){
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                if(!checkDuplicate(grid[j][i]-1)){
                    return false;
                }
            }
            setDuplicationMemory(getDuplicationMemory()+1);
        }
        return true;
    }

    /**
     * this method checks the sub grid 3x3 of the sudoku grid
     * @param grid a matrix of integer represent the Soduku table
     * @return boolean value: true=> if the values is not duplicated in each sub grid | false=> if the values is duplicated
     */
    public boolean checkSubGrid(int[][] grid){
        for(int i=0;i<9;i++) {
            for(int j=0+(i%3)*3;j<3+(i%3)*3;j++) {
                for(int k=0+(i/3)*3;k<3+(i/3)*3;k++) {
                    if(indexMemory[grid[j][k]-1]==duplicationMemory) {
                        return false;
                    }
                    else indexMemory[grid[j][k]-1]++;
                }
            }
            duplicationMemory++;
        }
        return true;
    }


    /**
     * this is a helper method of the methods checkRows, checkColumns and checkSubGrid it detect the duplicated values
     * @param gridValue a matrix of integer represent the Soduku table
     * @return boolean value: true=> if the value is not duplicated | false=> if the value is duplicated
     */
    public boolean checkDuplicate(int gridValue){
        if(getIndexMemory()[gridValue]==getDuplicationMemory()) {
            return false;
        }
        else setIndexMemory(gridValue,getIndexMemory()[gridValue]+1);
        return true;
    }


    /**
     * The main method
     * @param args
     */
    public static void main(String[] args) {

        Sudoku sudoku=new Sudoku();

        int d[][]={
                {10,4,7,1,4,7,1,4,7},
                {2,5,8,2,5,8,2,5,8},
                {3,6,9,3,6,9,3,6,9},
                {4,7,1,4,7,1,4,7,1},
                {5,8,2,5,8,2,5,8,2},
                {6,9,3,6,9,3,6,9,3},
                {7,1,4,7,1,4,7,1,4},
                {8,2,5,8,2,5,8,2,5},
                {8,2,5,8,2,5,8,1,5},
        };

        System.out.println(sudoku.checkSudoku(d));


    }

}
