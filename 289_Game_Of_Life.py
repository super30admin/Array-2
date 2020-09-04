# Leetcode link : https://leetcode.com/problems/game-of-life/
# Time Complexity : O(m * n)
#  Space Complexity : O(1)
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

'''
    Brute force approach => Use another matrix to save the next state output and then modify the current board based on the temporary matrix
    
    O(1) space solution => Assign a unique value for state to the current state alive and should be dead in next state cells so that the comparison for other cells is not hampered. This is not a DFS/BFS solution as we are not traversing the whole path instead just checking 8 directions for each cell
'''


# 2 -> alive now dead
# 4 -> dead now alive

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        # edge case
        if not board or len(board) == 0 or len(board[0]) == 0:
            return
        # intialize row and column bounds
        n, m = len(board), len(board[0])
        
        # traverse the matrix
        for i in range(n):
            for j in range(m):
                # get live dead cells around the current cell
                alive = self.getAliveNeighborCount(board,m,n,i,j)
                
                # if current cell is alive
                if(board[i][j] == 1):
                    # condition 1 and 3 from question
                    if alive < 2 or alive > 3:
                        board[i][j] = 2
                # if current cell is dead
                elif board[i][j] == 0:
                    # condition 4 from question
                    if alive == 3:
                        board[i][j] = 4
        # change the matrix with current state based on temp state variables
        for i in range(n):
            for j in range(m):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 4:
                    board[i][j] = 1
                        
    
    # function to get the alove neighbors count
    def getAliveNeighborCount(self,board, m, n, i, j):
        count = 0
        
        # 8 directions for every cell
        dirs = [[-1,0], [-1,1], [0,1], [1,1], [1,0], [1,-1], [0,-1], [-1,-1]]
        
        # traverse all the directions
        for dir in dirs:
            # add current direction value to the i and j values to get the row and column to be checked w.r.t. current cell
            r = i + dir[0]
            c = j + dir[1]
            # check if they are in bounds
            if(r >= 0 and r < n and c >= 0 and c < m):
                # check current alive and also current alive but dead for next state conditions for the cunt
                if board[r][c] == 1 or board[r][c] == 2:
                    count += 1
        return count