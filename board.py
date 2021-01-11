// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m,n= len(board),len(board[0])
        movements = [(1,0), (1,-1), (0,-1), (-1,-1), (-1,0), (-1,1), (0,1), (1,1)]

        copy = [item[:] for item in board]

        for i in range(m):
            for j in range(n):
                live = 0
                
                for x,y in movements:
                    if (i+x < m and i+x >= 0) and (j+y < n and j+y >= 0) and (copy[i+x][j+y] == 1):
                        live += 1
     
                if copy[i][j] == 1 and (live < 2 or live > 3):
                    board[i][j] = 0

                if copy[i][j] == 0 and live == 3:
                    board[i][j] = 1