# Time Complexity : O(m+n)
# Space COmplexity: O(1)
# Approach to solve this problem:
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        rows, cols = len(board), len(board[0])
        
        def countNeighbors(r, c):                                     # Count of a neighbors
            nei = 0
            for i in range(r-1, r+2):                                 # For iteration
                for j in range(c-1,c+2):
                    if ((i==r and j==c) or i < 0 or j < 0 or i == rows or j == cols):
                        continue
                    if board[i][j] in [1,3]:
                        nei += 1
            return nei
        
        for r in range(rows):
            for c in range(cols):
                nei = countNeighbors(r, c)
                if board[r][c]:
                    if nei in [2,3]:                 # If it was originally alive
                        board[r][c] = 3
                elif nei == 3:                       # If it was death and became alive
                    board[r][c] = 2
                    
        for r in range(rows):
            for c in range(cols):
                if board[r][c] == 1:                 # If it was alive and became death
                    board[r][c] = 0
                elif board[r][c] in [2,3]:
                    board[r][c] = 1