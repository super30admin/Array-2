/*
tc: O(m*n)
sc: O(1)*/ 

public class Solution {
    int[][] dirs = 
    {
        new int[] {-1, -1},
        new int[] {-1, 0},
        new int[] {-1, 1},
        new int[] {0, -1},
        new int[] {0, 1},
        new int[] {1, -1},
        new int[] {1, 0},
        new int[] {1, 1}
    };

       
    public void GameOfLife(int[][] board) {
         int m = board.Length;
         int n= board[0].Length;
        
        //base case
        if(m ==0 && n ==0 || board == null)
            return ;
        
         
        for(int i=0; i<m; i++)
        {
            for(int j =0; j<n; j++)
            {
                //count live neighbors
                int count = countLiveNeighbours(board, i, j, m, n);
                
                if(board[i][j] ==1 && (count >3 || count <2))
                {
                    //mark it dead = 11
                    board[i][j] =11;
                }
                if(board[i][j] == 0 && count == 3)
                {
                    //mark it Alive = 10
                    board[i][j] =10;
                }
            }
        }
        
        //Apply the appropriate states after final runthrough
        for(int i=0; i<m; i++)
        {
            for(int j =0; j<n; j++)
            {
                if(board[i][j] ==11) //mark it dead
                {
                    board[i][j] = 0;
                }
                if(board[i][j] ==10) //mark it alive
                {
                    board[i][j] = 1;
                }
            }
        }
        return;
    }
    
    public int countLiveNeighbours(int[][] board, int i, int j, int m, int n)
    {
        int count =0;
        //int nr =0, nc =0;
        
        foreach(int[] dir in dirs)
        {
            int nr = i+dir[0];
            int nc = j+dir[1];
            
            if(nr >=0 && nc >=0 && nr < m && nc <n && (board[nr][nc] == 1 || board[nr][nc] == 11))
            {
                count++;
            }
        }
        return count;
    }
    
}