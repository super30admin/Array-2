# TC : O(m * n) ; rows * columns
# SC : O(1) 
# Approach : We loop through rows and columns and call countlives function, through which we calculate next state
# as per mentioned rules. In countLives function, we use dirs array to go to all possible 8 neighbours, and calculate
# next state for the position and update the value. We make 0 -> 2 and 1 -> 3 if state changes, so that we can update
# the matrix again to 0s and 1s before returning.
class Solution:
    # 0 -> 1 -> 2
    # 1 -> 0 -> 3    
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        # copy_board = [[board[row][col] for col in range(cols)] for row in range(rows)]
        if not board or len(board) == 0:
            return
        m = len(board)
        n = len(board[0])
        for i in range(m):
            for j in range(n):
                liveCells = self.countlives(board, i, j)
                if board[i][j] == 1 and (liveCells < 2 or liveCells > 3):
                    board[i][j] = 3
                elif board[i][j] == 0 and liveCells == 3:
                    board[i][j] = 2
                    
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 1
                elif board[i][j] == 3:
                    board[i][j] = 0
                    
                    
    def countlives(self, board, i, j):
        m = len(board)
        n = len(board[0])
        count = 0
        dirs = [[0,-1], [-1,0], [1,1], [-1,-1], [1,0], [0,1], [-1,1], [1,-1]]
        for direction in dirs:
            r = i + direction[0]
            c = j + direction[1]
            
            if r >= 0 and r < m and c >= 0 and c < n and (board[r][c] == 1 or board[r][c] == 3):
                count += 1
                
        return count