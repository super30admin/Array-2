// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :Nope


// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> li=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            if(nums[Math.abs(nums[i])-1]>0)
            nums[Math.abs(nums[i])-1]=-1*nums[Math.abs(nums[i])-1];
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                li.add(i+1);
            }
        }
        return li;
        
    }
}






// Time Complexity :O(mn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :Nope


// Your code here along with comments explaining your approach
class Solution {
    public void gameOfLife(int[][] board) {
        
        //any cell with 1, will die if it has less than 2 1s in the neighbourhood dies.
        //Any cell with 1,will live on if it has 2 or 3 1s in the neighbourhood
        //any cell with 1, will die if it has more than 3 1s in the neighbourhood
        //any cell with 0, will become 1 if it has exactly 3 1s in the neighbourhood.
        
        // let us represent 1->0 as 2
        //let us represent 0->1 as 3
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==0){
                    int count=CountOnes(board,i,j);
                    if(count==3){
                        board[i][j]=3;
                    }
                }else{
                    int count=CountOnes(board,i,j);
                    if(count<2){
                        board[i][j]=2;
                        
                    }if(count==2 || count==3){
                        board[i][j]=1;
                        
                    }if(count>3){
                        board[i][j]=2;
                        
                    }
                }
                
            }
        }
         for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==2){
                    board[i][j]=0;
                    
                }else if(board[i][j]==3){
                    board[i][j]=1;
                }
            }
         }
        
        
        
    }
    public int CountOnes(int[][] board,int i,int j){
        int[][] dir={{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
        int count=0;
        for(int[] arr:dir){
            int row=i+arr[0];
            int col=j+arr[1];
            if((row>=0 && row<board.length) &&(col>=0 && col<board[0].length)){
                if(board[row][col]==1 || board[row][col]==2){
                    count++;
                }
            }
        }
        return count;
}
}