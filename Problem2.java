// Time Complexity : O(M*N) + O(M*N) ~ O(M*N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
If 1 is live, but dead I marked it as 2. If 0 becomes alive I marked it as 3.
I used the temporary state change pattern. I first counted the live neighbors by equating it with 2 or 1, where 2 indicates it was alive in the initital states.
Once I had the liveNeighbors I applied the rules to change the state temporarily and then at the end, if it 3 I changed to 1, if it is 2 changed it to 0
*/

public class Problem2 {
    private static int[][] dir = {{-1,-1}, {-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}};

    public void gameOfLife(int[][] board) {
        // 1 -> 0 ~ 2
        // 0 -> 1 ~ 3

        int m = board.length;
        int n = board[0].length;

        for(int i = 0;i<m;i++) {
            for(int j = 0;j<n;j++) {
                int currCell = board[i][j];
                int liveNeighbors = countLiveNeighbours(board, i, j);
                if(currCell == 1) {
                    if(liveNeighbors < 2) {
                        board[i][j] = 2;
                    } else if(liveNeighbors > 3) {
                        board[i][j] = 2;
                    }
                } else if(currCell == 0){
                    if(liveNeighbors == 3) {
                        board[i][j] = 3;
                    }
                }
            }
        }

        for(int i = 0;i<m;i++) {
            for(int j = 0;j<n;j++) {
                if(board[i][j] == 2) {
                    board[i][j] = 0;
                } else if(board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private int countLiveNeighbours(int[][] board, int row, int col) {
        int cntLive = 0;
        for(int[] d : dir) {
            int nr = row + d[0];
            int nc = col + d[1];

            if(nr >= 0 && nr < board.length && nc >= 0 && nc < board[row].length && (board[nr][nc] == 2 || board[nr][nc] == 1)) {
                cntLive++;
            }
        }

        return cntLive;
     }
}
