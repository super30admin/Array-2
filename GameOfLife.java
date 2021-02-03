package S30.Arrays2;

/*Successfully ran on leetcode
* Time complexity: we are traversing whole matrix so O(n*m)
* Space complexity: Not using any extra space so O(1)
*
* Approach: performing matrix operations within the give matrix by replacing
*           2 when a cell alive --> dead
*           3 when a call dead --> lives
*
*           After processing whole matrix, 2 and 3 are replaced by 0 and 1 respectively.
* */

public class GameOfLife {
    public static void main(String args[]){
        int[][] a = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(a);
    }

    public static void gameOfLife(int[][] board) {
        int n = board.length; // rows
        int m = board[0].length; // column
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int count = countLiveCells(i,j,n,m,board);
                if(board[i][j] == 1 && (count < 2 || count > 3))
                    board[i][j] = 2;
                else if(board[i][j] == 0 && count == 3)
                    board[i][j] = 3;
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++) {
                if(board[i][j] == 2)
                    board[i][j] = 0;
                else if(board[i][j] ==3)
                    board[i][j] = 1;
                System.out.print(board[i][j]+" ");
            }
            System.out.print("\n");
        }

    }

    public static int countLiveCells(int i, int j, int rows, int columns, int[][] board){
        int[][] directions = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
        int count = 0;
        for(int m=0; m<directions.length; m++){
            int r = i+ directions[m][0];
            int c = j+ directions[m][1];
            if( r>=0 && c >= 0 && r < rows && c < columns && (board[r][c] ==1 || board[r][c] ==2))
                count++;
        }
        return count;
    }
}
