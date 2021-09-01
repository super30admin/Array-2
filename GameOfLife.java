// TIME: O(mn)
// SPACE: O(mn)
// SUCCESS on LeetCode

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int[][] next = new int[board.length + 2][board[0].length + 2];
        int[][] nextState = new int[board.length][board[0].length];

        for (int i =0; i < board.length +2; i++) {
            next[i][0] = 0;
            next[i][board[0].length+1] = 0;
        }

        for (int i =0; i < board[0].length +2; i++) {
            next[0][i] = 0;
            next[board.length +1][i] = 0;
        }

        for (int i = 1; i <= board.length; i++) {
            for (int j =1; j <= board[0].length; j++) {
                next[i][j] = board[i-1][j-1];
            }
        }

        for (int i = 1; i <= next.length-2; i++) {
            for (int j =1; j <= next[0].length-2; j++) {
                int count = next[i-1][j-1] + next[i-1][j] + next[i-1][j+1] + next[i]                 [j-1] + next[i][j+1] + next[i+1][j-1] + next[i+1][j] + next[i+1]                     [j+1];
                if ((next[i][j] == 1) && (count > 3 || count < 2) ) {
                    nextState[i-1][j-1] = 0;
                } else if ((next[i][j] == 0) && count == 3 ) {
                    nextState[i-1][j-1] = 1;
                } else {
                    nextState[i-1][j-1] = next[i][j];
                }
            }
        }
        
        for (int i = 0; i < nextState.length; i++) {
            for (int j = 0; j < nextState[0].length; j++) {
                board[i][j] = nextState[i][j];
            }
        }
    }
}
