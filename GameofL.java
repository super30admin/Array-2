//time complexity:O(m*n)
//space complexity:O(1)
public class GameofL {
        int m,n;
        public void gameOfLife(int[][] board)
        {
            if(board==null || board.length==0)
            {
                return;
            }
            m= board.length;
            n= board[0].length;
            // 2- live to dead
            //3- dead to live
            for(int i=0;i<m;i++)
            {
                for(int j=0;j<n;j++)
                {
                    int countliveneighbors= countliveNeighbors(board,i,j);
                    if(board[i][j]==1)
                    {
                        if(countliveneighbors<2 || countliveneighbors >3)
                        {
                            board[i][j]=2;
                        }
                    }
                    else
                    {
                        if(countliveneighbors==3)
                        {
                            board[i][j]=3;
                        }
                    }
                }
            }
            for(int i=0;i<m;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(board[i][j]==2)
                    {
                        board[i][j]=0;
                    }
                    else if(board[i][j]==3)
                    {
                        board[i][j]=1;
                    }
                }
            }
        }
        private int countliveNeighbors(int[][] board, int row, int col)
        {
            int count=0;
            int[][] dirs={{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
            for(int[] dir:dirs)
            {
                int nr=row+dir[0];
                int nc=col+dir[1];
                if(nr>=0 && nr<m && nc>=0 &&nc<n && (board[nr][nc]==1 ||board[nr][nc]==2))
                {
                    count++;
                }
            }
            return count;
        }
        public static void main(String[] args)
        {
            GameofL g=new GameofL();
            int[][]board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
            g.gameOfLife(board);
            int m= board.length;
            int n= board[0].length;
            for(int i=0;i<m;i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
        }
    }

