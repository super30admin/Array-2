# Problem3 (https://leetcode.com/problems/game-of-life/)

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        self.dirs = [[0,-1],[0,1],[-1,0],[1,0],[-1,-1],[-1,1],[1,1],[1,-1]]
        for i in range(len(board)):
            for j in range(len(board[i])):
                count = self.countAlive(board, i, j)
                if board[i][j] == 1 and (count < 2 or count > 3):
                    board[i][j] = 2
                if board[i][j] == 0 and count == 3:
                    board[i][j] = 3
        for i in range(len(board)):
            for j in range(len(board[i])):
                if board[i][j] == 2:
                    board[i][j] = 0
                if board[i][j] == 3:
                    board[i][j] = 1
    def countAlive(self, board, i, j) -> int:
        result = 0
        for direction in self.dirs:
            nr = i + direction[0]
            nc = j + direction[1]
            if nr >= 0 and nc >= 0 and nr < len(board) and nc < len(board[0]) and (board[nr][nc] == 1 or board[nr][nc] == 2):
                result += 1
        return result

#Time complexity O(m*n)
#space complexity O(1)
# if 1 changes to 0, store it as 2(indicates element is 0)
# if 0 changes to 1, store it as 3(indicates element is 1)