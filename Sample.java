import java.util.ArrayList;
import java.util.List;

// Find All Numbers Disappeared in an Array
//Time Complexity : O(N)
//Space Complexity : O(1)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
    //take resultant list
    List <Integer> result = new ArrayList<Integer>();
    //iterate the nums array
       for(int i = 0; i < nums.length; i++){
           //store element into temp
           int temp = nums[i];
           //if element was already would make it positive
           if(temp < 0){
               temp *= -1;
           }
           //if not last element
           if(temp <= nums.length) {
              //if the element is positive
              if(nums[temp - 1] > 0){
              //make is negative
               nums[temp-1] *= -1;
              } 

           }

       }
        //store all elements which are non negative
       for(int i = 0; i < nums.length; i++){
           if(nums[i] > 0){
               result.add(i+1);
           }
       }
       return result;
    }
}

//Find min and max
//Time Complexity : O(2/3n)
//Space Complexity : O(1)
class Solution1{

    public void Minmax(){
        int[] nums = { 4, 7, 5, 1, 3 };

    int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
 
    int n = nums.length;

    // if the array has an odd number of elements, ignore the last
    // element and consider it later
    boolean odd = (n & 1) == 1;
    if (odd) { n--; }

    // compare elements in pairs, i.e., nums[i] and nums[i+1]
    for (int i = 0; i < n; i = i + 2)
    {
        int maximum, minimum;

        // find the maximum and minimum among nums[i] and nums[i+1]

        if (nums[i] > nums[i + 1]) {      
            minimum = nums[i + 1];
            maximum = nums[i];
        }
        else {
            minimum = nums[i];
            maximum = nums[i + 1];
        }

        // update max
        if (maximum > max) {        
            max = maximum;
        }

        // update min
        if (minimum < min) {        
            min = minimum;
        }
    }

    // handle the last element if the array has an odd number of elements
    if (odd)
    {
        if (nums[n] > max) {
            max = nums[n];
        }

        if (nums[n] < min) {
            min = nums[n];
        }
    }

    }
    
    }
//Game of Life
//Time Complexity : O(M*N)
//Space Complexity : O(M*N)
class Solution3 {
    //for checking 8 neighbours indices of all neighbours array
    int[][] dirs;
    int m,n;
    public void gameOfLife(int[][] board) {
       if(board==null)return;
        m = board.length;
        n = board[0].length;
       dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{-1,1},{1,1},{1,-1}};
        //if the 0 should be made 1 we change it to 2
        //if the 1 should be made 0 we change it to 3
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
            int countalive = countalive(board,i,j);
            //if the element is 0 and has three 1 neighbours then make it 2
            if(board[i][j]==0 && countalive==3){
                board[i][j]=2;
            }
            //if the element is alive and the neighbours have less than 2 number of ones or more than 3 neighbours are 0 then change it to dead 3
          if(board[i][j] == 1 && (countalive < 2 || countalive > 3)){
                board[i][j]=3;
            }
            }
        }
        
        //change the array to 1 and 0 from 2 and 3
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==2)board[i][j]=1;
                
                if(board[i][j]==3)board[i][j]=0;
            }
        }
        
        
    }
    //counting the number of alive neighbours
    private int countalive(int board[][],int i,int j){
        int result=0;
        for(int[] d : dirs){
            int r = d[0]+i;
            int c = d[1]+j;
        
        //check for bounds
        if(r>=0 && r<m && c>=0 && c<n && (board[r][c]==1 || board[r][c]==3 )){
            result++;
        }
        }
        return result;
    }
}