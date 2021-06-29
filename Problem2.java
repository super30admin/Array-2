// Time Complexity : O(N*M)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    // direction array - 8 directions as mentioned in question
    int[][] dir={{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},                        {-1,1}};

    // make 1 to 2 if live cells less then 2 and greater than 3
    // make 0 to 3 if live neighbors == 3
    // we are making it 2 & 3 as we can do % operation and store in         // board at last
    public void gameOfLife(int[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){

                int live=0;
                for(int[] d:dir){
                    if((i+d[0])<0||(i+d[0])>=board.length||(j+d[1])<0||(j+d[1])>=board[0].length){
                        continue;
                    }
                    if(board[i+d[0]][j+d[1]]==1||board[i+d[0]][j+d[1]]==2){
                        live++;
                    }
                }
                if(board[i][j]==1&&(live<2||live>3)){
                    board[i][j]=2;
                }
                if(board[i][j]==0&&live==3){
                    board[i][j]=3;
                }
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j]=board[i][j]%2;
            }
        }
    }
} 