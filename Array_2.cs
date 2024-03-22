using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;


namespace S30_Problems
{
    class Program
    {
        static void Main(string[] args)
        {
            Program p = new Program();
            p.GameOfLife(new int[][] { new int[] { 0,1, 0}, new int[] { 0, 0, 1 }, new int[] { 1,1,1 }, new int[] { 0, 0, 0 } });
        }
        // Time Complexity: O(2n)
        // Space Complexity: O(1)
        public IList<int> FindDisappearedNumbers(int[] nums) {
            IList<int> res = new List<int>();
            for(int i = 0; i < nums.Length; i++){
                if(nums[Math.Abs(nums[i])-1]>0){
                    nums[Math.Abs(nums[i])-1] *= -1; 
                }
            }
            for(int i = 0; i < nums.Length; i++){
                if(nums[i]>0) res.Add(i+1);
                else nums[i]*=-1;
            }
            return res;
        }

        // Time Complexity: O(m*n*9) 8 * m*n for calculates 8 directions for each cell + 1 * m*n for rewriting the board.
        // Space Complexity: O(1)

        int[][] dirs = new int[][] {new int[]{0,1},new int[]{1,0},new int[]{0,-1},new int[]{-1,0},new int[]{-1,-1},new int[]{-1,1},new int[]{1,-1},new int[]{1,1}};
        int[][] board;
        public void GameOfLife(int[][] board) {
            this.board = board;
            for(int i = 0; i<board.Length; i++){
                for(int j = 0; j<board[0].Length; j++){
                    int count = countAlive(i,j);
                    if(board[i][j] == 0){
                        if(count == 3) board[i][j] = -2;
                    }
                    else{
                        if(count < 2 || count > 3) board[i][j] = -1;
                    }
                }
            }
            
            for(int i = 0; i<board.Length; i++){
                for(int j = 0; j<board[0].Length; j++){
                    if(board[i][j] == -2) board[i][j] = 1;
                    if(board[i][j] == -1) board[i][j] = 0;
                }
            }
        }
        
        private int countAlive(int i, int j){
            int count = 0;
            foreach(int[] dir in dirs){
                int ni = i+dir[0];
                int nj = j+dir[1];
                
                if(ni<0 || nj < 0 || ni>=board.Length || nj >= board[0].Length ) continue;
                if(board[ni][nj] == 1 || board[ni][nj] == -1) count++;
            }
            return count;
        }
    }
}
