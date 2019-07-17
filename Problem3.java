// Time Complexity :O(m*n) --> beacuse of for loop
// Space Complexity :1
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1.Check live neighbours and update its value to 2 or -1 if there is a change so that you don't need to use an extra array.
// 2. Update values according to rules for each element.
// 3.Replace 2 and -1 with 1 and 0 for all replaced elemnts

public class GameOfLife {
    public static void gameOfLife(int[][] board) {
        // 0 -> 1 -> 2
        // 1 -> 0 -> -1
        //1. 1 -> (less than 2 1's) -> 0
        //2. 1 -> (2 or 3 1's) -> 1
        //3. 1 -> ( >3 1's) -> 0
        //4. 0 -> (3 1's) -> 1
        int m = board.length;
        int n = board[0].length;
        for(int i = 0;i<m;i++){
            for(int j =0;j<n;j++){
                neighbourcount(board,i,j);
            }
        }
        for(int i = 0;i<m;i++){
            for(int j =0;j<n;j++){
                if(board[i][j] == -1)
                    board[i][j] = 0;
                else if(board[i][j] == 2)
                    board[i][j] = 1;
            }
        }

    }
    public static void neighbourcount(int[][] board,int r,int c){
        int count = 0;
        int m = board.length;
        int n = board[0].length;
        //top
        if(r>0 && (board[r-1][c] == 1 || board[r-1][c] == -1) ) count++;
        //top right
        if (r>0 && c<n-1 && (board[r-1][c+1] == 1 || board[r-1][c+1] == -1)) count++;
        //right
        if(c<n-1 && (board[r][c+1] == 1 || board[r][c+1] == -1)) count++;
        //down right
        if(r<m-1 && c<n-1 && (board[r+1][c+1] == 1 || board[r+1][c+1] == -1)) count++;
        //down
        if(r<m-1 && (board[r+1][c] == 1 || board[r+1][c] == -1)) count++;
        //down left
        if(r<m-1 && c>0 && (board[r+1][c-1] == 1 || board[r+1][c-1] == -1)) count++;
        //left
        if(c>0 && (board[r][c-1] == 1 || board[r][c-1] == -1)) count++;
        //top left
        if(r>0 && c>0 && (board[r-1][c-1] == 1 || board[r-1][c-1] == -1)) count++;

        if(board[r][c] == 0 && count == 3){
            board[r][c] = 2;
            return;
        }
        if(board[r][c] == 1 && (count<2 || count>3) ){
            board[r][c] = -1;
            return;
        }
    }

    public static void main(String[] args) {
        int [][] array = {{0,1,0},{0,0,1}, {1,1,1},{0,0,0}};
        gameOfLife(array);
    }
}
