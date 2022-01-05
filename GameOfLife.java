// Time Complexity : O(m * n) where m is row and n is column of board matrix
// Space Complexity : O(m * n) where m is row and n is column of board matrix
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class GameOfLife {
    public static void main(String[] args) {
        
    }
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0){
            return;
        }
        
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0},
                       {1,1},{-1,-1},{1,-1},{-1,1}};
        int row = board.length, col = board[0].length;
        int[][] temp = new int[row][col];
        
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                temp[r][c] = board[r][c];
            }
        }
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                int curR = r, curC = c;
                int neighborCount = 0;
                for(int[] d: dir){
                    int newR = curR + d[0], newC = curC + d[1];
                    
                    if(newR < 0 || newR >= row || newC < 0 || newC >= col){
                        continue;
                    }
                    if(board[newR][newC] == 1){
                        neighborCount++;
                    }
                    
                }
                //System.out.println(r+", "+c+". "+neighborCount);
                int curr = board[r][c];
                if(curr == 1 && neighborCount < 2){
                    temp[r][c] = 0;
                    continue;
                }
                if(curr == 1 && (neighborCount == 2 || neighborCount == 3)){
                    continue;
                }
                if(curr == 1 && neighborCount > 3){
                    temp[r][c] = 0;
                    continue;
                }
                if(curr == 0 && neighborCount == 3){
                    temp[r][c] = 1;
                    continue;
                }
                temp[r][c] = board[r][c];
            }
        }
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                board[r][c] = temp[r][c];
            }
        }
    }
}
