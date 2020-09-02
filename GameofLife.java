// Time Complexity: O(m*n) row*col
// Space Complexity: O(1)

public class GameofLife {
     int[][] board;
     int[][] directions;
    
    public void gameOfLife(int[][] board) {
        
        directions = new int[][]{{0,-1}, {-1,-1}, {-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}};

        this.board = board;
        //0->1 == 2
        //1->0 == 3

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                int liveNeighbor = count(i, j);
                if(board[i][j] == 1){
                    if(liveNeighbor<2 || liveNeighbor>3)
                        board[i][j] = 3;
                }
                else{
                    if(liveNeighbor == 3)
                        board[i][j] = 2;
                }
            }
        }

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j]==2)
                    board[i][j] = 1;
                else if(board[i][j]==3)
                    board[i][j] = 0;
            }
        }

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }

    }

    private int count(int i, int j){
        int count = 0;

        for(int[] dir: directions){
            int i_new = i + dir[0];
            int j_new = j + dir[1];

            if(isValid(i_new, j_new)){
                count++;
            }
        }
        return count;
    }

    private  boolean isValid(int i, int j){
        return (i>=0 && j>=0 && i<board.length  && j<board[i].length && (board[i][j] == 1 || board[i][j] == 3));
    }

    public static void main(String[] args) {
        GameofLife g = new GameofLife();
        int[][] ar = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        g.gameOfLife(ar);
    }
}