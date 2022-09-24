# Time Complexity: O(mxn)
# Space Complexity: O(1)

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])
        for row in range(m):
            for column in range(n):
                count = self.countalive(board, row, column, m, n)
                if board[row][column] == 1 and (count < 2 or count > 3):
                    board[row][column] = 3
                if board[row][column] == 0 and count == 3:
                    board[row][column] = 2
        # return board
        
        for row in range(m):
            for column in range(n):
                if board[row][column] == 3:
                    board[row][column] = 0
                if board[row][column] == 2:
                    board[row][column] = 1
                
    def countalive(self, board, row, column, m, n):
        dirs = [[0,1], [1,0], [0,-1], [-1,0], [1,-1], [-1,1], [-1,-1], [1,1]]
        count = 0
        for dir_ in dirs:
            nr = row + dir_[0]
            nc = column + dir_[1]
            if (nr >= 0 and nc >= 0 and nr < m and nc < n and (board[nr][nc] == 1 or board[nr][nc] == 3)):
                count += 1
        return count