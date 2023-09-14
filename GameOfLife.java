class GameOfLife {
    //Will mutate the given array
    //1->0 then update as 2.
    //0->1 then update as 3.
    //TC will be O(m * n), as iterating over the m*n array twice it will be O(m * n)+ O(m * n), asymptotically, it will be O(m * n).
    //SC will be O(1), as just mutating the given array.
    int m, n;       //global variables
    public void gameOfLife(int[][] board) {
        if(board==null || board.length==0){     //Base condn to check if array is empty.
            return;
        }

        m = board.length;           //No. of rows.
        n = board[0].length;        //No. of cols.

        for(int i=0; i<m;i++){      //To iterate over the rows to mutate it loop
            for(int j=0; j<n; j++){     //To iterate over the columns.
                int countLiveNeighbors = countLiveNeighbors(board, i, j);   //recursively calling to count neighbors.
                if(board[i][j] == 1){
                    if(countLiveNeighbors <2 || countLiveNeighbors > 3){
                        board[i][j] = 2;        //Changes to 0
                    }
                }
                else if(board[i][j] == 0){
                    if(countLiveNeighbors == 3){
                        board[i][j] = 3;          //Changes to 1
                    }
                }
            }
        }

        for(int i=0; i<m; i++){     //loop to reassign the value to each element in the matrix
            for(int j=0; j<n; j++){
                if(board[i][j] == 2){           //reassign the value
                    board[i][j] = 0;
                }
                else if(board[i][j]== 3){
                    board[i][j] = 1;
                }
            }
        }

    }

    private int countLiveNeighbors(int[][] board,int r, int c){
        int count=0;    //variable to store count.
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}}; //U, D, L , R, UL, UR, LL, LR. 2D array to store 8 directions.
        for(int[] dir:dirs){        //to get the neighboring co-ordiantes.
            int nr = r + dir[0];        //update the row
            int nc = c + dir[1];        //update the column
            if(nr >= 0 && nr < m && nc >=0 && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 2)){
                //Edge cases and to incremnet count whenever 1 is encountered or 2(as prev value was 1)
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        GameOfLife obj = new GameOfLife();
        obj.gameOfLife(board);
    }

}