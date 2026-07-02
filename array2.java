// Approach:
// 1. Traverse the array and use each value as an index.
// 2. Mark the corresponding index as visited by making the element negative.
// 3. Use Math.abs() since some elements may already be negative.
// 4. Traverse the array again.
// 5. The indices containing positive values represent the missing numbers.
// 6. Add (index + 1) to the result list.

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> map=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int res=Math.abs(nums[i])-1;
            if(nums[res]>0){
                nums[res]=-nums[res];
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                map.add(i+1);
            }
        }
        return map;
    }
}
//problem 2
// Approach:
// 1. Traverse each cell and count its live neighbors.
// 2. Use temporary states to avoid affecting neighboring cells:
//    - 2: Cell was alive and becomes dead.
//    - 3: Cell was dead and becomes alive.
// 3. While counting neighbors, consider values 1 and 2 as originally alive.
// 4. After processing all cells, convert:
//    - 2 -> 0
//    - 3 -> 1
// 5. This updates the board in-place without using an extra matrix.

// Time Complexity: O(m * n)
// Space Complexity: O(1)
class Solution {
    public void gameOfLife(int[][] board) {
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int countlive=gameoflife(board,i,j,m,n);
                if(board[i][j]==1 && (countlive<2 || countlive>3)){
                    board[i][j]=2;
                }
                if(board[i][j]==0 && (countlive==3)){
                    board[i][j]=3;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==2){
                    board[i][j]=0;
                }if(board[i][j]==3){
                    board[i][j]=1;
                }
            }
        }
    }
    private int gameoflife(int[][] board,int i,int j,int m,int n){
        int cnt=0;
        int[][] dirs={{0,1},{1,0},{0,-1},{-1,0},{1,1},{-1,-1},{1,-1},{-1,1}};
        for(int[] dir:dirs){
            int nr=i+dir[0];
            int dn=j+dir[1];
            if(nr>=0 && dn>=0 && nr<m && dn<n && (board[nr][dn]==1||board[nr][dn]==2)){
                cnt++;
            }
        }
        return cnt;
    }
}
