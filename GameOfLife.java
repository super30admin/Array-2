// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Approach : We check all the neighbors and we follow the rules if it is 1 -> 0 then we make it 2 and 0->1 then 3. Then we make a second pass
//and change all the 2 to 0 and 3 to 1. For checking the number of 1 in the neighbors we take 8 directions and for each direction if 1
//is present then we increment the count and use the total count while following the rules.
public class GameOfLife {
    private int [][] dirs;
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n=board[0].length;
        dirs= new int[][]{{0,1},{-1,0},{0,-1},{1,0},{-1,-1},{-1,1},{1,-1},{1,1}};

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int countAlive = countAlive(board,i,j,m,n);
                if(board[i][j] == 1 && (countAlive <2 || countAlive >3)){
                    board[i][j] =2;
                }
                if(board[i][j] == 0 && countAlive == 3){
                    board[i][j] =3;
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 2){
                    board[i][j] =0;
                }
                if(board[i][j] == 3 ){
                    board[i][j] =1;
                }
            }
        }

    }
    private int countAlive(int [][] board, int i, int j, int m,int n){
            int result =0;
            for(int [] dirs: dirs){
                int r = i+ dirs[0];
                int c= j+ dirs[1];
                if(r>=0 && c>=0 && r<m && c<n && (board[r][c]== 1 || board[r][c] == 2)){
                    result++;
                } 
            }
            return result;
        } 
}
