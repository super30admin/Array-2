//Time Complexity : O(n^2)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

package com.s30.satish;

class Game_Of_Life_289 {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0)
        	return;
        int left = 0;
        int right = board[0].length;
        
        for(int i = 0; i < board.length; i++)
        {
        	for(int j = 0; j < board[0].length; j++)
            {
            
	        	// 0 => 1 : 10
	        	// 1 => 0 : 5
	        	
        		int livesNum = countLives(board, i, j);
	        	if(board[i][j] == 1 && (livesNum < 2 || livesNum > 3))
	        		board[i][j] = 5;
	        	else if(board[i][j] == 0 && livesNum == 3)
	        		board[i][j] = 10;
            }
        }
        
        for(int i = 0; i < board.length; i++)
        {
        	for(int j = 0; j < board[0].length; j++)
            {
        		if(board[i][j] == 5)
        			board[i][j] = 0;
        		if(board[i][j] == 10)
        			board[i][j] = 1;
            }
        	
        }
    }
    int countLives(int[][] board, int i, int j)
    {
    	int livesCount = 0;
//    	int m = board.length;
//    	int n = board[0].length;
    	int[][] directions = {{-1,0}, {0,1}, {1,0}, {0,-1}, {-1,-1}, {-1,1}, {1,-1}, {1,1}};
    	for(int[] dir : directions)
    	{
    		int row = i + dir[0];
    		int col = j + dir[1];
    		if(row >= 0 && col >= 0 && row < board.length && col < board[0].length && (board[row][col] == 1 || board[row][col] == 5))
    			livesCount++;
    	}
    	return livesCount;
    }
    public static void main(String[] args)
    {
    		int[][] arr = {{0,1,0}, {0,0,1}, {1,1,1}, {0,0,0}};
    		Game_Of_Life_289 t = new Game_Of_Life_289();
    		
    		t.gameOfLife(arr);
    }
}

