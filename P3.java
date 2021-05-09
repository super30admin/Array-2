//time- o(m*n)
//space- o(1)
//passed in leetcode- yes

class Solution {
    public void gameOfLife(int[][] board) {
        int m= board.length;
        int n= board[0].length;
        if(board==null || board.length==0 || board[0].length==0) return ;
        //1->0=3 live to dead
        //0->1=2 dead to alive
        int lives;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                lives= countLives(board, i, j, m , n);
                if(board[i][j]  ==1 && (lives<2 || lives >3))//under or over population, then dies
                {
                    board[i][j] = 3;
                }
                else if(board[i][j] ==0 && lives==3)//becomes alive
                {
                    board[i][j] = 2;
                }
            }
        }
         for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if (board[i][j]==3)  board[i][j]=0;
                if (board[i][j]==2)  board[i][j]=1;
            }
        }
    }
    
     int countLives(int[][]board, int i, int j, int m, int n)
    {   int r=0;
        int c=0;
        int lives=0;
       //direction array to cover all neighbours, these are directions
       //for eg. (0,1) is +1 on column and same row
       //right   left  top right
        int[][] dirs= {{0,1} , {1,0} , {-1,1}, {1,-1} , {-1,-1} , {0,-1} , {-1,0}, {1,1}};
        for(int[] dir: dirs)
        {
            r = i+dir[0]; 
            c = j+dir[1];
            if(r>=0 && c>=0 && r<m && c<n)
            {
                if(board[r][c]==1 || board[r][c] == 3)
                {
                    lives++;
                }                
            }
        }
     return lives;
     
    }
        
}