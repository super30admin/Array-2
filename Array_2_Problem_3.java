public class Array_2_Problem_3 {

    //Time Complexity : O(n*m) (Where m and n are dimensions of the given input)
    //Space Complexity : O(1)
    //Run successfully on leetcode
    //Problem: No problem

    //Here in order to save auxilary space, we will be using another 2 numbers to keep track of the previous number before changing it

    // 0 ----> 1  5
    // 1 ----> 0  6
    public static void gameOfLife(int[][] board) {
        //int[][] newBoard = new int[board.length][board[0].length];
        for(int i = 0; i < board.length; i ++)
        {
            for(int j = 0 ; j < board[0].length ; j ++)
            {
                int count = calculateNeighbours(board,i,j);

                if((board[i][j] == 1|| board[i][j]==6)  && (count <2 || count > 3))
                {
                    board[i][j] = 6;
                }
                else if(((board[i][j] == 0 || board[i][j] == 5) && count==3))
                {
                    board[i][j] = 5;
                }
            }
        }

        for(int i = 0 ; i < board.length ; i++)
        {
            for(int j = 0; j < board[0].length ; j ++)
            {
                if(board[i][j] == 5)
                {
                    board[i][j] = 1;
                }
                else if(board[i][j] == 6)
                {
                    board[i][j] = 0;
                }
            }
        }


    }
    private static int calculateNeighbours(int[][] board,int i,int j)
    {
        int[][] dirs ={{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{1,-1},{-1,1},{1,1}};
        int count=0;
        for(int[] d : dirs)
        {
            int x = i + d[0];
            int y = j + d[1];
            if(x>=0 && x<=board.length-1 && y>=0 && y<=board[0].length-1)
            {
                if(board[x][y] == 1 || board[x][y] == 6)
                {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0} };
        gameOfLife(arr);
    }
}
