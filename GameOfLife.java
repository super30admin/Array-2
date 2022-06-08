// Time Complexity: O(m*n)
// Space Complexity: O(1)
public class GameOfLife {
    int m;
    int n;
    int dirs[][];

    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;
        //declare a direction array to mak the update of matrix more scalable
        // 0,1 -> right neighbor  0,-1 -> Left Neighbor
        // 1,0 -> top neighbor -1,0 -> bottom neighbor
        // -1,-1 -> bottom left neighbor -1, 1 -> bottom right neighbor
        // 1, -1 -> top left neighbor 1,1 -> top right neighbor
        dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}, {-1, -1}, {-1, 1}, {1, -1}, {1,1}};

        for(int i=0;i < m; i++){
            for(int j=0; j <n; j++){
                // Get the count of alive neighbors
                int countAlive = count(board, i, j);
                // if the element is alive and the neighbors is overpopulated or underpopulated then mark the element as dead. For temp state we are marking it to 3 so that it doesnt effect other members
                if(board[i][j] == 1 && (countAlive < 2 || countAlive > 3)){
                    board[i][j] = 3;
                }
                // if the element is dead and the alive neighbors is 3 make the element as alive. For temp state we are marking it to 2 so that it doesnt effect other members
                if(board[i][j] == 0 && (countAlive == 3))
                    board[i][j] = 2;
            }
        }

        // Iterate the matrix to make the 2's as 1 and 3's as 0
        for(int i=0; i<m; i++){
            for(int j=0; j < n; j++){
                if(board[i][j] == 2) board[i][j] = 1;
                if(board[i][j] == 3) board[i][j] = 0;
            }
        }
    }

    public int count(int[][] board, int i, int j){
        int res = 0;
        // loop through the dirs array to count the number of neighbors alive or dead.
        for(int[] dir : dirs){
            int nr = i + dir[0];
            int nc = j + dir[1];
            // check the boundaries of the matrix and check if the member is 1 or 3 and increase the alive counter (res)
            if(nr < m && nc < n && nr >= 0 && nc >= 0 && (board[nr][nc] == 1 || board[nr][nc] == 3)){
                res++;
            }
        }
        return res;
    }
}
