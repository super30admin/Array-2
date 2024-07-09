// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//Find All Numbers Disappeared in an Array
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        for(int i=0; i < n; i++){
            int currNum = Math.abs(nums[i]);//take the absolute value of number
            int idx = currNum - 1;
            if(nums[idx] > 0){//if number is present go to its index make the number -ve for reference
                nums[idx] *= -1;
            }

        }
        for(int i =0; i < n; i++){//iterte through array to find +ve number locations
            if(nums[i] < 0){//those are the numbers missing
                nums[i] *= -1;//this is to change the numbers to their original positive values
            } else{
                result.add(i+1);
            }
        }
        return result;
    }
}

//Game of life

// Time Complexity :O(m*n)
// Space Complexity :O(1)

class Solution {
    public void gameOfLife(int[][] board) {
        // 0 --> 1  3
        //1--> 0  4
        int m = board.length;
        int n = board[0].length;
        int [][] dirs = new int[][]{{0,1}, {1,0},{0,-1},{-1,0}, {-1,-1},{-1, 1},{1, -1},{1,1}};
        for(int i=0; i < m; i++){
            for( int j = 0; j < n; j++){
                int alives = countAlive(board, i,j, dirs);
                if(board[i][j] == 1){
                    //rule 1 and rule 3
                    if(alives > 3 || alives < 2){
                        board[i][j] = 4;
                    }
                } else{
                    if(alives == 3){
                        board[i][j] = 3;
                    }
                }

            }
        }
        for(int i = 0; i < m; i++){
            for(int j=0; j <n; j++){
                if(board[i][j] == 3){
                    board[i][j] =1;
                }
                if(board[i][j]== 4){
                    board[i][j] = 0;
                }
            }
        }

    }
    private int countAlive(int[][] board, int r, int c,int [][] dirs){
        int count = 0;
        for(int [] dir: dirs){
            int nr = r+dir[0];
            int nc = c+dir[1];

            //bounds check
            if(nr >= 0  && nr < board.length && nc >= 0 && nc < board[0].length && (board[nr][nc] == 1 || board[nr][nc] == 4)){
                count++;
            }
        }
        return count;
    }

}


