//Find all numbers in a array
//Time Complexity o(n)
//space o(1)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        
        if(nums == null || nums.length ==0)
            return res;
        
        for(int i=0;i<nums.length;i++){
            int idx = Math.abs(nums[i])-1;
            if(nums[idx]>0)
                nums[idx]= nums[idx] * -1;
        }
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)
                res.add(i+1);
        }
        return res;
    }
}

//Time complexity o(mn), m - no of rows, n - no of cols
//space o(1)
class Solution {
    //1->0 -- 8
    //0->1 --7
    int rows;
    int cols;
    public void gameOfLife(int[][] board) {
        
        if(board == null || board.length ==0)
            return;
         rows = board.length; cols = board[0].length;
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                int lives = noOfLives(board,i,j);
                //live cell case
                if(board[i][j] == 1){
                    if(lives < 2 || lives > 3){
                        board[i][j] = 8;
                    }
                }
                else{ // dead cell case
                    if(lives == 3)
                    {
                        board[i][j] = 7;
                    }
                }
            }
        }
        for(int i=0;i<rows;i++)
        {
            for(int j=0; j<cols; j++)
            {
                if(board[i][j] == 8)
                    board[i][j] = 0;
                else if(board[i][j] == 7)
                    board[i][j] = 1;
            }
        }
    }
    
    private int noOfLives(int[][] board, int i, int j){
        int[][] dirs = {{-1,0},{0,-1},{0,1},{1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
        int count = 0;
        for(int[] dir: dirs){
            int row = i+dir[0];
            int col = j+dir[1];
            if(row >=0 && col>=0 && row<rows && col<cols && (board[row][col] == 1 || board[row][col] == 8))
                count++;
        }
        return count;
    }
}

//Finding min and max elements in a array
//Time complexity o(n)
//space complexity o(1)
// with 3 * n/2 comparisions where n is length of the array
class Solution{

    class Pair{
        int max;
        int min;
        Pair(){
            max=0;
            min=0;
        }
    }

    public Pair minAndMax(int[] nums){
        Pair pair = new Pair();
        pair.max = nums[0];
        pair.min = nums[0];

        for(int i=0; i < nums.length-1;i++){
            //comparing between taken nums
            //1st comparision
            if(nums[i]>nums[i+1]){
                //2nd comparision
                if(nums[i]>pair.max){
                    pair.max = nums[i];
                }
                //3rd comparison
                if(nums[i+1]<pair.min){
                    pair.min = nums[i+1];
                }
            }
            else{
                //2nd comparision
                if(nums[i+1]>pair.max){
                    pair.max = nums[i+1];
                }
                //3rd comparision
                if(nums[i]<pair.min){
                    pair.min = nums[i];
                }
            }
        }
        return pair;
    }
}


//One Solution, but in worst case it will take > 2*(N-2) comparisions

class Solution{

    class Pair{
        int max;
        int min;
        Pair(){
            max=0;
            min=0;
        }
    }
    public Pair minAndMax(int[] nums){
        if(nums == null || nums.length == 0)
            return new Pair();
        Pair pair = new Pair();
        if(nums.length == 1)
        {
            pair.max = nums[0];
            pair.min = nums[0];
            return pair;
        }

        if(arr[0]>arr[1]){
            pair.max = nums[0];
            pair.min = nums[1];
        }
        else{
            pair.max = nums[1];
            pair.min = nums[0];
        }
        for(int i=2;i<nums.length;i++){
            if(arr[i]>pair.max)
            {
                pair.max = arr[i];
            }
            else if(arr[i]<pair.min)
            {
                pair.min = arr[i];
            }
        }
        return pair;
    }
}