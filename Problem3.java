//Problem - 289. Game of Life
// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Could not solve it on my own and faced syntax issues
public class Problem3 {
    int[][] dirc;
    int m , n;

    public void gameOfLife(int[][] board){
        this.m = board.length;
        this.n = board[0].length;
        //defining the directions
        this.dirc = new int[][] {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,1},{1,0},{1,-1}};

        //if prev dead now alive then change it with number - 11
        //if prev alive now dead then change it with number - 13

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //this function will give us all the neighbouring 1s for each element. Pass the current element in it and it will give neighbouring 1s. Based on which it will be decided whether the current element will live or die.

                int count = getCount(board, i, j);

                if(board[i][j] == 0){
                    if(count == 3) board[i][j] = 11;
                }
                else if(board[i][j] == 1){
                    if(count <2 || count >3) board[i][j] = 13;
                }
            }
        }

            //get the final array
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(board[i][j] == 11) board[i][j] = 1;
                    else if(board[i][j] == 13) board[i][j] = 0;
                }
            }

    
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
    }

        private int getCount(int[][]board, int idx1, int idx2){
            int count = 0;
            for(int[] dir : dirc){
                int r = idx1 +dir[0];
                int c = idx2 + dir[1];

                if( r >= 0 && c >= 0 && r<m && c<n && (board[r][c] == 1 || board[r][c] == 13)) count++; 
            }
            return count;
        }

        public static void main(String[] args) {
            Problem3 demo = new Problem3();
            int [][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
            demo.gameOfLife(board);
        }
}
