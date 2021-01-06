// Time Complexity : O(n) n: number of elements
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// count neighbour live cells, if state changes updated to 2 for dead to live and 3 for live to dead.
// update final result by cob=verting 2 to 1 and 3 to 0.

public void gameOfLife(int[][] board) {
    int[][] dir = {{0,1},{1,0},{-1,0},{0,-1},{1,1},{-1,1},{1,-1},{-1,-1}};
    int n = board.length;
    int m = board[0].length;
    for(int i = 0; i< n;i++){
        for(int j = 0; j < m; j++){
            int liveCount = 0;
            for(int d = 0; d < dir.length; d++){
                if(i+dir[d][0] >= 0 && i+dir[d][0] < n && j+dir[d][1] >= 0 && j+dir[d][1] < m && (board[i+dir[d][0]][j+dir[d][1]] == 1 || board[i+dir[d][0]][j+dir[d][1]] == 3)){
                    liveCount++;
                }
            }
            //System.out.print(board[i][j] + "\t");
            if(board[i][j] == 0 && liveCount == 3){
                board[i][j] = 2; //live
            } 
            if(board[i][j] == 1 && (liveCount < 2 || liveCount >3)){
                board[i][j] = 3; //dead
            }
        }
        //System.out.println();
    }
    
    for(int i = 0; i< board.length;i++){
        for(int j = 0; j<board[0].length; j++){
            
            if(board[i][j] == 2) board[i][j] = 1;
            else if(board[i][j] == 3) board[i][j] = 0;
        }
        
    }
}