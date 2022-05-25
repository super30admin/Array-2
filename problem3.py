# Time Complexity : O(no of rows * no of cols)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    directions = [
        [-1,-1] , [1,1] ,
        [-1,0] , [0,-1] ,
        [1,0] , [0,1] ,
        [1,-1] , [-1,1]
    ]
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        for rowIndex,row in enumerate(board):
            for colIndex,colEle in enumerate(row):
                liveCount = self.getLiveCount(board,rowIndex,colIndex)
                if board[rowIndex][colIndex] == 1:
                    if liveCount < 2 or liveCount > 3:
                        board[rowIndex][colIndex] = -2
                else:
                    if liveCount == 3:
                        board[rowIndex][colIndex] = -1
        
        for rowIndex,row in enumerate(board):
            for colIndex,colEle in enumerate(row):
                if board[rowIndex][colIndex] == -1:
                    board[rowIndex][colIndex] = 1
                elif board[rowIndex][colIndex] == -2:
                    board[rowIndex][colIndex] = 0
    def getLiveCount(self,board,rowIndex,colIndex):
        liveCount = 0
        for direction in self.directions:
            x = rowIndex + direction[0]
            y = colIndex + direction[1]
            
            if x >= 0 and x < len(board) and y >= 0 and y < len(board[0]):
                if board[x][y] == 1 or board[x][y] == -2:
                    liveCount += 1
        return liveCount