class Solution {
    // 0-->1 board=3 (dead to alive)
    // 1-->0 board=2 (alive to dead)
    // 1-->1 board=1(alive to alive)
    public static int counter(int i,int j ,int[][] board){
        int count=0;
        // all 8 cordinates--
        int [][] direction ={{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}} ;
        for(int [] dir :direction){
            int x =i+dir[0];
            int y =j+dir[1];
            if(x>=0 && y>=0 && x<board.length && y<board[0].length){
                if(board[x][y] ==2){
                    count ++;
                }if(board[x][y] == 1 ){
                    count ++;
                }
            }
        }
        return count;
    }
    public void gameOfLife(int[][] board) {
        int output[][]  = new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int neighbour =counter(i,j,board);
                //Rule 1
                if(board[i][j]==1 && neighbour<2)
                    board[i][j]=2;
                //Rule 2
                else if(board[i][j]==1 && (neighbour==2 || neighbour==3))
                    board[i][j]=1;
                //Rule 3
                 else if(board[i][j]==1 && neighbour>3)
                    board[i][j]=2;
                //Rule 4
                 else if(board[i][j]==0 && neighbour==3)
                    board[i][j]=3;
            }
         }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j]%=2;
            }
        }
        
    }
}