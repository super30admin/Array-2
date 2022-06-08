//Problem-1
// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :Intially I didnot come up with idea referred class for the logic

// Your code here along with comments explaining your approach Here the basic idea is to convert the values at that
//specific index value to negative . for example at i=0 if we have element 4 then we go to the index 4 and make it negative
//In this way we can hhave idea what elements are occuring in the array. we check for elements greater than 0 and return.

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int index=Math.abs(nums[i])-1;
            if(nums[index]>0) {
                nums[index]=-nums[index];
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0) res.add(i+1);
        }
        return res;


    }
}
//Problem-2
// Time Complexity :O(m*n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :Intially I didnot come up with idea referred class for the logic

// Your code here along with comments explaining your approach: Here the basic requirement is to find the number of living
//neighbours. If we have that count then we can do the necessary modifications as per given conditions. The other main key
// is to make modifications to the board in such a way that it won't affect the operations of next elements in the board
//Here we use the pseudo namiing insted to achieve the required and in the end we revert to original.
class Solution {
    private int countAlive(int[][] board,int i, int j,int m,int n){
        int [][] dirs={{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        int result=0;
        for(int []dir:dirs){
            int row=i+dir[0];
            int column=j+dir[1];
            if(row>=0 && column>=0 && row<m && column <n ) {
                if(board[row][column]==1|| board[row][column]==2) result++;
            }
        }
        return result;
    }
    public void gameOfLife(int[][] board) {
        int m= board.length;
        int n=board[0].length;
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                count=countAlive(board,i,j,m,n);
                if(board[i][j]==1 && (count<2 || count >3) ){

                    board[i][j]=2;//1-->0

                }
                if(board[i][j]==0 && count==3 ){
                    board[i][j]=3;//0-->1
                }
            }
        }
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if(board[i][j]==2) board[i][j]=0;
                if(board[i][j]==3) board[i][j]=1;
            }
        }


    }
}
//Problem-3
// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :Referred some resources to find about kadane's algorithm

// Your code here along with comments explaining your approach: Here we need to find maximum sum contigous subarray.
//For this we try to use the kadane's algorithm which basically  has two variables maximum end here and maximum sum so far
// we calculate the sum in meh for every element. we check if the value at that specific index is greater than meh then we
//replace meh with that index value. And if msf less than meh then we update msf with meh. return msf

class Solution {
    public int maxSubArray(int[] nums) {
        int meh=0;
        int msf=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            meh=meh+nums[i];
            if(meh<nums[i]) meh=nums[i];
            if(msf<meh) msf=meh;
        }
        return msf;

    }
}

