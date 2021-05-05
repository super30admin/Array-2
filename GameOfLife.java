// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity : O(m * n) since we are iterating through the matrix couple of times
//Space Complexity: O(1) since we are not taking any extra space

public void gameOfLife(int[][] board) {
        //live to die => -1
        //die to live => 2
        for(int i=0; i<board.length; i++) {
        		for(int j=0; j<board[0].length; j++) {
        			if(board[i][j] == 1) {
        				//Case-1 or Case-3
        				if(livingCount(board, i, j) < 2 || livingCount(board, i, j) > 3) {
            				board[i][j] = -1;
            			}
        			} else {
        				//Case-4
            			if(livingCount(board, i, j) == 3) {
            				board[i][j] = 2;
            			}
        			}
        		}
        }
        
        for(int i=0; i<board.length; i++) {
	    		for(int j=0; j<board[0].length; j++) {
	    			if(board[i][j] == -1) {
	    				board[i][j] = 0;
	    			} else if(board[i][j] == 2) {
	    				board[i][j] = 1;
	    			}
	    		}
        }
    }
    
    private int livingCount(int[][] board, int i, int j) {
		int count = 0, nrows = board.length, ncols = board[0].length;
		
		//top
		if(i>0) {
			if(board[i-1][j] == 1 || board[i-1][j] == -1) count++;
		}
		
		//right
		if(j < ncols-1) {
			if(board[i][j+1] == 1 || board[i][j+1] == -1) count++;
		}
		
		//bottom
		if(i < nrows-1) {
			if(board[i+1][j] == 1 || board[i+1][j] == -1) count++;
		}
		
		//left
		if(j > 0) {
			if(board[i][j-1] == 1 || board[i][j-1] == -1) count++;
		}
		
		// top-left
		if(i>0 && j > 0) {
			if(board[i-1][j-1] == 1 || board[i-1][j-1] == -1) count++;
		}
		
		//top-right
		if(i>0 && j<ncols-1) {
			if(board[i-1][j+1] == 1 || board[i-1][j+1] == -1) count++;
		}
		
		//bottom-left
		if(i < nrows-1 && j > 0) {
			if(board[i+1][j-1] == 1 || board[i+1][j-1] == -1) count++;
		}
		
		//bottom-right
		if(i < nrows-1 && j < ncols-1) {
			if(board[i+1][j+1] == 1 || board[i+1][j+1] == -1) count++;
		}
		
		return count;
	}