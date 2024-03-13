//1->0 = -1
//0->1 = -2

//tc = o(m*n)
//sc = o(1)
class Solution {
    int[][] dirs = {{-1,-1},{-1,0},{-1,1},{0,1},{0,-1},{1,1},{1,-1},{1,0}};
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int countAlive = count(board,i,j);
                if(board[i][j] == 1 && (countAlive < 2 || countAlive > 3)){
                    board[i][j] = -1; // dies
                }
                else if(board[i][j] == 0 && countAlive == 3){
                    board[i][j] = -2; //becomes alive
                } 

            }
        }

        //return the board to its original state. 
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == -1){
                    board[i][j] = 0;
                }
                else if(board[i][j] == -2){
                    board[i][j] = 1;
                }

            }
        }


    }
//count alive (number of 1's in 8 directions')
    public int count(int[][] board, int row, int col){
        int count = 0;
        for(int[] dir:dirs){
            int nr = dir[0] + row;
            int nc = dir[1] + col;
            if(nr >= 0 && nc >= 0 && nr < board.length && nc < board[0].length){
                if(board[nr][nc] == 1 || board[nr][nc] == -1){
                    count ++;
                }
            }

        }
        return count;
    }


}