/*Approach:
1. Temporary mark the live nodes 1 as 2 if converted to dead instead of 0
2. Temporary mark the dead nodes 0 as 3 if converted to live nodes instead of 1

alive->dead (1-> 2 ->0)
dead->alive (0 -> 3 -> 1)
*/
//Time:  O(m*n)
//Space: O(1)

class Solution {
    int dirs[][];
    int m,n;
    public void gameOfLife(int[][] board) {

        this.dirs=new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};

        this.m=board.length;
        this.n=board[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                int count=getCount(board,i,j);

                if(board[i][j]==1 && (count<2||count>3)){
                    board[i][j]=2;
                }
                else if(board[i][j]==0 && count==3){
                    board[i][j]=3;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(board[i][j]==2){
                    board[i][j]=0;
                }
                else if(board[i][j]==3){
                    board[i][j]=1;
                }
            }
        }

    }
    private int getCount(int board[][], int i, int j){ //return count of live cells

        int count=0;

        for(int dir[]:dirs){

            int r=i+dir[0];
            int c=j+dir[1];

            if(r>=0 && r<m && c>=0 && c<n){
                if(board[r][c]==1 || board[r][c]==2) count++;
            }
        }
        return count;
    }
}