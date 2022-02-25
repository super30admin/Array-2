//Time Complexity: O(m*n) m = row and n = column of matrix
//Space Complexity: O(1)
//runs successfully on leetcode
//didn't face any problems

public class GameOfLife289LeetCode {

    private int getLiveNeighboursCount(int[][] board, int i, int j){

        int m = board.length;               //row
        int n = board[0].length;            //column

        int[][] neighbours = {
                {-1, -1},   //upper left
                {-1, 0},    // up
                {-1, 1},    //upper right
                {0, -1},    //left
                {0, 1},     //right
                {1, -1},    //lower left
                {1, 0},     //lower
                {1, 1}      //lower right
        };
        int liveNeighbours = 0;

        for(int[] temp: neighbours){

            int x = i + temp[0];                                    // getting each of the 8 neighbours one by one
            int y = j + temp[1];

            if(x>=0 && x<m && y<n && y>=0){                         //hadling the edge case

                if(board[x][y] == -2 || board[x][y] == 1){          // check if neightbour is alive
                    liveNeighbours++;
                }
            }
        }

        return liveNeighbours;
    }


    public void gameOfLife(int[][] board) {


        int m = board.length;                                       //row
        int n = board[0].length;                                    //column


        // current      next   encodingUsed
        //   0      to   1   =>    -1
        //   1      to   0   =>    -2
        //   0      to   0   =>     0
        //   1      to   1   =>     1

        for(int i=0;i<m; i++){

            for(int j=0; j<n;j++){

                int liveNeighbours = getLiveNeighboursCount(board, i , j);//calculating live neighbour count for each of the element
                if(board[i][j] == 0){                           //if element is dead
                    if(liveNeighbours == 3){                    //and liveneighbour is 3
                        board[i][j] = -1;                       //element is going to be alive in the next phase
                    }
                }
                else{                                           //if element is alive
                    if(liveNeighbours<2 || liveNeighbours>3){   //if neighbour count is less than 2 or grater than 3
                        board[i][j] = -2;                       //element is going to be dead in the next phase
                    }
                }
            }
        }

        for(int i=0; i<m; i++){

            for(int j=0; j<n; j++){

                if(board[i][j] == -1){                          //element value is -1 means element will be alive in next phase

                    board[i][j] = 1;
                }
                else if(board[i][j] == -2){                     //element value is -2 means element will be dead in next phase
                    board[i][j] = 0;
                }
            }
        }
    }
}


