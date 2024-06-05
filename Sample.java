// Problem 1
// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums==null|| nums.length==0) return new ArrayList<Integer>();
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            int temp=Math.abs(nums[i]);
         if(nums[temp-1]>0)
         {
            nums[temp-1]=nums[temp-1]*-1;
         }
        }
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
            {
                res.add(i+1);
            }
        }
        return res;
    }
}

// Problem 2
// Time Complexity :O(n*m)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach


class Solution {
    public void gameOfLife(int[][] board) {
        int n=board.length;
        int m=board[0].length;
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                int countN=countLiveNeighbor(board,i,j);
               if(board[i][j]==1)
               {
                if(countN<2 || countN>3)
                {
                    board[i][j]=2;
                }
               } 
               else{
                if(countN==3)
                {
                    board[i][j]=3;
                }
               }
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]==2)
                {
                    board[i][j]=0;
                }
                if(board[i][j]==3)
                {
                    board[i][j]=1;
                }
            }
        }

    }
    private int countLiveNeighbor(int[][] board,int row, int col)
    {
        int count=0;
        int m=board.length;
        int n= board[0].length;
        int dirs[][]={{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
        for(int dir[]:dirs)
        {
            int nr= row+dir[0];
            int nc=col+dir[1];
            if(nr>=0 && nr<m && nc>=0 && nc<n &&(board[nr][nc]==1 || board[nr][nc]==2))
            {
                count ++;
            }
        }
        return count;
    }
}