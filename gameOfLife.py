# // Time Complexity : O(m*n) for traversal 8 times for dirs 
# // Space Complexity : O(1) no additional space apart from original matrix
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : getLiveCount Function was super confusing 


# // Your code here along with comments explaining your approach
from typing import List
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        # 0 boolean dead, 1 boolean alive
        # always dead:(0,1), special dead: (2), special alive: (3), always dead: (4,5...8)
        m = len(board)
        n = len(board[0])
        dirs = [(-1,-1),(-1,0),(-1,1),(0,-1),(0,1),(1,-1),(1,0),(1,1)] # 8 directions
        # Function to check totalcount for all 8 dirtections
        def getLiveCount(dirs:List[int],board:List[List[int]], i:int, j:int,m:int, n:int):
            c = 0
            for di in dirs:
                nr = di[0] + i
                nc = di[1] + j
                if (nr >= 0 and nr < m and nc >= 0 and nc < n):         # boundary condition
                    if board[nr][nc] == 1 or board[nr][nc] == 2:        # currently alive  //or// will be dead in the next generation
                        c+=1
            return c

        
        # convert (0,1) to (0,1,(2,3),4,...,8)
        for i in range(m):
            for j in range(n):
                cnt = getLiveCount(dirs,board,i,j,m,n)
                if board[i][j] == 0:            # dead cell
                    if cnt == 3:                # now alive
                        board[i][j] = 3         # change 0->3 **
            
                elif board[i][j] == 1:          # alive cell
                    if cnt < 2 or cnt > 3:      # now dead
                        board[i][j] = 2         # change 1->3

        # convert back (0,1,(2,3),4,...,8) to (0,1)
        for i in range(m):
            for j in range(n):
                if board[i][j] == 3 :   
                    board[i][j] = 1             # re-change 3->1 **

                elif board[i][j] == 2:
                    board[i][j] = 0             # re-change 2->0


mtx = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
# x = getLiveCount(mtx,1,1)
# print(x)
