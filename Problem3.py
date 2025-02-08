# 289. Game of Life

# Time Complexity: O(m * n)
# Space Complexity: O(1)

# Approach:
# Use a single loop to find both the minimum and maximum.
# Compare the current element with the current minimum and maximum to update them accordingly.


class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if not board:
            return
        
        rows = len(board)
        cols = len(board[0])

        # prevstate -> newstate : indicator
        # 0 -> 1 : 2
        # 1 -> 0 : 3

        for i in range(rows):
            for j in range(cols):
                count = self.countLiveNeighbors(board, i, j)

                if board[i][j] == 1 and (count < 2 or count > 3):
                    board[i][j] = 3
                elif board[i][j] == 0 and count == 3:
                    board[i][j] = 2
                    
                    
    def countLiveNeighbors(self, board: List[List[int]], i: int, j: int) -> int:
        count = 0
        directions = [(-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1)]
        
        for dx, dy in directions:
            x = i + dx
            y = j + dy

            if x >= 0 and x < len(board) and y >= 0 and y < len(board[0]) and (board[x][y] == 1 or board[x][y] == 3):
                count += 1

        return count
