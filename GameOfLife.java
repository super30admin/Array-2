/*
Time Complexity: O(m*n)

    1. Outer Loop (Matrix Traversal)
        The matrix is traversed using two nested loops:

        The outer loop runs for m rows.
        The inner loop runs for n columns.
        This gives a time complexity of O(m×n) for traversing the matrix.

    2. Neighbor Counting (getLiveCount Method)
        For each cell, the getLiveCount method checks all 8 possible neighbors (constant work). The neighbor
        checks are bounded by the matrix size m×n.

        Thus, for each cell, this operation is O(1), and for all m×n cells, the total cost is O(m×n).

    While there are two passes over the matrix (one for updating states and another for finalizing them),
    the constants involved in these passes are insignificant in Big-O notation. Hence,

    O(m×n)+O(m×n)=O(2×(m×n)), which simplifies to just O(m × n).

Space Complexity: O(1)

Did this code successfully run on Leetcode: Yes

Check video for next criteria explanation of Infinite Board

 */
class GameOfLife {
    public void gameOfLife(int[][] board) {

        /*
        0(dead cell) has 3 live neighbours => 1(it becomes alive)
        1(alive cell) has <2 OR >3 live neighbors => 0(it dies)
        */
        int m = board.length;
        int n= board[0].length;
        //up, down, left, right, upleft, upright, downleft, downright
        int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}, {-1,-1}, {-1,1}, {1,-1}, {1,1}};

        /*
        3 => previously dead, now alive
        2 => previously alive, now dead
        */
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                int count = getLiveCount(dirs, board, i, j, m, n);

                if(board[i][j] == 0) //dead cell
                {
                    if(count == 3) {
                        board[i][j] = 3; //dead => alive
                    }
                }
                else if(board[i][j] == 1)
                {
                    if(count < 2 || count > 3) {
                        board[i][j] = 2; //alive => dead
                    }
                }
            }
        }

        //Getting the input matrix back
        /*
        3 => previously dead, now alive
        2 => previously alive, now dead
        */
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(board[i][j] == 2) {
                    board[i][j] = 0;
                }
                else if(board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private int getLiveCount(int[][] dirs, int[][] board, int i, int j, int m, int n)
    {
        // for(int i=0; i<dirs.length; i++) {
        //     int[] dir = dirs[0];
        // }

        int count = 0;

        for(int[] dir : dirs) //{{-1,0}, {1,0}, {0,-1}, {0,1}, {-1,-1}, {-1,1}, {1,-1}, {1,1}}
        {
            //eg: (i:1, j:1) so middle element, we add direction array elements to get all 8 directions
            int nr = dir[0] + i;
            int nc = dir[1] + j;

            //All elements in matrix wont have all 8 directions, we only need alive count so we only check for 1
            //as decision as per question is made on alive neighbors count not dead neighbors count
            if(nr>=0 && nr<m && nc>=0 && nc<n) {
                if(board[nr][nc] == 1 || board[nr][nc] == 2) {
                    count++;
                }
            }
        }

        return count;
    }
}
