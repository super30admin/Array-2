// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


	// 2) When we change live to dead 1 ->0, change to 2
	// 3) When we change dead to live 1-> 0, change to 3
	// 4) So that we know what was the old value, that way we can change value in same array
	// And also calculate new values.
	// 5) In the end, iterate over matrix1, change all 2 to 0 and 3 to 
//to make it scalable above solution
	// 2) We use same approach, but we use directions array to calculate neighbor value and see count of neighbor live cells 

public void GameOfLife(int[][] board) {
        
    if(board == null || board.Length == 0)
        return;
    
    int m = board.Length;
    int n = board[0].Length;
    
    for(int i = 0; i < m; i++)
    {
        for(int j = 0; j < n; j++)
        {
            int countLiveCells = getCount(board, i, j);
            
            if(board[i][j] == 1)
            {
                //When we change live to dead 1 ->0, change to 2
                //When we change dead to live 1-> 0, change to 3
                //So that we know what was the old value, that way we can change value in same array
                //And also calculate new values.
                if(countLiveCells < 2 || countLiveCells > 3)
                {
                    board[i][j] = 2;
                }
            }
            else
            {
                if(countLiveCells == 3)
                {
                    board[i][j] = 3;
                }
            }
        }
    }
    
    //In the end, iterate over matrix1, change all 2 to 0 and 3 to
    for(int i = 0; i < m; i++)
    {
        for(int j = 0; j < n; j++)
        {
            if(board[i][j] == 2)
                board[i][j] = 0;
            else if(board[i][j] == 3)
                board[i][j] = 1;
        }
    }
}

 private int getCount(int[][] board, int r, int c)
{
    //these are possible direction for each element, right left, up, down and diagonal
    int[][] dirs = new int[][] {new int[] {0,1}, new int[] {0,-1}, new int[] {1,0}, new int[] {-1,0}, new int[] {1,1}, new int[] {-1, -1}, new int[] {-1, 1}, new int[] {1, -1}};
    
    int m = board.Length;
    int n = board[0].Length;
    int total = 0;
    
    foreach(var dir in dirs)
    {
        //calculate new row andnew column
        int nr = r + dir[0];
        int nc = c + dir[1];
        
        //make sure its not going out of bounds
        //if value is 1 or 2(previously 1), then it means live coung
        if(nr >= 0 && nr < m && nc >= 0 && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 2))
            total++;
    }
    
    return total;
}