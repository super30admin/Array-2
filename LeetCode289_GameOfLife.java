
//approach - traverse through the board and update the cell value based on neighbors by following the mentioned rules. 
// at last update the board based on found values and return. 
//TC- O(m*n) + O(m*n) == (traversing through board+calculating neighbour) + (replacing the value 0 and 1 at 2 and 3 respectively. )
//TC= O(m*n)
//space - constant O(1

//Contraint from questions . . 
//cell dies - <2 neighbors
//          - >3 neighbors
          
//lives as it is - h 2 or 3 neighbor
//dead to life - exactly 3 neighbors
    
    

class Solution {
    public void gameOfLife(int[][] board) 
    {
      
        //base case
        if(board == null || board.length ==0) return;
        
        //if cell dies - place 2
        //if cell produced - place 3
        //2 & 3 are taken as board value will either be 0 or 1. // we put 2 and 3, so at the time of calculation, we dont place 0 or 1, once we calculate the neighbor for entire board - then only we put 2 as 0 and 3 as 1. 
        // we cannot mutate the matrix before calculating all it's neighbors , owise it will lead us to a false result. 
        
        int m = board.length;
        int n= board[0].length;
        
        for(int i =0; i< m ; i++)
        {
            //columns
            for(int j=0; j < n; j++)
            {
                //calculate the neighbors
                int liveNeighbor = countLiveNeighbour(board, i, j, m, n);
                
                if(board[i][j] == 1)
                {
                    //cell dies
                    if(liveNeighbor < 2 || liveNeighbor >3 )
                    {
                        board[i][j] = 2;
                    }   
                    //it lives
                    //else (liveNeighbor == 2 || liveNeighbor == 3)
                }
                else //board[i][j] ==0,
                {
                    //reproduce
                     if(liveNeighbor == 3 )
                     {
                         board[i][j] =3;
                     }
                }
                
            }
        }
        //replacing 1 and 0 where we put 2 and 3
        
        for(int i=0; i < m ; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(board[i][j] ==2)
                    board[i][j] = 0;
                
                if(board[i][j] == 3)
                    board[i][j] = 1;
            }
        }
        return;
    }
    
    private int countLiveNeighbour(int[][] board, int i, int j, int m, int n )
    {
        int[][] dirs = {{-1,-1}, {1,1},{1,-1},{-1,1},{0,-1},{0,1},{-1,0},{1,0}};
         int nr=0; //neighborRow
         int nc =0; //neighborCol
         int count =0;   
        
        for(int[] dir : dirs)
        {
            nr = i + dir[0];
            nc = j + dir[1];
            
            if(nr >=0 && nc >= 0 && nr <= m-1 && nc <= n-1 && (board[nr][nc] ==1 || board[nr][nc] ==2))
                count++;
        }
        return count;
    }
}