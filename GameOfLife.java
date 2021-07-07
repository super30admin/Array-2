// Time Complexity : O(m*n)
// Space Complexity : For Brute Force : O(m*n) For Optimized O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class GameOfLife {
    public static void gameOfLifeBruteForce(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[] a = new int[]{0,0,-1,1,-1,-1,1,1};
        int[] b = new int[]{-1,1,0,0,-1,1,-1,1};
        int[][] uBoard = new int[m][n];

        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                uBoard[r][c] = board[r][c];
            }
        }

        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                int x = board[r][c];

                int count = 0;

                for(int i = 0 ;i < a.length; i++){
                    int p = r+a[i];
                    int q = c+b[i];
                    if(p>=0 && p<m && q>=0 && q<n && board[p][q] == 1){
                        count++;

                    }
                }

                if(x == 1){
                    if(count < 2 || count > 3){
                        uBoard[r][c] = 0;
                    }
                } else {
                    if(count == 3){
                        uBoard[r][c] = 1;
                    }
                }
            }
        }

        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                board[r][c] = uBoard[r][c];
            }
        }

    }

    public static void gameOfLifeOptimized(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[] a = new int[]{0,0,-1,1,-1,-1,1,1};
        int[] b = new int[]{-1,1,0,0,-1,1,-1,1};
        // int[][] uBoard = new int[m][n];
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                int x = board[r][c];

                int count = 0;

                for(int i = 0 ;i < a.length; i++){
                    int p = r+a[i];
                    int q = c+b[i];
                    if(p>=0 && p<m && q>=0 && q<n && (board[p][q] == 1 || board[p][q] == -1) ){
                        count++;

                    }
                }

                if(x == 1){
                    if(count < 2 || count > 3){
                        board[r][c] = -1;
                    }
                } else {
                    if(count == 3){
                        board[r][c] = 2;
                    }
                }
            }
        }

        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(board[r][c] == -1){
                    board[r][c] = 0;
                } else if(board[r][c] == 2){
                    board[r][c] = 1;
                }
            }
        }

    }

    private static void print(int[][] arr){
        for(int i =0 ; i< arr.length; i++){
            for(int j =0 ; j< arr[0].length; j++){
                System.out.println(" "+arr[i][j]);
            }
        }
    }

    public static void main(String args[]){
        System.out.println("Brute Force:");
        int[][] arr = new int[][]{
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}
        };

        gameOfLifeBruteForce(arr);

        print(arr);

        System.out.println("Optimized:");
        int[][] arr1 = new int[][]{
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}
        };

        gameOfLifeOptimized(arr1);

        print(arr1);
    }
}
