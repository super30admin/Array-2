//Problem 1: 
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> result= new ArrayList<>();
        
        if(nums==null || nums.length==0) return result; 
        
        for(int i=0; i<nums.length; i++)
        {
            int index= Math.abs(nums[i]); //absolute because we are changing the elements to negative
            if(nums[index-1]>0){ //if the number is positive
            nums[index-1]= -nums[index-1];} //make it negative 
        }
        
        for(int j=0;j<nums.length; j++)
        {
            if(nums[j]>0)
            {
                result.add(j+1); //add the missing index value to the result 
            }
        }
        return result; 
    
}
}

//Problem 2: 

//25% reduction in the number of compares. Instead of comparing each element with min and max, which leads to 2*n compares, compare the next element with the current element 
// nums[i] is compared with nums[i+1]
// the greater of both is compared with max
// the lesser of both is compared to min
// this leads to 3 compares per 2 element 
// i.e 1.5n compares 

//Problem 3

// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public void gameOfLife(int[][] board) {
        
        //0--1 --> 2
        //1--0 --> 3
        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board[0].length; j++)
            {
                int count= CountNeighbors(board,i,j); //calculate the ones present in all the neightbors of the element  
                if(board[i][j]==1) //if the element is alive
                {
                    if(count<2 || count>3) //over population and under population 
                    {
                        board[i][j]=3; //dead
                    }
                }
                else if(board[i][j]==0) //if the element is dead
                {
                    if(count==3) //if exactly 3 live neighbors
                    { 
                        board[i][j]=2; //dead to alive
                    }
                }
            }
        }
        
         for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board[0].length; j++)
            {
                if(board[i][j]==2) //2 represents alive
                {
                    board[i][j]=1; //change back to 1
                }
                else if(board[i][j]==3) //3 represents dead
                {
                    board[i][j]=0; //change back to 0 
                }
            }
         }
        
    }
    
    private int CountNeighbors(int[][] board, int i, int j)
    {
        int result=0;
                        //right,left, up, down, bottom right diagonal, bottom left diagonal, up right diagonal, up left diagonal
        int[][] directions= {{0,1}, {1,0}, {-1,0}, {0,-1}, {1,1}, {1,-1}, {-1,1},{-1,-1}}; 
        
        for(int[] dir: directions)
        {
            int r= i+dir[0];//add x coordiante
            int c= j+dir[1];//add y coordinate
            
            if(r>=0 && r<board.length && c>=0 && c<board[0].length && (board[r][c]==1 || board[r][c]==3))
            {
                result++; //check if neighbors are equal to 1 or 3, if yes increment the count
            }
        }
        return result; 
    }
}