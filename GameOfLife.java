// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes - the answer was showing incorrect because of my code in the getLiveCount
// had to keep track of -1 and 1


// Your code here along with comments explaining your approach - converted dead->alive = 2 and alive->dead=-1
//then gotLiveCount and updated the matrix based on the conditions.

/**
 * GameOfLife : GameOfLife
 *
 * @author : Kavya Mandaliya
 * @version : 1.0 (Nov 07, 2024)
 * @since : 1.0 (Nov 07, 2024)
 */
public class GameOfLife {
    int directions[][] = new int[][]{{-1,0}, {0,-1}, {1,0}, {0,1},
            {-1,-1}, {-1,1}, {1,-1}, {1,1}};
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n ; c++){
                int count = getLiveCount(board,r,c);
                if(board[r][c] == 0){
                    if(count == 3){
                        board[r][c] = 2;
                    }
                }else if(board[r][c] == 1){
                    if(count < 2 || count > 3){
                        board[r][c] = -1;
                    }
                }
            }
        }
        for(int r = 0; r < m; r++){
            for(int c = 0;  c < n; c++){
                if(board[r][c] == 2){
                    board[r][c] = 1;
                }else if(board[r][c] == -1){
                    board[r][c] = 0;
                }
            }
        }
    }

    public int getLiveCount(int[][] board, int r, int c){
        int count = 0;
        int m = board.length, n = board[0].length;
        for(int dir[] : directions){
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(nr >= 0 && nr < m && nc >= 0 && nc < n){
                if(Math.abs(board[nr][nc]) == 1)
                    count++;
            }
        }
        return count;
    }

}
