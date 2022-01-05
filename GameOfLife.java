package array2;

public class GameOfLife {
	//Time Complexity : O(m*n), where m is the rows and n is columns in board
	//Space Complexity : O(1)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : Deciding the values for earlier array
	public void gameOfLife(int[][] board) {
        int[] dir = {0, 1, -1};

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int count = 0;

                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {

                        if (!(dir[k] == 0 && dir[l] == 0)) {
                            int r = (i + dir[k]);
                            int c = (j + dir[l]);
                            if ((r < board.length && r >= 0) && (c < board[0].length && c >= 0) && (Math.abs(board[r][c]) == 1))
                                count += 1;
                        }
                    }
                }

                if ((board[i][j] == 1) && (count < 2 || count > 3))
                    board[i][j] = -1;
                
                if (board[i][j] == 0 && count == 3)
                    board[i][j] = 2;
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] > 0)
                    board[i][j] = 1;
                else
                    board[i][j] = 0;
            }
        }
    }
	
	//Time Complexity : O(m*n), where m is the rows and n is columns in board
	//Space Complexity : O(m*n) for matrix with m rows and n columns
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public void gameOfLife1(int[][] board) {
        int[][] matrix = new int[board.length][board[0].length];
        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                int count = 0;
                
                if(i > 0 && j > 0)
                    count += board[i-1][j-1];
                
                if(i > 0)
                    count += board[i-1][j];
                
                if(i > 0 && j < board[0].length - 1)
                    count += board[i-1][j+1];
                
                if(j < board[0].length - 1)
                    count += board[i][j+1];
                
                if(i < board.length - 1 && j < board[0].length - 1)
                    count += board[i+1][j+1];
                
                if(i < board.length - 1)
                    count += board[i+1][j];
                
                if(i < board.length - 1 && j > 0)
                    count += board[i+1][j-1];
                
                if(j > 0)
                    count += board[i][j-1];
                
                if(board[i][j] == 1 && count < 2)
                    matrix[i][j] = 0;
                if(board[i][j] == 1 && (count == 2 || count == 3))
                    matrix[i][j] = 1;
                if(board[i][j] == 1 && count > 3)
                    matrix[i][j] = 0;
                if(board[i][j] == 0 && count == 3)
                    matrix[i][j] = 1;
            }
        }
        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                board[i][j] = matrix[i][j];
            }
        }
    }
}
