'''
Time Complexity: O(m,n)
Space Complexity: O(1)
Run on Leetcode: YES
Problems faced: To handle past genrations value in place
'''
class Solution:
    direction = [[-1,-1], [-1,0], [-1,1], [0,-1],[0,1],[1,-1],[1,0],[1,1]]
    def getCount(self, board: list[list[int]], i: int, j: int, rows: int, cols: int):
        count = 0
        for neighbour in self.direction:
            a = i + neighbour[0]
            b = j + neighbour[1]
            if (a in range(0,rows)) and (b in range(0,cols)) and (abs(board[a][b]) == 1):
                count += 1
        return count
        
    def gameOfLife(self, board: list[list[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        # 1 --> 0 is -1
        # 0 --> 1 is 2
        rows = len(board)
        cols = len(board[0])
        for i in range(rows):
            for j in range(cols):
                count = self.getCount(board, i, j, rows, cols)
                # rules for living cell
                if board[i][j] == 1:
                    if count < 2 or 3 < count:
                        board[i][j] = -1
                # rules for dead cell
                else:
                    if count == 3:
                        board[i][j] = 2
        
        # re writing borad with 0s and 1s
        for i in range(rows):
            for j in range(cols):
                if board[i][j] == -1:
                    board[i][j] = 0
                if board[i][j] == 2:
                    board[i][j] = 1