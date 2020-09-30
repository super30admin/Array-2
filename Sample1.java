// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//O(n),O(n)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //add all the numbers in hashmap and mark as true,iterate over the array till N and
        //check if the number is not present then add to list
        List <Integer>ans = new ArrayList<>();
        HashMap<Integer,Boolean> hs = new HashMap<Integer,Boolean>();
        for(int i=0;i<nums.length;i++){
            hs.put(nums[i],true);
        }
        for(int i=1;i<=nums.length;i++){
            if(!hs.containsKey(i)){
                ans.add(i);
            }
        }
        return ans;
    }
}


//game of life
O(mn) ,O(mn)
class Solution {
    private int live=2;
    private int die=3;
    public void gameOfLife(int[][] board) {
        
        int row=board.length;
        int col=board[0].length;
        
        for(int i=0;i<row;i++){
            for(int j=0;i<col;j++){
                int state=checkstate(i,j,board);
                //if 0 and total cell alive around is 3
                if(board[i][j] == 0 && state==3){
                    board[i][j] = live;
                }
                //if 1:
                else if(board[i][j] == 1){
                    if(state==2 || state==3)
                        continue;
                    if(state < 2 || state > 3)
                        board[i][j]=die;
                        
                }
            }
        }
        
    


          //flip states
          for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                 if (board[i][j] == die)
                     board[i][j] = 0;
                 if (board[i][j] == live)
                     board[i][j] = 1;
                }
            }
        
    }
    
    private int checkstate(int i, int j,int[][] board){
        int count = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
        
        for (int[] dir:dirs){
            int x = i+dir[0];
            int y = j+dir[1];
            
            if (x>=0 && y>=0 && x < board.length && y<board[0].length ){
                
                if (board[x][y] == 1 || board[x][y] == die)
                    count ++;
            }
        }
        
        return count;
        
    }
}