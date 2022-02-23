/*
Time complexity: O(m*n)
Space Complexity: O(1)
Run on leetcode: yes
Any difficulties: no

Approach: attempted after discussed in the class
 */
public class GameOfLife {
    public static void gameOfLife(int[][] board){
        int m = board.length;
        int n = board[0].length;
        int[][] dirs = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
        int [][]next = new int[m][n];

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                int liveCount = 0;

                for(int[] dir: dirs){
                    int x = dir[0]+i;
                    int y = dir[1]+j;
                    if(x>=0 && x<m && y>=0 && y<n && board[x][y] == 1){
                        liveCount++;
                    }
                }

                if(board[i][j]==0 && liveCount == 3){
                    next[i][j] = 1;
                }else if(board[i][j] == 1){
                    if(liveCount == 2 || liveCount == 3){
                        next[i][j] = 1;
                    }
                }

            }
        }

        for(int i =0; i<m; i++){
            for(int j = 0; j<n; j++){
                board[i][j] = next[i][j];
            }
        }
    }
    public static void main(String[] args){
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};

        gameOfLife(board);
    }
}
