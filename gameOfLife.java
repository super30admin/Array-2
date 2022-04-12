/**
Problem: https://leetcode.com/problems/game-of-life/
TC: O(m * n)
SC: O(1)
*/
class Solution {
    final int aliveToDead = 2;
    final int deadToAlive = -1;
    int n;
    int m;
    int dirs[][] = {
        {-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}
    };
    
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        
        n = board.length;
        m = board[0].length;
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int liveCount = getLiveCount(board, i, j);
                
                if (board[i][j] == 1) {
                    if (liveCount > 3) {
                        // Dead due to overpopulation
                        board[i][j] = 2;
                    } else if (liveCount < 2) {
                        // Dead due to underpopulation
                        board[i][j] = 2;
                    }
                } else {
                    if (liveCount == 3) {
                        // Alive due to reproduction
                        board[i][j] = -1;
                    }
                }
            }
        }
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == -1) {
                    board[i][j] = 1;
                }
            }
        }
    }
    
    public int getLiveCount(int board[][], int i, int j) {
        int liveCount = 0;
        
        for (int d[] : dirs) {
            int x = i + d[0];
            int y = j + d[1];
            
            if (x < 0 || y < 0 || x >= n || y >= m) {
                continue;
            }
            
            if (board[x][y] >= 1) {
                ++liveCount;
            }
        }
        
        return liveCount;
    }
}