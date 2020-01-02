/**
 *
 *The Sudoku Class
 * @author Houssam
 */

public class Sudoku {

    /**
     * this method will check if the Soduku Grid is correct
     * @param grid a matrix of integer represent the Soduku table
     * @return true if it's correct, false if it's not
     */

    public static boolean checkSudoku(int[][] grid) {

        int arr[]=new int[10];
        int m=1;

        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                if(arr[grid[i][j]-1]==m) {
                    System.out.println(arr[grid[i][j]-1]+" "+grid[i][j]+" "+i+" "+j);
                    return false;
                }
                else arr[grid[i][j]-1]++;
            }
            m++;
        }


        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                if(arr[grid[j][i]-1]==m) {
                    System.out.println(arr[grid[j][i]-1]+" "+grid[j][i]+" "+j+" "+i);
                    return false;
                }
                else arr[grid[j][i]-1]++;
            }
            m++;
        }


        for(int i=0;i<9;i++) {
            for(int j=0+(i%3)*3;j<3+(i%3)*3;j++) {
                for(int k=0+(i/3)*3;k<3+(i/3)*3;k++) {
                    if(arr[grid[j][k]-1]==m) {
                        System.out.println(arr[grid[j][k]-1]+" "+grid[j][k]+" "+j+" "+k);
                        return false;
                    }
                    else arr[grid[j][k]-1]++;
                }
            }
            m++;
        }

        return true;
    }

    /**
     * The main method
     * @param args
     */

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[][]=new int[9][9];

        a[0][0]=5;a[0][1]=6;a[0][2]=1;a[0][3]=8;a[0][4]=4;a[0][5]=7;a[0][6]=9;a[0][7]=2;a[0][8]=3;

        a[1][0]=3;a[1][1]=7;a[1][2]=9;a[1][3]=5;a[1][4]=2;a[1][5]=1;a[1][6]=6;a[1][7]=8;a[1][8]=4;

        a[2][0]=4;a[2][1]=2;a[2][2]=8;a[2][3]=9;a[2][4]=6;a[2][5]=3;a[2][6]=1;a[2][7]=7;a[2][8]=5;

        a[3][0]=6;a[3][1]=1;a[3][2]=3;a[3][3]=7;a[3][4]=8;a[3][5]=9;a[3][6]=5;a[3][7]=4;a[3][8]=2;

        a[4][0]=7;a[4][1]=9;a[4][2]=4;a[4][3]=6;a[4][4]=5;a[4][5]=2;a[4][6]=3;a[4][7]=1;a[4][8]=8;

        a[5][0]=8;a[5][1]=5;a[5][2]=2;a[5][3]=1;a[5][4]=3;a[5][5]=4;a[5][6]=7;a[5][7]=9;a[5][8]=6;

        a[6][0]=9;a[6][1]=3;a[6][2]=5;a[6][3]=4;a[6][4]=7;a[6][5]=8;a[6][6]=2;a[6][7]=6;a[6][8]=1;

        a[7][0]=1;a[7][1]=4;a[7][2]=6;a[7][3]=2;a[7][4]=9;a[7][5]=5;a[7][6]=8;a[7][7]=3;a[7][8]=7;

        a[8][0]=2;a[8][1]=8;a[8][2]=7;a[8][3]=3;a[8][4]=1;a[8][5]=6;a[8][6]=4;a[8][7]=5;a[8][8]=9;


        System.out.println(checkSudoku(a));


    }

}
