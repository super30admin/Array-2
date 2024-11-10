# Array-2

## Problem1 (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)
## Solution 1
## Time Complexity:O(2n) Space Complexity:O(1)
## The elements which exist their corresponding index elements are made negative to recognise their right positions.
## The elements which do not exist their corresponding indexes will have positive elements and hence their indexes will be added to the list.

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
       List<Integer> result=new ArrayList<Integer>();

       for(int i=0;i<nums.length;i++)
       {
         int idx=Math.abs(nums[i])-1;
         if(nums[idx]>0){
            nums[idx]*=-1;
         }
       } 
       for(int i=0;i<nums.length;i++){
        if(nums[i]>0)
        {
            result.add(i+1);
        }
       }
       return result;
    }
}

## Problem2
Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison
## Solution 2
##
##
##

class Solution{
    public int[] findMinMax(int[] nums){
     int[] result=new int[2];
     result[0]=Integer.MAX_VALUE;
     result[1]=Integer.MIN_VALUE;
     for(int i=0;i<nums.length-1;i+=2){
        if(nums[i] < nums[i+1]){
            result[0]=Math.min(result[0],nums[i]);
            result[1]=Math.max(nums[i+1],result[1]);
        }
        else{
            result[0]=Math.min(result[0],nums[i+1]);
            result[1]=Math.max(nums[i],result[1]);
        }
     }
     return result;
    }
}

## Problem3 (https://leetcode.com/problems/game-of-life/)
## Solution 3
##
##
##

class Solution {
    public void gameOfLife(int[][] board) {
        int m=board.length;
        int n=board[0].length;

        int[][] dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int count=getLiveCount(dirs,board,i,j,m,n);
                if(board[i][j]==0)
                {
                    if(count==3){
                        board[i][j]=3;
                    }
                }else if(board[i][j]==1){
                    if(count<2 || count>3){
                        board[i][j]=2;
                    }
                }
            }
        }

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++){
                if(board[i][j]==2)
                {
                    board[i][j]=0;
                }else if(board[i][j]==3)
                {
                    board[i][j]=1;
                }
            }
        }
    }

    private int getLiveCount(int[][] dirs,int[][] board,int i,int j,int m,int n){
        int count=0;
        for(int[] dir:dirs){
            int nr=dir[0]+i;
            int nc=dir[1]+j;
            if(nr>=0 && nr<m && nc>=0 && nc<n){
                if(board[nr][nc]==1 || board[nr][nc]==2){
                    count++;
                }
            } 
        }
        return count;
    }
}