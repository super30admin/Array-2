import java.util.*;
//Problem1
// Time Complexity : O(n)
// Space Complexity : O(1)
class Solution1 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        
        List<Integer> output = new ArrayList<>();
        
        for(int i = 0 ; i < nums.length; i++){
            
            //getting the absolute value of the element at that index i
            int index = Math.abs(nums[i]) - 1;
            
            //and then multiply that value with -1
            //this way only the elements that are not present in the array,
            //the elements will be positive on those indices
            if(nums[index] > 0){
                nums[index] *= -1;
            }
        }
        
        //get the positive elemnts in the array and add the indices that they are present
        //to the answer
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] > 0){
                output.add(i+1);
            }
        }
        return output;
    }
}

//Problem2
// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution2 {
    public List<Integer> findMaxMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        } 

        List<Integer> output = new ArrayList<>();

        int[] pairs = new int[2];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int tempMax = 0;
        int tempMin = 0;

        for(int i = 0; i < nums.length; i = i+2){  

            //split the array into pairs and then compare 
            pairs[0] = nums[i];
            if(i+1 < nums.length){
                pairs[1] = nums[i +1];
            }
            if(i+1 < nums.length){
                if(pairs[1] == nums[i+1]){
            
                    if(pairs[0] <= pairs[1]){
                        tempMin = pairs[0];
                        tempMax = pairs[1];
                    }
                    else{
                        tempMin = pairs[0];
                        tempMax = pairs[1];
                    }
                    if(tempMin <= min){
                        min = tempMin;
                    }
        
                    if(tempMax >= max){
                        max = tempMax;
                    }
                }
            }
            else{
                if( pairs[0] <= min ){
                    min = pairs[0];
                }

                else if(pairs[0] >= max){
                    max =pairs[0];
                }
            }
        }
        output.add(min);
        output.add(max);

        return output;

    }
}


//Problem3
// Time Complexity : O(m*n)
// Space Complexity : O(1)

class Solution3 {
    public void gameOfLife(int[][] board) {
        if(board.length == 0 || board[0].length == 0 || board == null){
            return;
        }
        
        int n =  board.length; int m = board[0].length;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){

                //count = number of living cells around the current cell
                int count = countLives(board, i, j , n, m);
                
                //conditions for an alive cell to die
                if(board[i][j] == 1 && (count > 3 || count < 2)){

                    //2 --> living cell turned dead
                    //(beacuse we need to keep track of the original state)
                    board[i][j] = 2;
                }

                //conditions for a dead cell to come back to life
                else if(board[i][j] == 0 && (count == 3)){

                    //3 --> dead cell turned alive
                    //(beacuse we need to keep track of the original state)
                    board[i][j] = 3;
                }
            }
        }
        
        //loop to change all ths 2s to 0 and all the 3s to 1
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
               }
                if(board[i][j] == 3){
                    board[i][j] = 1;
               }
            }
        }
    }
    
    //function to calculate the count(number of living cells around the current cell)
    private int countLives(int[][] board, int i, int j, int n, int m){

        //all the 8 possible directions from 1 point
        int dirs[][] = {{1,-1}, {1,0},{1,1},{0,-1}, {0,1},{-1,-1},{-1,0},{-1,1}};
        int count = 0;

        //loop to iterate through all the 8 directions
        for(int[] dir : dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            
            
            if(/* condition to check if the direction is inside the bounds */
            r>=0 && r<n && c>=0 && c<m && 
            /* condition to check if the cell in that particular direction is alive*/
            (board[r][c] == 1 || board[r][c] == 2)){
                
                //if it is alive then increase the count
                count ++;
            }
        }
        return count;
    }
}