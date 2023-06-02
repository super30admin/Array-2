class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<Integer>();
        List<Integer>result = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            int abs = Math.abs(nums[i]);
            if(nums[abs - 1] > 0){
                nums[abs - 1] *= -1;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i]<0){
                nums[i] *= -1;
            }else{
                result.add(i + 1);
            }
        }
        return result;
    }
}

class Solution {
    private int m;
    private int n;
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) return;
        m = board.length;
        n = board[0].length;
        for(int i = 0;i < m; i++){
            for(int j = 0; j < n; j++){
                int alive = countAlive(i,j,board);
                if(board[i][j] == 1 && (alive < 2 || alive > 3)){
                    board[i][j] = 2;
                }else if(board[i][j] == 0 && alive == 3){
                    board[i][j] = 3;
                }
            }
        }
        
       for(int i = 0;i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }else if (board[i][j] == 3){
                    board[i][j] = 1;
                }
            }
        }
    }
    
    int[][] dirs = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};//directional array boiler plate code
    private int countAlive(int i , int j,int[][] board){
        int alive = 0;
        for(int [] dir : dirs){
            int nr = i + dir[0];
            int nc = j + dir[1];
            if(nr >= 0 && nc >=0 && nr < m && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 2)){
                alive++;
            }
        }
        return alive;
    }
}
