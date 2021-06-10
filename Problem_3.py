from typing import List

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> List[List[int]]:
        if board == None or len(board) == 0 or len(board[0]) == 0:
            return [[]]
        m = len(board)
        n = len(board[0])
        # 0 -> 1 -> 2
        # 1 -> 0 -> 3
        for r in range(m):
            for c in range(n):
                lives = self.countLives(board, r, c, m, n)
                if board[r][c] == 1:
                    if lives < 2 or lives > 3:
                        board[r][c] = 3
                if board[r][c] == 0:
                    if lives == 3:
                        board[r][c] = 2
                     
        for r in range(m):
            for c in range(n):
                if board[r][c] == 2:
                    board[r][c] = 1
                if board[r][c] == 3:
                    board[r][c] = 0

        return board
                    
    def countLives(self, board: List[List[int]], r: int, c: int, m: int, n:int) -> int:
        dirs = [[0,-1],[0,1],[1,0],[-1,0],[-1,-1],[-1,1],[1,1],[1,-1]]
        lives = 0
        for dir in dirs:
            i = r + dir[0]
            j = c + dir[1]
            if i >= 0 and i < m and j >= 0 and j < n and (board[i][j] == 1 or board[i][j] == 3):
                lives += 1
        return lives

obj = Solution()
print(obj.gameOfLife([[0,1,0],[0,0,1],[1,1,1],[0,0,0]]))
print(obj.gameOfLife([[1,1],[1,0]]))

# Time Complexity = O(m * n)
# Space Complexity = O(1)