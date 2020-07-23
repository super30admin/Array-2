public class Game_of_life {
	//Approach: 1. Am trying to change it in-place, the problem is: a). need to preserve the old state as well as new state. 
	//2. 2 changes possible - 0->1, i mark it as 2 and 1-> 0, i mark it as 3. 
	//3. While iterating through the matrix, for each element i will check the live neighbors, if the element which was 1, dies then it will be marked as 3 or if the 0 element becomes 1 it is marked as 2.
	//4. Final iteration, i go through the matrix and replace 2 with 1 and 3 with 0 this retrieves the new state. 
	public void gameOfLife(int[][] board) {
        //direction to go for left, right, top, bottom, top left, top right, bottom left, bottom right
        int[][] directions = {{0,-1},{0,1},{-1,0},{1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
       // int lives = 0;
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                int lives = 0;
                for(int[] dir: directions)
                {
                    int x = i+dir[0];
                    int y = j+dir[1];
                    if(x < 0 || y <0 || (x >= board.length) || (y >= board[0].length))
                    {
                        continue;
                    }
                 
                    if(board[x][y] == 1 || (board[x][y] == 3))
                        lives ++;
                }
               
                if(board[i][j] == 1 && (lives < 2 || lives > 3))
                    board[i][j] = 3;
              
                if(board[i][j] == 0 && lives == 3)
                    board[i][j] = 2;
            }
        }
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j] == 2)
                    board[i][j] = 1;
                else if(board[i][j] == 3)
                    board[i][j] = 0;
            }
        }
    }
}
//Time Complexity : O(m*n) 
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :