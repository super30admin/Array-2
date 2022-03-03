# TC = 
# m == board.length
# n == board[i].length
# board[i][j] is 0 or 1.
# 1 <= m, n <= 25

# every cell has 8 neighbours 
# if alive has < 2 (less than) alive neighbours it dies (under population)
# if alive has 2 or 3 alive neighbours it remains alive (balanced population)
# if alive cell has >3 neighbours it dies of overpopulation
# if dead cell has ==3 (exactly 3) neighbours it becomes alive

from typing import List

# TC = O(1) + O(m+n) = O(m+n)
# SC = O(1) + O(1) = O(2) = O(1)
class Solution:
    # TC = O(8) = O(1)
    # SC = O(8) = O(1)
    def countAlive(self, board, row, col):
        aliveCellsCount = 0
        positions = [(-1,-1),(-1,0),(-1,1),(0,-1),(0,1),(1,-1),(1,0),(1,1)]
        for x,y in positions:
            r = x + row
            c = y + col
            if  r >= 0 and c >=0 and r < len(board) and c < len(board[0]) and board[r][c] in [1,2]:
                aliveCellsCount += 1
        return aliveCellsCount  
    
    # rows = m | cols = n
    # TC = O(m+n) + O(m+n) = O(2m + 2n) = O(m + n)
    # SC = O(1)
    def gameOfLife(self, board: List[List[int]]) -> None:
        rows = len(board) # num of row
        cols = len(board[0]) #num of col
        
        for row in range(rows):
            for col in range(cols):
                aliveCount = self.countAlive(board, row, col)
                if aliveCount == 3 and board[row][col] == 0:
                    # print([row,col], aliveCount)
                    board[row][col] = 3 
                if not ( 1 < aliveCount < 4) and board[row][col] == 1:
                    print([row,col], aliveCount)
                    board[row][col] = 2
                    
        print(board)
        # # swap the numbers
        for row in range(rows):
            for col in range(cols):
                if board[row][col] == 2: 
                    board[row][col] = 0
                elif board[row][col] == 3: 
                    board[row][col] = 1
        return board
     
sol = Solution()
print(sol.gameOfLife([[0,1,0],[0,0,1],[1,1,1],[0,0,0]]))