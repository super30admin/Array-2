//TC - O(m*n)
//SC -O(1)
// Passed all Test cases on Leetcode : Yes
// Any issues faced while executing the code : No
public class Problem2 {
    int m,n;
    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int countLiveNeighbors = CountLiveNeighbors(board,i,j);
                if(board[i][j] == 1){
                    if(countLiveNeighbors < 2 || countLiveNeighbors >3){
                        board[i][j] = 2;
                    }
                }else {
                    if(countLiveNeighbors == 3){
                        board[i][j] = 3;
                    }
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }
                if(board[i][j] == 3){
                    board[i][j] = 1;
                }
            }
        }
    }

    public int CountLiveNeighbors(int[][] board, int row, int col){
        int count=0;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1,},{-1,1},{1,-1},{1,1}};
        for(int[] dir : dirs){
            int nr = row + dir[0];
            int nc = col + dir[1];
            if(nr >= 0 && nr<m && nc >=0 && nc<n){
                if(board[nr][nc] == 1 || board[nr][nc] == 2){
                    count++;
                }
            }
        }
        return count;

    }
}
