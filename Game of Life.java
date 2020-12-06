/*
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        if board is None or len(board) == 0:
            return
        rows, cols = len(board), len(board[0])
        
        def countLives(board, i, j):
            count = 0
            direction = [(0,1), (1,0), (1,1), (0,-1), (-1,0), (-1,-1), (1,-1), (-1,1)]
            for dx, dy in direction:
                new_x = i + dx
                new_y = j + dy
                if 0 <= new_x < rows and 0 <= new_y < cols and (board[new_x][new_y] == 1 or board[new_x][new_y] == 3):
                    count += 1
            return count
        
        for i in range(rows):
            for j in range(cols):
                liveCells = countLives(board, i, j)
                
                if board[i][j] == 1 and (liveCells < 2 or liveCells > 3):
                    board[i][j] = 3
                    
                elif board[i][j] == 0 and liveCells == 3:
                    board[i][j] = 2
        
        for i in range(rows):
            for j in range(cols):
                if board[i][j] == 3:
                    board[i][j] = 0
                    
                elif board[i][j] == 2:
                    board[i][j] = 1
        
*/

// Time Complexity : O(rows*cols)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: Whenever a cell is to die I marked that as 3 and whenever a cell is about
// to come to live I marked as 2.

class Solution {
    int rows, cols;
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0){
            return;
        }
        
        rows = board.length; 
        cols = board[0].length;
        for (int i=0; i < rows; i++){
            for (int j=0; j < cols; j++){
                int lives = countLives(board, i, j);
                
                if (board[i][j] == 1 && (lives <2 || lives >3)){
                    board[i][j] = 3;
                }
                else if (board[i][j] == 0 && lives == 3){
                    board[i][j] = 2;
                }
            }
        }
        
        for (int i=0; i < rows; i++){
            for (int j=0; j < cols; j++){
                
                if (board[i][j] == 3){
                    board[i][j] = 0;
                }
                else if (board[i][j] == 2){
                    board[i][j] = 1;
                }
            }
        }
        
    }
    
    private int countLives(int[][] board, int i, int j){
        int count = 0;
        int[][] dir = {{0,1}, {1,0}, {1,1}, {0,-1}, {-1,0}, {1,-1}, {-1,1}, {-1,-1}};
        for (int[] d: dir){
            int new_x = i + d[0];
            int new_y = j + d[1];
            if (0 <= new_x && new_x < rows && 0 <= new_y && new_y < cols && (board[new_x][new_y] == 1 || board[new_x][new_y] == 3)){
                count++ ;
            }
        }
        return count;
    }
}