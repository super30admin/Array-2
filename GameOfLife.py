"""
Intuition:  Because each cell has to be changed wrt to the original state of the matrix, we need to perserve the matrix.
Each transition can be recorded: 
1) Transition from 1 ---> 0 == 3 ( any number can be used here)
2) Transition from 0 ---> 1 == 2 ( any number can be used here)
#####################################################################
Time Complexity : O(2(M*N))  M = number of rows, N = number of cols
Space Complexity : O(1) 
#####################################################################
"""
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        #1--->0 --->3 
        #0--->1 --->2
        for i in range(len(board)):
            for j in range(len(board[0])):
                liveNeighbours = self.getLiveNeighbours(board, i, j)
                print(liveNeighbours)
                if board[i][j] == 1 and (liveNeighbours < 2 or liveNeighbours > 3):
                    board[i][j] = 3
                
                if board[i][j] == 0 and (liveNeighbours == 3):
                    board[i][j] = 2
                    
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == 3:
                    board[i][j] = 0
                
                if board[i][j] == 2:
                    board[i][j] = 1
        
    
    def getLiveNeighbours(self, board, i, j):
        neighbours = 0
        directions = [[0,1], [1,0], [-1,0], [0, -1], [-1,-1], [1,1], [-1, 1], [1, -1]]
        
        for direction in directions:
            newI = i + direction[0]
            newJ = j + direction[1]
        
            if (len(board) -1 >= newI >= 0) and (len(board[0]) -1 >= newJ >= 0) and (board[newI][newJ]==3 or board[newI][newJ]==1):
                neighbours += 1
       
        return neighbours 