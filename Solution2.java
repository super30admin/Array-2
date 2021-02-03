// Time Complexity : O(MN)
// Space Complexity : O(MN)
// Did this code successfully run on Leetcode : Y
// Any problem you faced while coding this : N


// Your code here along with comments explaining your approach

class Solution {
    public void gameOfLife(int[][] board) {

        int M = board.length;
        int N = board[0].length;

        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){


                int n = getAliveNeighbours(board, i, j);

                if(board[i][j]==1){
                    if(n<2 || n>3){
                        board[i][j]=-1; //was alive, is dead
                    }
                }else{
                    if(n==3){
                        board[i][j]=2; //was dead, is alive
                    }
                }

            }
        }


        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(board[i][j]>0){
                    board[i][j]=1;
                }else{
                    board[i][j]=0;
                }
            }
        }

    }

    public int getAliveNeighbours(int[][] board, int i, int j){
        int count = 0;
        int[] dx = {0,1,1,1,0,-1,-1,-1}; //rotate in 8 directions
        int[] dy = {-1,-1,0,1,1,1,0,-1};

        for(int r=0;r<8;r++){

            int x = i+dx[r];
            int y = j+dy[r];

            if(x>=0 && y>=0 && x<board.length && y<board[0].length && Math.abs(board[x][y])==1){
                count++;
            }
        }

        return count;
    }
}