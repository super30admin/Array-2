#
# @lc app=leetcode id=289 lang=python3
#
# [289] Game of Life
#

# @lc code=start
'''
Time Complexity - O(8*m*n). We are traversing the matrix twice. In the first run, for every element we are checking between 3 and 8 directions. Hence O(8*m*n)
Space Complexity - O(1). We are modifying the matrix in place. The direction array consists of 16 elements hence the size is constant.

This code works on leetcode
'''
class Solution:

    def __init__(self):
        self.dirs= [[-1,-1], [0,-1], [1,-1], [-1,0], [1,0], [-1,1], [0,1], [1,1]] #create the direction array

    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m, n = len(board), len(board[0])
        for i in range(m):
            for j in range(n):
                aliveNeighbors = self.countAliveNeighbors(board, i, j,m ,n) #count the alive neighbors for the particular cell
                if (aliveNeighbors < 2 or aliveNeighbors >3) and board[i][j] == 1: #make the cell dead for dieing conditions
                    board[i][j] = -2 #set the value in a way that the state of other neighbors is calculated on the basis of original state
                elif aliveNeighbors == 3 and board[i][j] == 0: #make the cell live for reproducing conditions 
                    board[i][j] = -1 
        for i in range(m):
            for j in range(n): #bring all the elements to final values after the operations
                if board[i][j] == -1:
                    board[i][j] = 1
                elif board[i][j] == -2:
                    board[i][j] = 0

    def countAliveNeighbors(self,board,i ,j, m, n)->int:
        aliveNeighbors = 0
        for dir in self.dirs: #for all directions
            nr = i+dir[1]
            nc = j+dir[0] #get effective row and column
            if nr >=0 and nc >=0 and nr<m and nc<n and (board[nr][nc] == 1 or board[nr][nc] == -2): #ensure the effective row and column are within the bounds of the board
                aliveNeighbors+=1
        return aliveNeighbors
                


        
# @lc code=end

