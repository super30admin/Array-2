//Time Complexity: O(8 * m *n)...8 is contanst so we can take as mn..and 8 was added because we are visitng 8 neighbors for each cell.
//Space Complexity: O(1)
//Leetcode: yes.

public class GameOfLifeLeetcode289 {

        public void gameOfLife(int[][] board) {
            if (board == null || board[0].length == 0) {
                return;
            }
            int score = 0;
            int[][] dir = {{1,0},{-1,0},{1,1},{1,-1},{0,-1},{0,1},{-1,-1},{-1,1}};

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j< board[0].length; j++) {
                    int countAlive = countAlive(board, i, j, dir);
                    //1...0...===> 3 //we can use any number apart from 0 and 1 as they are inputs
                    // to differentiate the cells fromd dead to alive or going alive to dead.
                    //0...1...===> 2
                    System.out.println(">>>>>>>>i : "+i+" j : "+j+" countAlive :  <<<<<<"+countAlive);
                    if (board[i][j] == 0 && countAlive == 3) {
                        //make 0 as 2 that means we are making a dead cell alive.
                        board[i][j] = 2;
                        System.out.println(">>>>>>>>i : "+i+" j : "+j+" countAlive : "+countAlive+ "board[i][j] :  "+board[i][j]+"<<<<<<<");
                    } else if(board[i][j] == 1 && (countAlive < 2 || countAlive > 3)) {
                        //make 1 as 3 that means we are making the cell as dead.
                        board[i][j] = 3;
                        System.out.println(">>>>>>>>i : "+i+" j : "+j+" countAlive : "+countAlive+ "board[i][j] :  "+board[i][j]+"<<<<<<<");
                    }
                }
            }
            //Now reset the board agian..3 meaning cell will dead and 2 menaing cell will be alive.
            // See above comments for more expalanation on why 2 and 3 and what it converts back to
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j< board[0].length; j++) {
                    if (board[i][j] == 2) {
                        board[i][j] = 1;
                    }
                    if (board[i][j] == 3) {
                        board[i][j] = 0;
                    }
                }
            }
            return;
        }

        public int countAlive(int[][] b, int i, int j, int[][] dirs) {
            int numOfAlive = 0;
            for (int[] dir : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];
                System.out.println("x : "+x+" y : "+y+" numOfAlive : "+numOfAlive);
                if (x >= 0 && x < b.length && y >= 0 && y < b[0].length &&
                        (b[x][y] == 1 || b[x][y] == 3)) {
                    numOfAlive++;
                    System.out.println("x : "+x+" y : "+y+" numOfAlive : "+numOfAlive);
                }
            }
            return numOfAlive;
        }

}
