//448. Find All Numbers Disappeared in an Array
//Time Complexity :O(m*n) as iterating in 1 pass through all n elements
//Space Complexity : O(1) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No



public class GameOfLife {

	static int m;
	static int n;
    public static int[][] gameOfLife(int[][] board) {
        if(board == null || board.length == 0) return board;
        
        m= board.length;
        n= board[0].length;
        
        //0->1========2
        //1->0========3
               
        for(int i=0; i<m ; i++)
        {
            for(int j=0; j<n; j++)
            {
                int countOfLiveCells = countLives(board, i, j);
                if(board[i][j] == 0)
                {
                    if(countOfLiveCells == 3){ //exact 3
                    board[i][j] = 2;}
                }
                else {
                    if(countOfLiveCells > 3){ //more than 3 live cells
                        board[i][j] = 3;
                    }
                     if(countOfLiveCells < 2){//less than 3
                        board[i][j] = 3;
                    }
                    }
            }
        }
        
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(board[i][j] == 3)
                    board[i][j] = 0;  //if it's 3 means it's dead cell
                else
                if(board[i][j] == 2)
                    board[i][j] = 1;  //else if value of board[i][j] is 2 means it is live cell
            }
        }
		return board;
    }
        
        private static int countLives(int [][] board, int r, int c)
        {
            int cnt=0;
            int nr=0,nc=0;
            
            int[][] dirs={{1,-1},{-1,-1},{0,1},{0,-1},{-1,0},{1,0},{1,1},{-1,1}};
            for(int[] i : dirs)
            {
                nr= r + i[0];
                nc= c + i[1];
                
                if(nr>=0 && nr<m &&  nc>=0 && nc<n && (board[nr][nc] == 1 || board[nr][nc]==3))  ///treating boundary condition. Also counting for live cells. So, all 1 and 3s which was live will be counted as live cells
                {
                       cnt++;
                }
            }
            return cnt;
        }   
        
        public static void main(String[] args) {
        	
        	int[][] b= {{1,1},{1,0}};
        	
        	int[][] res=new int[b.length][b[0].length];
        	for(int i=0; i<b.length; i++)
            {
                for(int j=0; j<b[0].length; j++)
                {
                    res=gameOfLife(b);
                }
            }
        	//for printing
            for(int i=0; i<b.length; i++)
            {
                for(int j=0; j<b[0].length; j++)
                {
                    System.out.print("["+res[i][j]+"]");
                }
            }
        }
}
