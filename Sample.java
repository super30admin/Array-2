// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
 * It is given in the problem that the numbers will be in the range 1 to n inclusive.
 * So, in the first pass I am marking the numbers which are present by multiplying with -1.
 * In the second pass, I am considering all the elements of the array and checking which is +ve. The index + 1 would be the missing number.
 * */

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        if(nums==null || nums.length==0 || nums[0].length == 0)
        	return result;
        
        int index = 0;
        //mark the numbers present * by -1
        for(int i=0;i<nums.length;i++){
            index = Math.abs(nums[i])-1;
            nums[index]*=(nums[index]>0)?-1:1;
        }
        
        //Check for positive numbers are add to the result list, get back the original array.
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)
                result.add(i+1);
            else
                nums[i]*=-1;
        }
        return result;
    }
    
 // Time Complexity : O(n*m)
 // Space Complexity : O(n*m)
 // Did this code successfully run on Leetcode : yes
 // Any problem you faced while coding this : no


 // Your code here along with comments explaining your approach
 /*
  * The approach is to check if the cell is alive or dead.
  * If the cell is alive then check for its neighbours in max 8 directions with boundary checks. Increment the count when encountered live cells.
  * On each cell, check if the cell is live or dead and check under which counter it falls. Change the state accordingly, finally manipulate the input array with '0' and '1' states.
  * */
    
    public void gameOfLife(int[][] board) {
        
    	//initial checks
        if(board ==null || board.length==0 || board[0].length==0)
            return;
        
        int n = board.length;
        int m = board[0].length;
        
        //1-->0 : 3
        //0-->1 : 2
        
        //Each cell iteration, check if live or dead and see the count as well
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int count = findLiveCells(board,i,j,m,n);
                if((board[i][j]==1 || board[i][j]==3) && (count<2 || count>3))
                    board[i][j] = 3;
                else if((board[i][j]==0 || board[i][j]==2) && count==3)
                    board[i][j] = 2;
            }
        }
        
        //change the input array to obtain the actual result
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==3)
                    board[i][j] = 0;
                else if(board[i][j]==2)
                    board[i][j] = 1;
            }
        }
        
    }
    
    private int findLiveCells(int[][] board,int i,int j,int m,int n){
    	//keep 8 directions
        int[][] directions = new int[][]{{0,1},{0,-1},{-1,0},{1,0},{-1,1},{-1,-1},{1,1},{1,-1}};
        int result = 0;
        
        //check the neighbours of the cell on every possible direction for live cells
        for(int[] dir:directions){
            int r = i+dir[0];
            int c = j+dir[1];
            
            if(r>=0 && r<n && c>=0 && c<m && (board[r][c]==1 || board[r][c] == 3))
                result+=1;
        }
        
        //return the count of live cells
        return result;
    }