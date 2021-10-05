// Time Complexity : O(r*c)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


public class gameOfLife {
    public void gameOfLife(int[][] board) {
        int [][]next=new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int []arr=count(board,i,j);
                if(board[i][j]==1 && arr[1]<2) next[i][j]=0;
                else if(board[i][j]==1 && arr[1]==2 || arr[1]==3) next[i][j]=1;
                else if(board[i][j]==1 && arr[1]>3) next[i][j]=0;
                else if(board[i][j]==0 && arr[1]==3) next[i][j]=1;
                else next[i][j]=board[i][j];

            }

        }
    
        for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    board[i][j]=next[i][j];
                }
            }

    }

    int []count(int board[][],int i,int j){ 
        int arr[] = new int[2];
        int dir[][] = new int[][]{{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}};
        for (int d[] : dir) {
            int r = i + d[0];
            int c = j + d[1];
            
            if(r < 0 || c < 0 || r >= board.length || c >= board[0].length) 
                continue;
            
            if (board[r][c] == 1) 
                arr[1]++;
            else 
                arr[0]++;
        }
        return arr;
    }
}
