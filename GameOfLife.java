public class GameOfLife {
    static int [][] neighbours_directions;
    static int m;
    static int n;

    private static int count(int[][] board, int i, int j){
        int aliveNeighbours = 0;

        for(int[] ndir: neighbours_directions){
            int nr = i + ndir[0];
            int nc = j + ndir[1];
            //boundry check
            if(nr >= 0 && nc >= 0 && nr < m && nc < n
                    && (board[nr][nc] == 1 || board[nr][nc] == 2)){
                aliveNeighbours++;
            }
        }
        return aliveNeighbours;
    }

    public static void gameOfLife(int[][] board) {
        if(board == null) return;
        m = board.length; n = board[0].length;
        neighbours_directions = new int[][]{
                {0,1},{0,-1},{-1,0},{1,0},
                {-1,-1},{-1,1},
                {1,-1},{1,1}
        };

        //to make alive cell dead- > change from 0 to 2
        //to make dead cell alive > change from 0 to 3
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //apply rules
                int countAlive = count(board, i , j);
                if(board[i][j] == 1 && (countAlive < 2 || countAlive > 3)){
                    board[i][j] = 2;
                }

                if(board[i][j] == 0 && countAlive == 3){
                    board[i][j] = 3;
                }
            }
        }
        //refresh board with changes i.e with only 0s and 1s
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 2) board[i][j] = 0;
                if(board[i][j] == 3) board[i][j] = 1;
            }
        }
    }

    public static void main(String[] args){
        int[][] board = new int[][]{
                {1,1},
                {1,0}};
        gameOfLife(board);

        System.out.println("After applying rules: ");
        for(int i = 0; i < m;i++){
            for(int j = 0; j < n; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
