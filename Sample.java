// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// class Solution {
//     // TC: O(n) SC: O(1)
//     public List<Integer> findDisappearedNumbers(int[] nums) {
//         if(nums == null || nums.length==0) return new ArrayList<Integer>();
//          List<Integer> result = new ArrayList<Integer>();
//         for (int i =0; i<=nums.length-1; i++){
//             int a = Math.abs(nums[i])-1;
//             if(nums[a]>0){
//                 nums[a] = -1*nums[a];
                
//             }}
//         for (int i =0; i<=nums.length-1; i++){
//             if(nums[i]<0)
//             {
             
                
//             } else {
//                result.add(i+1);
//             }
            
//         }
//             return result;
//     }
// }

// class Solution {
//     //TC: O(m*n) SC : O(1)
//     int m;
//     int n;
//     public void gameOfLife(int[][] board) {
//         //repressent 0 >1 as 2 and 1>0 as 3
//          if(board == null || board.length==0) return;
        
        
//             m = board.length;
//             n = board[0].length;
            
//         for(int i = 0; i < m; i++){
//             for(int j =0; j < n; j++){
//                 int countLiveCells = getCount(board, i, j);
//                 if(board[i][j]==1) {
//                     if(countLiveCells<2 || countLiveCells>3){
//                         board[i][j] = 2;
//                     }
//                 }
//                 else {
//                     if(countLiveCells == 3){
//                         board[i][j] = 3;
//                     }
//                 }
//             }   
//         }
        
//          for(int i = 0; i < m; i++){
//             for(int j =0; j < n; j++){
              
//                 if(board[i][j] == 2) {
                   
//                         board[i][j] = 0;
                    
//                 }
//                 else if(board[i][j] == 3){
//                         board[i][j] = 1;
                    
//                 }
//             }   
//         }

//     }
//     private int getCount(int[][] board, int r, int c){
//         int[][] dirs = {{0,1}, {0, -1},{1, 0},{-1, 0},{1, 1},{-1, -1},{-1, 1},{1, -1}};
//             int total = 0;
//         for(int[] dir: dirs){
//             int nr = r + dir[0];
//             int nc = c + dir[1];
//             if(nr >= 0 && nr < m && nc >= 0 && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 2)){
//                 total++;
//             }
            
            
//         }
//         return total;
//     }
// }
