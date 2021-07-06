// Time Complexity : O(n)
// Space Complexity : O(1) since we are returning list as an answer
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

//prob 1
 public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> list= new ArrayList<Integer>();
        if (nums.length <=1) {
            return list;
        }
        
        if (nums.length==2) {
            
            if(nums[0]==2 && nums[1]==2){
             list.add(1);
            return list;
            }
        }
        
        Boolean hasOne=false;
        
         int i;
                nums[0]=-nums[0];
            if(nums[0]==1){
                hasOne=true;
                    }
            for (i = 0; i < nums.length; i++)
            {
                if(nums[i]==1 || nums[i]==-1){
                    hasOne=true;
                }
                if (nums[Math.abs(nums[i])-1] >= 0)
                    nums[Math.abs(nums[i])-1] = -nums[Math.abs(nums[i])-1];
                
            }
        if(hasOne==false) {
            list.add(1);
        }
        
        for (int j=0; j < nums.length; j++) {
            
            if (nums[j] > 0) {
                list.add(j+1);
            }
        }
        
        return list;   
    }

// prob 2
// Time Complexity : n/ n/2 --> O(n) , where n is the len of the array. n/2 represents possible num of pairs
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

    static class Pair {

        int min;
        int max;
    }

    static Pair getMinMax(int arr[]) {
        Pair minMax = new Pair();

        int idx=0;
        if(arr.length%2==0) { // if it is of even len, then a paired comparison is possible till end without getting outOfBnd error
            if(arr[0] > arr[1]){
                minMax.max = arr[0];
                minMax.min = arr[1];
            }else{
                minMax.max = arr[1];
                minMax.min = arr[0];
            }
            idx += 2; // moving on to the next pair

        }else{ // in case of odd numbered array, we are assuming min max to be the 0th element, incrementing by one and then taking pairs to compare 
            minMax.max = arr[0];
            minMax.min = arr[0];
            idx+=1;
        }

        while (idx < arr.length-1){
            if(arr[idx] > arr[idx+1]){
                if(arr[idx] > minMax.max){
                    minMax.max = arr[idx];
                }
                if(arr[idx+1] < minMax.min){
                    minMax.min = arr[idx+1];
                }
            }else{
                if(arr[idx+1] > minMax.max){
                    minMax.max = arr[idx+1];
                }
                if(arr[idx] < minMax.min){
                    minMax.min = arr[idx];
                }
            }
            idx+=2;
        }


       return minMax;
    }

//prob 3
// Time Complexity : O(n*m) where n is the num of rows and m represents columns
// Space Complexity : O(n*m) where n is the num of rows and m represents columns
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    
    private int countAlive(int[][] board, int i, int j){
        // look for edfge cases
        // look for all 8 directions;
        // count alive
        int counter = 0;
        //up
        if(i-1 >= 0 && board[i-1][j]==1){
            counter++;
        }
        //down
        if(i+1 < board.length && board[i+1][j]==1){
            counter++;
        }
        //left
        if(j-1 >=0 && board[i][j-1]==1){
            counter++;
        }
        //right
        if(j+1 < board[i].length && board[i][j+1]==1){
            counter++;
        }
        //upper left
        if(i-1 >=0 && j-1 >=0 && board[i-1][j-1]==1){
            counter++;
        }
        //upper right
        if(i-1 >=0 && j+1 < board[i].length && board[i-1][j+1]==1){
            counter++;
        }
        //lower left
        if(i+1 < board.length && j-1 >=0 && board[i+1][j-1]==1){
            counter++;
        }
        //lower right
        if(i+1 < board.length && j+1 < board[i].length && board[i+1][j+1]==1){
            counter++;
        }
        
        return counter;
    }
    public void gameOfLife(int[][] board) {
        
        int [][] result = new int[board.length][board[0].length];
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j < board[i].length; j++){
                int alive = countAlive(board, i, j);
                // System.out.println(alive);
                if (alive < 2 && board[i][j]==1){
                        result[i][j]=0;
                    }else if(alive > 3 && board[i][j]==1){
                        result[i][j]=0;
                    }else if( board[i][j]==0 && alive ==3 ){
                        result[i][j]=1;
                    }else if(board[i][j]==1 && alive == 2 || alive == 3){
                            result[i][j] = 1;
                    }
                }
        }
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                // System.out.println(result[i][j]);
                board[i][j]=result[i][j];
            }
        }
    }
}













