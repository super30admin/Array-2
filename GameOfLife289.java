//time complexity:  O(mxn)
//space complexity : O(1)
// leet code execution : successful
//Steps: 1) created array of elements that'll help to navigate neighbours for given element dx and dy
//        2) to check for valid neighbours to a given element, an helper function is used to verify whether boundary conditions.
//        3) since we've to re-map elements back to same array, if there's any element change from dead to alive mark it as 2. if it's dead from live mark as -1
//        4) at this point iterate the array and apply the game of life rules
//        5) once re-rrun the array and re-map values back to normal.
class GameOfLife289{

    //i-1j-1,i-1j,i-1j+1
    //ij-1,ij,ij+1
    //i+1j-1,i+1j,i+1j+1

    int [] dx = {-1,-1,-1,0,1,1,1,0};
    int [] dy = {-1,0,1,1,1,0,-1,-1};

    private int countNeighbours(int [][] board, int i, int j){
        int neighbours = 0;
        System.out.println(board[i][j]);
        for(int k=0; k<8;k++){
            int row = i+dx[k],col = j+dy[k];
            if(isValid(board,row,col)){
                if(board[row][col]== 1||board[row][col]== -1) {
                    System.out.println("nieghbours  -- > "+board[row][col]);
                    neighbours++;
                }
            }
        }
        System.out.println("Count "+neighbours);
        return neighbours;
    }

    // 0 1 0
    // 0 0 1
    // 1 1 1

    private boolean isValid(int[][] board, int row, int col) {
        return row>=0 && col >=0 && row<board.length && col < board[0].length;
    }

    public void gameOfLife(int[][] board) {

        if(board.length==0) return ;

        for(int i =0; i<board.length;i++){
            for(int j=0; j<board[0].length;j++){
                int count  = countNeighbours(board, i, j);

                if(board[i][j] == 1) {   //alive
                    if(count < 2 || count >3){
                        board[i][j] = -1;
                    }
                }
                    else {
                        if(count==3){
                            board[i][j]=2;
                        }
                    }
                
            }
        }

        //replace :2 -->1, -1--->0

        for(int i =0;i<board.length;i++){
            for(int j=0; j<board[0].length;j++){
                if(board[i][j]==2){
                    board[i][j]=1;
                }
                if(board[i][j] == -1){
                    board[i][j]=0;
                }
            }
        }

        for(int i =0;i<board.length;i++){
            System.out.println();
            for(int j=0; j<board[0].length;j++){
               System.out.print(board[i][j]);
                }
            }
        }
        

    


    public static void main(String[] args) {
        
        GameOfLife289 gl = new GameOfLife289();
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gl.gameOfLife(board);
        
    }
}