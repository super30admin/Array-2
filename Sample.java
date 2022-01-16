//Find all numbers disappeared in a array
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        
        List<Integer> list = new ArrayList();
        
        for(int i = 0; i < nums.length; i++) {
            int temp = Math.abs(nums[i]);
            if(nums[temp-1] > 0) {
                nums[temp-1] *= -1;
            }
        }
        
         for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                list.add(i+1);
            }
        }
        return list;
       
    }
}


//maximum and minimum in an array

public class Main
{
    static int[] nums = new int[]{1,2,3,4,5,6,7};
    
	public static void main(String[] args) {
	    
	   
	    
	    if(nums.length % 2 ==0) {
    	    int min = Integer.MAX_VALUE;
    	    int max = Integer.MIN_VALUE;
    	    for(int i = 0; i < nums.length-1; i = i + 2) {
    	        if(nums[i] < nums[i+1]) {
    	            min = Math.min(min,nums[i]);
    	            max = Math.max(max,nums[i+1]);
    	        } else {
    	             min = Math.min(min,nums[i+1]);
    	             max = Math.max(max,nums[i]);
    	            
    	        }
    	    }
    	    System.out.println(max);
    	    System.out.println(min);
	    } else {
	        int min = Integer.MAX_VALUE;
    	    int max = Integer.MIN_VALUE;
    	    for(int i = 0; i < nums.length-1; i = i + 2) {
    	        if(nums[i] < nums[i+1]) {
    	            min = Math.min(min,nums[i]);
    	            max = Math.max(max,nums[i+1]);
    	        } else {
    	             min = Math.min(min,nums[i+1]);
    	             max = Math.max(max,nums[i]);
    	            
    	        }
    	    }
    	    if(nums[nums.length-1] < min || nums[nums.length-1] > max) {
    	           min = Math.min(min,nums[nums.length-1]);
    	           max = Math.max(max,nums[nums.length-1]);
    	    }
    	    System.out.println(max);
    	    System.out.println(min);
	    }
	}
}

//Game oF Life

// Time Complexity : O(M*N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no



class Solution {
    public void gameOfLife(int[][] board) {
        
        int m = board.length;
        int n = board[0].length;
        int[][] result = new int[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++) {
              int count = countNeighbors(board,i,j,m,n);
                if(board[i][j] == 1 && (count < 2 || count>3)) {
                    board[i][j] = 5;
                }
                if(board[i][j] == 0 && count == 3) {
                    board[i][j] = 4;
                }
            }
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 5) {
                    board[i][j] = 0;
                } else if(board[i][j] == 4) {
                    board[i][j] = 1;
                }
            }
        }
    }
       private int countNeighbors(int[][] board, int i, int j, int m, int n) {
           int result = 0;
            int[][] neighbors = new int[][] {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
            
            for(int[] neighbor:neighbors) {
                int row = i + neighbor[0];
                int column = j + neighbor[1];
                
                if(row >= 0 && row < m && column >=0 && column < n) {
                    if(board[row][column] == 1 || board[row][column] == 5) {
                        result++;
                    }
                }
            }
            return result;
        }
}