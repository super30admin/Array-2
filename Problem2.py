# Game of Life
# Any live cell with fewer than two live neighbors dies as if caused by under-population.
# Any live cell with two or three live neighbors lives on to the next generation.
# Any live cell with more than three live neighbors dies, as if by over-population.
# Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

# Time complexity -> O(2mxn) -> O(mxn)
# Space complexity -> O(1)
# Logic -> iterate over each elemnt, find it's live neighbor count. If live is changing to dead or dead is changing to live use some unique numbers
# So that new values don't affect the calcualtion. THen on 2nd iteration update the proxy values

# from typing import List

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        #Guven
        #  0 -> dead
        #  1 -> live

        # OurUseCase
        # 1 -> 0 : represented as 2
        # 0 -> 1 : represented as 3 
        # so on ext iteration we'll change the 3 to 1 and 2 to 0

        rows = len(board)
        columns = len(board[0])
        for row in range(0,rows):
            for column in range(0,columns):
                liveNeighborCount = self.liveNeighborCount(board,row,column, rows, columns)
                currentItem = board[row][column]
                if currentItem == 1:
                    if liveNeighborCount < 2 or liveNeighborCount>3:
                        board[row][column] = 2
                else:
                    if liveNeighborCount==3:
                        board[row][column] = 3
        
        for row in range(0,rows):
            for column in range(0,columns):
                currentItem = board[row][column]
                if currentItem == 2:
                    board[row][column] = 0
                if currentItem == 3:
                    board[row][column] = 1

    def liveNeighborCount(self,board,row,column, rows, columns):
        directions = [(-1,-1),(0,-1),(1,-1),(-1,0),(1,0),(-1,1),(0,1),(1,1)]
        aliveCount = 0
        for i,j in directions:
            r = row+i
            c = column+j
            if r >= 0 and c >= 0  and r<rows and c < columns:
                if board[r][c] == 1 or board[r][c] == 2:
                    aliveCount+=1
        
        return aliveCount

sol = Solution()
array = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
print(sol.gameOfLife(array))
print(array)