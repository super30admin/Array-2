// Time Complexity : O(m*n) m rows, n cols
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Approach:
    We're given a board representing the Game of Life.
    We have to apply the rules in-place (without using extra space).
    To handle in-place updates without losing the original state, we use:
    - `2` to represent a cell that was alive but will die (1 → 0)
    - `3` to represent a cell that was dead but will come alive (0 → 1)
    In the first pass, we compute the number of live neighbors for each cell,
    then encode its next state using 2 or 3 based on the rules.
    In the second pass, we decode these temporary states to get the final board. 
*/


public class GameOfLife {
    int m, n;

    public void solve(int[][] board){
        if(board == null || board.length==0){
            return;
        }

        m = board.length;
        n = board[0].length;

        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                int countLiveNeighbors = countLiveNeighbors(board, i, j);

                if(board[i][j] == 1){
                    if(countLiveNeighbors < 2 || countLiveNeighbors > 3){
                        board[i][j] = 2; // 1 -> 0 = 2
                    } 
                }
                else if(board[i][j] == 0){
                    if(countLiveNeighbors == 3){
                        board[i][j] = 3; // 0 -> 1 = 3
                    }
                }

            }
        }


        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }
                else if(board[i][j] == 3){
                    board[i][j] = 1;
                }
            }
        }

    }

    private int countLiveNeighbors(int[][] board, int i, int j) {
        int count = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}}; 
        // Up, Down, Left, Right, Upper Left, Upper Right, Lower left, Lower Right

        for(int[] dir : dirs){
            int nr = i + dir[0];
            int nc = j + dir[1];

            if(nr >= 0 && nr < m && nc >= 0 && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 2)){
                count++;
            }


        }

        return count;



    }

    public static void main(String[]args){
        GameOfLife ob = new GameOfLife();
        int[][] board = {
            {0, 1, 0},
            {0, 0, 1},
            {1, 1, 1},
            {0, 0, 0}
        };

        ob.solve(board);

        for(int[] row : board){
            for(int cell : row){
                System.out.print(cell + " ");
            }
            System.out.println();
        }










    }


    
}
