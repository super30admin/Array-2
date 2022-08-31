/* Time Complexity: O(M*N); Space:O(1)
Space Complexity:O(1*/)
    public void gameOfLife(int[][] board) {

        for(int i = 0; i < board.length; i++){
            int leftLive = 0, midLive = 0, rightLive = 0;

            for (int j = 0; j < board[0].length; j++){
                leftLive = midLive;
                midLive = rightLive;

                if (j == 0){
                    leftLive = 0;
                    midLive = 0;
                    if (i - 1 >= 0) {
                    
                        if (board[i - 1][j] == 1 || board[i - 1][j] == -1 ) midLive++;
                    }
                    if (i + 1 < board.length) midLive += (board[i + 1][j] == 1 ? 1 : 0);
                    midLive += (board[i][j] == 1 ? 1 : 0);
                }

             
                rightLive = 0;
                if (j + 1 < board[i].length) {
                    rightLive += board[i][j + 1] == 1 ? 1 : 0;
                    if (i - 1 >= 0) {
                        
                        if (board[i - 1][j+1] == 1 || board[i - 1][j+1] == -1 ) rightLive++;
                    }
                    if (i + 1 < board.length) rightLive += board[i + 1][j + 1] == 1 ? 1 : 0;
                }
               
                int totalLive = leftLive + midLive + rightLive;
                
                if (board[i][j] == 1){
                    totalLive--; 
                    if (totalLive < 2 || totalLive > 3) board[i][j] = -1; 
                }else{
                    if (totalLive == 3) board[i][j] = 2; 
                }
            }

            
            if (i-1 >= 0) {
                for (int j = 0; j < board[0].length; j++)
                    board[i - 1][j] = board[i - 1][j] >= 1 ? 1 : 0;
            }
        }

       
        for (int j = 0; j < board[0].length; j++)
            board[board.length - 1][j] = board[board.length - 1][j] >= 1 ? 1 : 0;
    }