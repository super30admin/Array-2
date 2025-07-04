// TC- O(m*n)
// SC- O(1) We use temp numbers to modify same 2d array to save space. Assuming that we don't consider returning board as extra sapce its constant.

// To solve this we iterate through board and count live neighbors for position
// then based on rules we make it live or dead.
// To do this we utilize directional array and update temp numbers to modify same 2d array to save space.
class GameOfLife {
    int m,n;
    public void gameOfLife(int[][] board) {
        
        if(board==null || board.length==0){
            return;
        }

        m = board.length;
        n = board[0].length;

        for(int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                int liveNeighborCount = countLiveNeighbor(board, i, j);
                if(board[i][j]==1){
                    if(liveNeighborCount<2 || liveNeighborCount>3){
                        board[i][j]=2; // when we change 1->0, we replace with 2
                    }
                    
                }
                else{
                    if(liveNeighborCount==3){
                        board[i][j]=3; // when we change 0->1, we replace with 3
                    }

                }
            }
        }

        for(int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if(board[i][j]==2){
                    board[i][j]=0;
                }
                else if(board[i][j]==3){
                    board[i][j]=1;
                }
            }
        }
    }

    // method to count live neighbors which also consider 2 and 3 as mentioned above
    private int countLiveNeighbor(int[][] board, int i, int j){
        int[][] dirs = {{-1,-1}, {-1,0}, {-1, 1}, {0, -1}, {0, 1}, {1,-1}, {1,0}, {1,1}};
        int count=0;
        for(int[] dir: dirs){
            int nr = i + dir[0];
            int nc = j + dir[1];

            if(nr>=0 && nr<m && nc>=0 && nc<n && (board[nr][nc]==1 || board[nr][nc]==2) ){
                count++;
            }
        }

        return count;
    }
}