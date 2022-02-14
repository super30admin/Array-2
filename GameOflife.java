// Time Complexity : o(m*n)
// Space Complexity :0(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach: in place array change

class Solution {
    int [][] dirs;
    int row;
    int col;
    public void gameOfLife(int[][] board) {
        

        dirs = new int[][] {{0,1},{-1,0},{1,0},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
        row = board.length;
        col = board[0].length;
        
        for(int i = 0; i< row;i++)
        {
            for(int j = 0 ;j < col ;j++)
            {
                int countAlive = countAlive(board, i, j);
                
                if(board[i][j] == 1 && (countAlive <2 || countAlive >3))
                {
                    board[i][j] = 2;
                }
                if(board[i][j] == 0 && countAlive == 3)
                {
                    board[i][j] = 3;
                }
                
            }
        }
        
    
        for(int i = 0; i< row;i++)
        {
            for(int j = 0 ;j < col ;j++)
            {
                if(board[i][j] == 2)
                {
                    board[i][j] = 0;
                }
                if(board[i][j] == 3)
                {
                    board[i][j] = 1;
                }
            }
        }
                 
}
private int countAlive (int[][] board, int i, int j){
    int count = 0;
    for(int[] dir: dirs)
    {
        int r = i +dir[0];
        int c = j + dir[1];
        if(r>=0 && c>=0 && r< row && c < col && (board[r][c] == 2 || board[r][c]==1)){
            count++;
        }
    }  
    return count;

}

}