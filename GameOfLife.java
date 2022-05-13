// Time Complexity : O(N) where n is the number of elements
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope


// Your code here along with comments explaining your approach

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int r = board.length;
        int c = board[0].length;
        int[][] answer = new int[r][c];
        
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                int value = check(board, i, j, r, c);
                answer[i][j] = value;
            }
        }
        
        for(int i=0; i<r;i++){
            for(int j=0; j<c; j++){
                board[i][j] = answer[i][j];
            }
        }
    }
    
    public int check(int[][] board, int i, int j, int r, int c){
        int[][] dic = {{0,1},{0,-1},{-1,0}, {-1,1}, {-1,-1}, {1,1}, {1,0}, {1,-1}};
        int count=0;
        for(int[] row:dic){
            if(i+row[0] >=0 && i+row[0] <r && j+row[1] >=0 && j+row[1] < c){
                if(board[i+row[0]][j+row[1]] == 1){
                    count++;
                }
            }
        }
        if(board[i][j] == 1){
            if(count<2){
                return 0;
            }
            else if(count<=3){
                return 1;
            }
            else{
                return 0;
            }
        }
        else{
            if(count==3){
                return 1;
            }
            else{
                return 0;
            }
        }
    }
}
