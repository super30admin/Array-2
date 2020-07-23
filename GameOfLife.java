
//Time Complexity :O(m*n)  matrix(m,n)
//Space Complexity:O(1)
/*Approach
Inplace changing the state and keeping numbers to remember the previous state
 0 -> 1 is 2 and 1 -> 0 is 3
 3 is counted as live in previous state and 2 is counted as dead in previous state
-Applying conditions by checking total number of live neighbours as given in question
1.Any live cell with fewer than two live neighbors dies, as if caused by under-population.
2.Any live cell with two or three live neighbors lives on to the next generation.
3.Any live cell with more than three live neighbors dies, as if by over-population..
4.Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

 */
public class GameOfLife{
    static int dirs[][] = new int[][]{{1,-1},{-1,1},{1,1},{-1,-1},{1,0},{-1,0},{0,1},{0,-1}};

    public static void gameOfLife(int[][] board){
        for(int i = 0; i < board.length;i++){
            for(int j = 0; j < board[0].length;j++){
                
                int live = 0; //to count number of live neighbours
                
                for(int dir[]: dirs){
                    if((i+dir[0])<0 || (i+dir[0]) >= board.length || (j+dir[1])<0 ||(j+dir[1])>=board[0].length){
                        continue;
                    }
                    if(board[i+dir[0]][j+dir[1]] == 1 || board[i+dir[0]][j+dir[1]] == 3){
                        live++;
                    }
                            
                }
                if(board[i][j] == 1 && (live < 2 || live >3)){
                    board[i][j] = 3;
                }
                if(board[i][j] == 0 && live==3){
                    board[i][j] = 2;
                }
                        
            }
        }
        
        
        for(int i=0; i < board.length; i++){
            for(int j =0 ; j < board[0].length; j++){
                if(board[i][j] == 3) board[i][j] = 0;
                if(board[i][j] == 2) board[i][j] = 1;
            }
        }
    }
    
    public static void main(String args[]){
        int[][] board = new int[][]{
            {0,1,0},
            {0,0,1},
            {1,1,1},
            {0,0,0}
        };
          
        gameOfLife(board);
        for(int i = 0; i < board.length;i++){
            for(int j = 0; j < board[0].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println("\n");
        }
    }
    
}