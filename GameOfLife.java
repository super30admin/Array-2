// Time complexity = O(m*n)
// Space complexity = O(1)
// we marked the board as 2 or 3 depending on whether it will be alive or dead.
// we don't mark it as 0 or 1 , since we still have to go through all the board numbers, and it will get affected when we change any part of array before completing the entire iteration.
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        // m x n grid.
        int m = board.length;
        int n = board[0].length;
        int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}, {1,1}, {-1,-1},
                                   {1,-1}, {-1,1}};// direction array.// This is O(1) complexity.
        // eg - let's just say you are at 0,0. for 8 neighbours you will need to move your index as per the dirs.
        for(int i=0;i< m;i++)  {
            for(int j=0;j< n ;j++) {
                int count = countAlive(board, i,j , dirs);
                if(board[i][j] == 1) {
                    if(count<2 || count>3) {// underpopulation-> condition 1, overpopulation -> condition 3
                        board[i][j] =2;// dead .
                    }
                }
                if(board[i][j] == 0) {
                    if(count==3) {// zombie condition. condition 4
                        board[i][j] = 3; // regenerated. zombie.
                    }
                }
            }
        }
                
        // for the next generation. 
        for(int i=0;i< m;i++)  {
            for(int j=0;j< n ;j++) {
                if(board[i][j] == 2 ) {
                    board[i][j] = 0;
                }
                if(board[i][j] == 3 ) {
                    board[i][j] = 1;
                }
            }
        }
        
    }
    
    private int countAlive(int[][] board, int i,int j ,int[][] dirs) {
        int count =0;
        for(int[] dir: dirs) {
            int nr = i+ dir[0];
            int nc = j+ dir[1];
            if(nr>= 0 && nr<= board.length-1 && nc>=0 && nc<= board[0].length-1) {
                if(board[nr][nc] ==1  ||  board[nr][nc] ==2) {
                    // why we took board[nr][nc] ==2, cause the pre-req for 2 is that it was alive earlier. Now it is dead, but that is immaterial for this generation.
                    count++;
                }
            }
        }
        return count;
    }
}