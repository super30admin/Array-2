// Time Complexity : //TC O(M*N)
// Space Complexity : //SC O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Problem2 {
    //TC O(M*N)
    //SC O(1)
    public void gameOfLife(int[][] board) {



        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){

                int liveCount = getLiveCount(board, i,j);
                int curr = board[i][j];

                if(curr ==1 && liveCount<2){
                    //live to dead 3
                    board[i][j] = 3;
                }else if(curr ==1 && (liveCount  == 2 || liveCount ==3)){
                    // live to live so nothing needs to be done
                    // board[i][j] = 2;
                }else if(curr == 1 && liveCount >3){
                    //live to dead
                    board[i][j] = 3;
                }else if(curr ==0 && liveCount == 3){
                    //dead to live ==2
                    board[i][j] = 2;
                }
            }
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){


                int curr = board[i][j];

                if(curr ==3 ){
                    //dies so we set it to 3 that means we have visited it and it is dead
                    board[i][j] = 0;
                }else if(curr == 2){
                    // 2 for visisted and is live in nxt generation
                    board[i][j] = 1;
                }
            }
        }
    }

    private int getLiveCount(int[][]board,int r,int c){

        int[][] dir = {{0,-1},{0,1},{-1,-1},{-1,0},{-1,1},{1,-1},{1,0},{1,1}};
        int m = board.length-1;
        int n = board[0].length-1;

        int liveCnt = 0;
        for(int[] rc: dir){
            int nr = rc[0]+r;
            int nc = rc[1]+c;

            if(nr>=0 && nr <= m && nc>=0 && nc<=n){

                if(board[nr][nc] == 1 || board[nr][nc] == 3){
                    liveCnt++;
                }
            }
        }
        return liveCnt;
    }

}