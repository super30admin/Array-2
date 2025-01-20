//TC: O(r*c)
//SC: O(1)
//approach: using temporary states to change the matrix inplace

public class GameOfLife {
    int r;
    int c;

    public void gameOfLife(int[][] board) {
        r=board.length;
        c=board[0].length;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                int liveNeighbors = countLiveNeighbors(board, i, j);
                if(board[i][j] == 0){
                    if(liveNeighbors == 3)
                        board[i][j] = 3;
                }else if(board[i][j] == 1){
                    if(liveNeighbors < 2 || liveNeighbors > 3)
                        board[i][j] = 2;
                }
            }
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(board[i][j] == 2)
                    board[i][j] = 0;
                if(board[i][j] == 3)
                    board[i][j] = 1;
            }
        }
    }

    int countLiveNeighbors(int[][] board, int i, int j){
        int count = 0;
        int[][] d ={{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};
        for(int[] dir: d){
            int nr = i+dir[0];
            int nc = j+dir[1];
            if(nr>=0 && nr<r && nc>=0 && nc< c && (board[nr][nc] == 1 || board[nr][nc] == 2)) count++;
        }
        return count;
    }
}