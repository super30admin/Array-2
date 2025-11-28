class Solution {
    //1. 1-> <2 -> 0 ---2
    //2. 1-> 2or3 -> 1
    //3. 1-> >3 -> 0 --2
    //4. 0-> ==3 -> 1 ---3
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,1},{1,-1}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int countAlives = countLives(board, dirs, i,j,m,n);
                if(board[i][j] == 0 && countAlives == 3){
                    board[i][j] = 3;
                }
                if(board[i][j] == 1 && (countAlives < 2 || countAlives > 3)){
                    board[i][j] = 2;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==2){
                    board[i][j] = 0; //new state
                }else if(board[i][j]==3){
                    board[i][j] = 1; //new state
                }
            }

        }

    }
    private int countLives(int[][] board, int[][] dirs, int i, int j, int m, int n){
        int count = 0;
        for(int[] dir:dirs){
            int nr = i + dir[0];
            int nc = j + dir[1];
            if(nr>=0 && nc>=0 && nr<m && nc<n && (board[nr][nc]==1 || board[nr][nc]==2)){
                count++;
            }
        }
        return count;
    }
}