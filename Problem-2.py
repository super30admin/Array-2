# Time Complexity : O(m*n) we are iterating through the board twice.
# Space Complexity : O(1)  we are doing in place in the solution we are not using any extra space to track the state
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
#we first go to each cell of the board and count how many live cells are there around that and based on that we mark the currnt cell to -1 or 2 """
#we only increment live cells when we explore all the neighbors for live cells and update it
#now base on the count of live cells we mark the current cell as -1 if it is going to die in the next state and we mark it as 2 if it is going to live in the next state and we do this for all the cells in the board
# we iterate the board again to undo the markings and update the state of the cells to the original state.
# Your code here along with comments explaining your approach
class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        dirs=[[-1,0],[-1,-1],[-1,1],[0,-1],[0,1],[1,0],[1,-1],[1,1]]
        for i in range(len(board)):
            for j in range(len(board[0])):
                #counting the live neighbors of the current cell
                liveCells=0
                for dir in dirs:
                    r=i+dir[0]
                    c=j+dir[1]
                    #we will check if the neighbor is within the boundary of the board and if it is live then we will count it as a live neighbor
                    if r>=0 and r<len(board) and c>=0 and c<len(board[0]) and abs(board[r][c])==1:  
                            liveCells+=1
                #if the current cell is live then we will mark it as -1 if it is going to die in the next state
                if board[i][j]==1 and (liveCells<2 or liveCells>3):
                    board[i][j]=-1
                #if the current cell is dead then we will mark it as 2 if it is going to live in the next state
                if board[i][j]==0 and liveCells==3:
                    board[i][j]=2
        #we will iterate over the board again to update the state of the cells to the next state
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j]>0:
                    board[i][j]=1
                else:
                    board[i][j]=0