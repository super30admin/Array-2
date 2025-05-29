"""
Approach: mark 0 as -1 if they becoming live and 1 as -2 if they becoming dead
t.c. => O(m*n)
s.c. => O(1)
"""
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        directions = [[0,1],[1,0], [-1,0],[0,-1],[-1,-1],[1,1],[-1,1],[1,-1]]
        for i in range(len(board)):
            for j in range(len(board[0])):
                live = 0
                dead = 0
                for x, y in directions:
                    newX, newY = x + i, y + j
                    if newX < 0 or newY < 0 or newX >= len(board) or newY >= len(board[0]):
                        continue
                    if board[newX][newY] == 1 or board[newX][newY] == -2:
                        live += 1
                    else:
                        dead += 1
                if board[i][j] == 1 and (live < 2 or live > 3):
                    board[i][j] = -2
                elif board[i][j] == 0 and live == 3:
                    board[i][j] = -1
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == -1:
                    board[i][j] = 1
                if board[i][j] == -2:
                    board[i][j] = 0
        return board