//------------FIND DISSAPPEARING NUMBERS----------------------
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No problem


// Your code here along with comments explaining your approach
public List<Integer> findDisappearedNumbers(int[] nums) {
        //optimal solution
        List<Integer> res=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int idx= Math.abs(nums[i])-1; //take the value as index as there are 1-n values
            if(nums[idx]>0)       //if value is not already visited, make it negative
                nums[idx]*=-1;
        }
        for(int i=0;i<n;i++){
            if(nums[i]>0) //value that is not visited (means they are missing)
                res.add(i+1);
            else //value that is visited
                nums[i]*=-1;
        }
        return res;

        //solution using booleean array 
        // List<Integer> res=new ArrayList<>();
        // boolean[] arr=new boolean[nums.length+1];
        

        // for(int i=0;i<nums.length;i++){
        //     arr[nums[i]]=true;
        // }
        // for(int i=1;i<=nums.length;i++){
        //     if(!arr[i])
        //         res.add(i);
        // }
        // return res;
        
        // using list to store missing elements
        // for (int i = 0; i < nums.length; i++) {
        //     int newIndex = Math.abs(nums[i]) - 1;
        //     if (nums[newIndex] > 0) {
        //         nums[newIndex] *= -1;
        //     }
        // }
        
        // List<Integer> result = new LinkedList<Integer>();
        // for (int i = 1; i <= nums.length; i++) {
        //     if (nums[i - 1] > 0) {
        //         result.add(i);
        //     }
        // }
        
        // return result;
    }

//---------------------GAME OF LIFE---------------------------
// Time Complexity : 8*O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : initially problem understanding conversion of 1,0,2 and 0,1,3 , but then after trial and error its okay


// Your code here along with comments explaining your approach
class Solution {
    int[][] dirs;
    public void gameOfLife(int[][] board) {
        //0->1 ->3      
        //1->0 ->2

        int m=board.length;
        int n=board[0].length;
                                //rig  //lef. //up.  //down //uplef  //uprig downleft //downrig
        dirs= new int[][]{{0,1},{0,-1},{-1,0},{1,0},{-1,-1}, {-1,1},  {1,-1},  {1,1}};

        //matrix traversal
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                int livecnt= alive(board, i,j); //function call to check total livecount for 8 neighbors
                if(board[i][j]==1 && (livecnt<2 || livecnt>3))  
                    board[i][j]=2;  // if live cell is turning dead, record as 2 because we need reference to old 1 for other cells
                if(board[i][j]==0 && livecnt==3)
                    board[i][j]=3;  // if dead cell is turning live, record as 3 because we need reference to old 0 for other cells
            }
        //matrix traversal to change 2 and 3 values.  
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                if(board[i][j]==2)
                    board[i][j]=0; // 2 is denotated as changed to 0 so keep 0
                if(board[i][j]==3)
                    board[i][j]=1; // 3 is denotated as changed to 1 so keep 1
            }
    }
    //function to count live counts of all neighbors
    private int alive(int[][] board, int i , int j){
        int count=0;
        int m=board.length;
        int n=board[0].length;
        for(int[] dir: dirs){ //for each loop that will check all 8 possible neighbors
            int r= i+dir[0];
            int c= j+dir[1];
            if(r>=0 && c>=0 && r<m && c<n && (board[r][c]==1 || board[r][c]==2)) // check if 1 or 2(because 2 is new 0 but old 1 which we need)
                count++;
        }
        return count;
    }
}