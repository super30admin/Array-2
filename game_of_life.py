# Time Complexity: O(n*m) where n and m are dimensions of the matrix. 
# Space Complexity:  O(1)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No


class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        # 0 ->2
        # 1-> 3
        self.dirs = [[0,1], [0,-1], [1,0], [-1,0], [-1,1], [1,1], [-1,-1], [1, -1]]
        for i in range(len(board)):
            for j in range(len(board[0])):
                aliveCount = self.getAliveCount(board, i, j)
                if board[i][j] == 1:

                    if aliveCount < 2:
                        board[i][j] = 3
                    if aliveCount > 3:
                        board[i][j] = 3
                else:
                    if aliveCount == 3:
                        board[i][j] = 2
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == 3:
                    board[i][j] = 0
                if board[i][j] == 2:
                    board[i][j] = 1
    
    def getAliveCount(self, board, i, j):
        count = 0
        for x, y in self.dirs:
            row = x + i
            col = y + j
            if row >=0 and row < len(board) and col >=0 and col < len(board[0]):
                if board[row][col] == 1 or board[row][col] == 3:
                    count += 1
        return count
