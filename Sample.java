//448. Find All Numbers Disappeared in an Array

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        int k=0;
        for(int i=0;i<n;i++)
        {
            k = Math.abs(nums[i]);
            nums[k-1] = -(Math.abs(nums[k-1]));
        }
        
        for(int i=0;i<n;i++)
        {
            if(nums[i]>0)
            {
                result.add(i+1);
            }
            else
            {
                nums[i] = Math.abs(nums[i]);
            }
        }
        return result;
    }
}

//289. Game of Life


// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    int m;
    int n;
    int[][] dirs;
    public void gameOfLife(int[][] board) {
        m= board.length;
        n = board[0].length;
        if(board == null || n==0) return;
        //directions 
        dirs = new int[][] {{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{-1,1},{1,1},{1,-1}};
        //0->1->2
        //1->0->3
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int countAlive = countAlive(board,i,j);
                if(board[i][j] ==1 && (countAlive < 2 || countAlive > 3)){
                    board[i][j] =3;
                }
                if(board[i][j] ==0 && countAlive == 3){
                    board[i][j] =2;
                }
                
            }
        }
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j] == 3)
                {
                    board[i][j] = 0;
                }
                if (board[i][j] == 2)
                {
                    board[i][j] = 1;
                }
            }
        }
    }   
        
        private int countAlive(int[][] board, int i, int j){
            int result = 0;//2,3
            for(int[] dir: dirs)
            {
                int nr = i+dir[0];  //2+0 = 2
                int nc = j+dir[1];  //3+1 = 4
                if(nr>=0 && nc>=0 && nr<m && nc<n && (board[nr][nc] == 1 || board[nr][nc] == 3))
                result++;
            }
            
            
           return result; 
        }
            
}

// Your code here along with comments explaining your approach



// Question - Maximum and minimum of an array using minimum number of comparisons (From geeks for geeks)
//Approach I - Naive solution to find the minimum and maximum number in an array *Does not take minimum comparisons*

// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : not present on leetcode
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


class Main
{
	
	public static void findMinAndMax(int[] nums)
	{
		// initialize minimum and maximum element with the first element
		
		int n = nums.length;
		int min = nums[0];
		int max = nums[0];
		
		for(int i=1;i<n;i++)
		{
			min = Math.min(min,nums[i]);
		}
		
		for(int i=1;i<n;i++)
		{
			max = Math.max(max,nums[i]);
		}
		

		System.out.println("The minimum array element is " + min);
		System.out.println("The maximum array element is " + max);
	}

	public static void main(String[] args)
	{
		int[] nums = { 5, 7, 2, 4, 9, 6 };

		// find the minimum and maximum element, respectively
		findMinAndMax(nums);
	}
}

// Question - Maximum and minimum of an array using minimum number of comparisons (From geeks for geeks)
//Approach II 

// Time Complexity : O(1.5n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : not present on leetcode
// Any problem you faced while coding this : yes, to understand how we can decrease the Time complexity

class Main
{
	// Naive solution to find the minimum and maximum number in an array
	public static void findMinAndMax(int[] nums)
	{
		// initialize minimum and maximum element with the first element
		
		int n = nums.length;
		int min = nums[0];
		int max = nums[0];
		
		for(int i=0;i<n-1;i++)
		{
			if(nums[i]>nums[i+1])
			{
			max = Math.max(max,nums[i]);
			min = Math.min(min,nums[i+1]);
			}
			else
			{
			min = Math.min(min,nums[i]);
			max = Math.max(max,nums[i+1]);
			}
		}
		

		System.out.println("The minimum array element is " + min);
		System.out.println("The maximum array element is " + max);
	}

	public static void main(String[] args)
	{
		int[] nums = { 5, 7, 2, 4, 9, 6 };

		// find the minimum and maximum element, respectively
		findMinAndMax(nums);
	}
}