// Time Complexity : O(m*n) where m is number of rows and n is number of columns
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// iterate over matrix calculate the live and dead neighbours and mark transition from 1 -> 0 as -1 and 0 -> 1 as 2
//  iterate again over the matrix and convert -1 to 0 and 2 to 1

class Solution {
    public void gameOfLife(int[][] board) {

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                int live  = getLiveNeighbours(board, new int[]{i, j});
                int dead = getDeadNeighbours(board, new int[] {i, j});
                if (Math.abs(board[i][j]) == 1) {
                    if (live < 2) {
                        board[i][j] = -1;
                    } else if (live ==2 || live ==3) {
                        board[i][j] = 1;
                    } else if (live >3) {
                        board[i][j] = -1;
                    }

                } else {
                    if (live == 3) {
                        board[i][j] = 2;
                    }
                }

            }
        }

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                } else if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }

    }
    int[][] neighboursIndex = new int[][]{{-1,0}, {1,0}, {0,-1}, {0, 1}, {-1, -1}, {1, 1} , {-1, 1}, {1, -1}};

    private List<int[]> getNeighbours(int[][] board, int[] xy) {

        List<int[]> res = new ArrayList<>();
        for (int[] change : neighboursIndex) {
            int [] cordinates = {xy[0] + change[0], xy[1] + change[1]};
            if (cordinates[0] >=0 && cordinates[0]<board.length && cordinates[1] >=0 && cordinates[1]< board[0].length) {
                res.add(cordinates);
            }
        }
        return res;
    }

    private int getLiveNeighbours(int[][] board, int[] xy) {

        int live = 0;

        for(int[] c : getNeighbours(board, xy)) {
            if (Math.abs(board[c[0]][c[1]]) == 1) {
                live++;
            }
        }

        return live;
    }

      private int getDeadNeighbours(int[][] board, int[] xy) {

        int dead = 0;

        for(int[] c : getNeighbours(board, xy)) {
            if (Math.abs(board[c[0]][c[1]]) != 1) {
                dead++;
            }
        }

        return dead;
    }

}
