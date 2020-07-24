# Leetcode 289. Game of Life

# Time Complexity :  O(m*n) where m,n is the dimensions of the matrix

# Space Complexity : O(1)

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Iterate over matrix in every direction and calculate the live neighbours. If the neighbours
# are below 2 or above 3 kill the cell if its alive. If its already dead but has 3 live neighbours, make it
# alive. Apply the changes and start the next iteration.

# Your code here along with comments explaining your approach

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        # down,up,left,light,d&l,d&r,u&l,u&r
        dirs = [[-1,0],[1,0],[0,-1],[0,1],[1,-1],[1,1],[-1,-1],[-1,1]]
        
        
        m = len(board)
        n = len(board[0])
        
        for i in range(m):
            for j in range(n):
                live = 0
                for d in dirs:
                    if i+d[0] < 0 or i+d[0] >= m or j+d[1] >= n or  j+d[1] < 0:
                        continue
                    if board[i+d[0]][j+d[1]] == 1 or board[i+d[0]][j+d[1]] == 3 :
                        live += 1
                # already alive but goes dead if live friends are below 2 or above 3        
                if board[i][j] == 1 and (live < 2 or live > 3):
                    board[i][j] =3
                # dead but resurrects if it has 3 live friends    
                if board[i][j] ==0 and live == 3:
                    board[i][j] = 2
        # iterate over thr matrix and update the cell values from 3 & 2 to 0 & 1 for next state
        for i in range(m):
            for j in range(n):
                if board[i][j] == 3:
                    board[i][j] = 0
                    
                if board[i][j] == 2:
                    board[i][j] = 1