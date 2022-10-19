class Solution {
    private static final int
        d=0,
        l=1,
        dl=2,
        ld=3;
    private static final int[][] directions = new int[][]{
        {-1,0},
        { 1,0},
        { 0,-1},
        {0,1},
        {-1,-1},
        {-1,1},
        { 1,-1},
        { 1,1}
    };
    public void gameOfLife(int[][] board) {

        int m=board.length;
         int n=board [0].length;
        for(int i=0; i<m; ++i) {
            for(int j=0; j<n; ++j) {
            int aliveNeighbors = liveNeighbors (board, i, j);
            if(board[i][j] == l) {
                if(aliveNeighbors<2 || aliveNeighbors>3) {
                        board[i][j]=ld;
                }
            } else {if(aliveNeighbors==3) {
                board[i][j] = dl;
                }
                }
                }
                }

        
                for(int i=0; i<m; ++i) {
                    for(int j=0; j<n; ++j) {
                        if(board[i][j]==dl) {
                            board[i][j] = l;
                    } else if(board[i][j]==ld){
                            board[i][j]= d;
                        }
                        
                    }
                    }
                    }

                    private int liveNeighbors(int[][] board, int i, int j) {
                        int m=board.length;
         int n=board [0].length;
                    int aliveCount = 0;
                    for(int[] direction : directions) {
                    int nI = i + direction[0];
                    int nJ = j + direction[1];
                        if(nI>=0 && nI<m && nJ>=0 && nJ<n)
                        if(board [nI][nJ] == l || board[nI][nJ]==ld) {
                        ++aliveCount;
                        }
                        }
                        return aliveCount;
                    }
                    }
//tc=O(n)
//sc=O(1)
