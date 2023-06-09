/* Time complexity: O(M*N) where m and n are the matrix dimensions
Space complexity: O(M*N) maintained an additional matrix to capture the live neighbours for each index */

    public void gameOfLife(int[][] board) {

        int[][] countOfLive = new int[board.length][board[0].length];

        for(int row = 0; row < board.length ; row++) {
            for( int col = 0; col < board[0].length; col++){
                int liveCount = 0;
                int currRow = row;
                //current row

                for(int currCol = col - 1; currCol <= col + 1; currCol++){
                    if(currCol >= 0 && currCol < board[0].length && currCol != col) {
                        liveCount+= board[currRow][currCol];
                    }
                }
                //previous row
                if(row > 0) {
                    currRow = row - 1;
                    for(int currCol = col - 1; currCol <= col + 1; currCol++){
                        if(currCol >= 0 && currCol < board[0].length) {
                            liveCount+= board[currRow][currCol];
                        }
                    }
                }

                //next row
                if(row < board.length - 1) {
                    currRow = row + 1;
                    for(int currCol = col - 1; currCol <= col + 1; currCol++){
                        if(currCol >= 0 && currCol < board[0].length) {
                            liveCount+= board[currRow][currCol];
                        }
                    }
                }

                countOfLive[row][col] = liveCount;

            }
        }
        for(int row = 0; row < board.length ; row++) {
            for( int col = 0; col < board[0].length; col++) {
                if(board[row][col] == 0 && countOfLive[row][col] == 3){
                    board[row][col] = 1;
                }
                if(board[row][col] == 1 && (countOfLive[row][col] < 2 || countOfLive[row][col] > 3)){
                    board[row][col] = 0;
                }

            }
        }