/* Approach1: 
1. We will be traversing through the matrix, checking neighbhor elements. Checking for all the rules. 
2. We will be using a new matrix to store the new live or dead nodes and retruning the new matrix. 

Time complexity: O(N*N)
Space complexity: O(1)
*/
class GameOfLife {
    public void gameOfLife(int[][] board) {
        int i; int j;
        int neighbhorCount;
        for(i=0; i<=board.length-1; i++)
        {
            for(j=0; j<=board[0].length-1;j++)
            {
                neighbhorCount = getNumberOfLiveNeighbors(board, i , j);
                //live node with less than 2 or more than 3 neighbhors has to die
                if(board[i][j]==1 && (neighbhorCount<2 || neighbhorCount>3))
                    board[i][j] = -1;
                //dead node with exactly 3 neighbhors should be alive 
                else if(board[i][j]==0 && neighbhorCount==3)
                    board[i][j] = 2;
            }
        }
        for(i=0; i<=board.length-1; i++)
        {
            for(j=0; j<=board[0].length-1;j++)
            {
                if(board[i][j] == -1)
                    board[i][j] = 0;
                else if(board[i][j] == 2)
                    board[i][j] = 1;
            }
        }
    }

    private int getNumberOfLiveNeighbors(int[][] board, int j, int k)
    {
        int count=0;
        int neighbhorRow;
        int neighbhorColumn;
        int[][] directions = new int[][]{
            {-1,-1},  //diagonallly-left-up
            {1,0},    //direcly above
            {-1,1},   //diagonally-right-up
            {0,-1},   //left
            {0,1},    //right
            {1,-1},   //diagonally-left-down
            {-1,0},    //directly below
            {1,1}     //diagonally-right-down
        }; 
        //Check the neighbhors
        for(int[] direction : directions)
        {
            neighbhorRow = j+direction[0];
            neighbhorColumn = k+direction[1];
            if((neighbhorRow>=0 && neighbhorRow <=board.length-1) && (neighbhorColumn>=0 && neighbhorColumn<=board[0].length-1))
            {
                //check -1 as well as the node was alive before
                if(board[neighbhorRow][neighbhorColumn]==1 || board[neighbhorRow][neighbhorColumn]==-1)
                    count += 1;
            }
        }
        return count;
    }
}