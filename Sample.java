//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            int index = Math.abs(nums[i]) - 1;  // calculating the index for current value
            // value may have been marked -ve already so taking  absolute
            if(nums[index] > 0)
                nums[index] *= -1; // marking that we have a value for that index by negating it
   
        }
        
         for(int i=0;i<nums.length;i++)
        {
             if(nums[i] > 0) // finding values that havent been negated
               list.add(i+1); // value for that index was not found so return the value  = index + 1
         }
        
        return list;
    }
}

//Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Running on eclipse
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach


class Min_Max {
    public static void findMinMax(int[] arr)
    {
      int max = Integer.MIN_VALUE;
      int min = Integer.MAX_VALUE;
      int big = -1; 
      int small = -1;
      
      for(int i=0;i<arr.length-1;i++)
      {
       
        
        //pair comparsion reducing 2n comparsion to 3n/2 i.e 1.5n
        if(arr[i]< arr[i+1]) // 1st comparsion
        {  
          big = arr[i+1]; 
          small = arr[i];
        }
        else
        {
          big = arr[i];
          small = arr[i+1];
        }
        
        if(max < big) // 2nd comparsion
          max = big;
        
        if(min > small) // 3rd comparsion
          min = small;
        
      }
      
      System.out.println("Max:" + max);
      System.out.println("Min:" + min);
      
      
    }
    public static void main(String[] args) {
      
     int arr[] = {4,3,2,7,8,3,2,1};
      findMinMax(arr);
      
    }
  }
  





//https://leetcode.com/problems/game-of-life
// Time Complexity : O(m*n), dir array traversal is constant as 8 directions always
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach


class Solution {
    int n, m;
    public void gameOfLife(int[][] board) {
        //0-->1 = 2 means 2 was originally dead and now alive
        //1-->0 = 3 means 3 was originally live and now dead 
        if(board.length == 0 || board == null)
            return;
        n = board.length;
        m = board[0].length;
        for(int i=0 ; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                int lives = countLives(board, i ,j); // counting surrounding live cells
                if((lives < 2 || lives >3) // rule 1 and 3 for live cells
                   && board[i][j] ==1)  
                    board[i][j] = 3; // mark them without changing( still representing live so that we can use the rules and also represent the original value)
                if(lives==3 && board[i][j] ==0) // rule 4 for dead cells
                    board[i][j] = 2; // mark them without changing( still representing dead)
            }
        }
         // after using original array changing it to how we want to return result
        for(int i=0 ; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(board[i][j] ==2) // if value is 2 it is supposed to be alive now
                    board[i][j] = 1;
                if(board[i][j] ==3) // if value is 3 it is supposed to be dead now
                    board[i][j] = 0;
            }
        }
        
    }
    
    private int countLives(int[][] board, int i, int j)
    { 
        int dirs[][] = {{0,-1}, {0, 1}, {1,0}, {-1,0} ,{-1,-1},{1,1}, {-1,1},{1,-1}}; // dir array for all 8 directions
        
        int lives=0;
        for(int dir[] : dirs)
        {
            int row = i+dir[0]; // finding the row in all 8 directions
            int column = j+dir[1]; // finding the column in all 8 directions
            if(row>=0 && column >=0 && column<m && row< n) // edge case
            {
                 if(board[row][column] ==1 || board[row][column] ==3) // if value is 1 or 3(originally alive) 
                   lives++; // count the lives
            }
               
            
        }
        return lives;
    }
}