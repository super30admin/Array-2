/** time complexity : O(m*n) where m is the number of rows and n is the number of columns in the board.
 * space complexity : O(1)
 * executed on leetcode: yes
 * approach: let dead state of a cell be 0 and live state be 1
let n be number of live neighbours
if n<2 : cell dies  (1 becomes 0)
if 2<=n<=3 : cell survives ( 1 stays 1 if cell was already alive and 0 remains 0 because it is already dead)
if n>3 cell dies
if n==3 , dead cell live ( 0 becomes 1)
to solve it in place, we need to store certain numbers in a cell which could indicate both previous and present state after a rule is applied

0 becomes 1 => +2
1 becomes zero => -2
 
if we dont do this, we may need another array which wont lead to O(1) space complexity

**/



class game {
    public void gameOfLife(int[][] board) {
        int[][] dir = new int[][]{{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
        for(int i=0;i<board.length;++i)
        {   
            for(int j=0;j<board[0].length;++j)
            {  int count = 0;
               for(int[] d : dir)
               {
                   if((i+d[0]<0) || (i+d[0]>=board.length) || (j+d[1]<0) || (j+d[1]>=board[0].length))
                   {
                       continue; //these conditions mean that the index doesnt exist on the board (out of bounds element)
                   }
                   if(board[i+d[0]][j+d[1]]==1 || board[i+d[0]][j+d[1]]==-2) count++;
               }
                if(count==3 && (board[i][j]==0)) board[i][j] = 2; //change from zero to 1
                if((count<2 || count>3) && (board[i][j]==1)) board[i][j] = -2; //change from 1(previous state) to zero(present state)
        
                
            }
        }
        for(int i=0;i<board.length;++i)
        {
            for(int j=0;j<board[0].length;++j)
            {
                if(board[i][j]==-2) board[i][j] = 0;
                if(board[i][j]==2) board[i][j] = 1;
            }
        } 
       
    }
    public void print(int[][] board)
    {
        for(int i=0;i<board.length;++i)
        {   
            for(int j=0;j<board[0].length;++j)
            {
                System.out.print(board[i][j]+ " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n"); 
    }
    public static void main(String[] args) {
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        game obj = new game();
        System.out.println("initial state:\n");
        obj.print(board);
        obj.gameOfLife(board);
        System.out.println("new state:\n");
        obj.print(board);
        
    }
}