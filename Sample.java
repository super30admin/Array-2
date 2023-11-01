// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//Find Disappered Numbers
//Time Complexity -> O(2n) -> O(n)
//Space Complexity -> O(n) -> space for hashset
class Solution {
    //Using hashSet
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList();
        Set<Integer> set = new HashSet();
        for(int i=0;i<n;i++){
            set.add(i+1);
        }
        for(int i=0;i<n;i++){
            if(set.contains(nums[i])){
                set.remove(nums[i]);
            }
        }

        for(int num : set){
            result.add(num);
        }

        return result;
    }
}

//Time Complexity -> O(n) 
//Space Complexity -> O(1) -> In place
class Solution {
    //In place
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList();
        int n = nums.length;
        for(int i=0;i<n;i++){
            int idx = Math.abs(nums[i]) -1;
            if(nums[idx]>0){
                nums[idx] = nums[idx]*(-1);
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                result.add(i+1);
            }
            else{
                nums[i] = nums[i]*(-1);
            }
        }

        return result;
    }
}

//Game of Life
//Time Complexity ->O(8*m*n) -> O(m*n) because for each element in the matrix we have to check the 8 boundries
//Space Complexity-> O(1) -> as everything in place
class Solution {
    int[][] dir;
    public void gameOfLife(int[][] board) {
         // o->1 = shown by 2
         // 1 -> 0 = shown by 3
        int nRows = board.length;
        int nCols = board[0].length;
                           //right //down. //left. //up.    //upleft //downright.  //upright. //downleft
        dir = new int[][]{{0,1},   {1,0}, {-1,0},  {0,-1} , {-1,-1} ,{1,1} ,      {1,-1} ,   {-1,1}};

        for(int i = 0;i<nRows;i++){
            for(int j = 0;j<nCols;j++){
                int val = board[i][j];
                int count = activeCounts(board,i,j,nRows,nCols);
                if(val == 1 && (count <2 || count > 3)){
                    board[i][j] = 3;
                }
                if(val == 0 && count ==3){
                    board[i][j] = 2;
                }

            }
        }
        for(int i = 0;i<nRows;i++){
            for(int j = 0;j<nCols;j++){
                int val = board[i][j];
                if(board[i][j] == 3){
                    board[i][j] = 0;
                }
                if(board[i][j] == 2){
                    board[i][j] = 1;
                }

            }
        }
        
    }

    private int activeCounts(int[][] board,int i,int j,int nRows,int nCols ){
        int count = 0;
        int r =0,c =0;
        for(int[] dir : dir){
            r = i + dir[0];
            c = j + dir[1];
            if(r >=0 && c >= 0 && r< nRows && c < nCols && (board[r][c] == 1 || board[r][c] == 3)){
            count ++;
        } 
        }

        
        
        return count;
    }
}