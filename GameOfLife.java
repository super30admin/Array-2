// Approach : Traverse through the matrix and find the values of each of its eight neighbours and apply conditions 
// to check dead or alive based on conditions. 
// 2- > alive -> dead
// 3 -> dead -> alive
// Time : 2 * O(m*n)
// Space: O(m*n)

class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;      // up //down //left //right //upleft//upright//downleft// downright
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
        for(int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                int count = getLiveCount(dirs,board,i,j,m,n);
                if(board[i][j]==0){
                    // we are on a dead cell
                    if(count == 3){
                        // previously it was dead. Now it became alive
                        board[i][j]=3; // dead -> alive
                    }
                } else{
                    // we are on live cell board[i][j] =1
                    if(count < 2 || count > 3){
                        // it will be dead
                        board[i][j] = 2;
                    }
                }
            }
        }

        // Again traverse through the board and form the original matrix;
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if(board[i][j]==2){
                    board[i][j]=0;
                } else if (board[i][j]==3){
                    board[i][j]=1;
                }
            }
        }
    }

    private int getLiveCount(int [][] dirs, int [] [] board, int i,int j, int m,int n){
        int count =0;
        // form the neighbouring row indeces
        for(int[] dir:dirs){ // {-1,0}
            int nr = dir[0]+i; // neighbouring row
            int nc = dir[1]+j; // neighbouring column
            // boundary conditions
            if(nr>=0 && nr<m && nc>=0 && nc<n){
                if(board[nr][nc] == 1 || board[nr][nc] ==2){
                    count++;
                }
            }
        }

        return count;
    }


}

//board is infinite
// From an infinite board we are taking alive cells alone and for these alive celle we are going over the neighbours 
// and we are counting the number of alive cells to these neigbours. These new set of alive cells will be provide into infinite board