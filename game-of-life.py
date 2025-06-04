# Problem: The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article): Given the current state of the board, update the board to reflect its next state.

# Solution: 
# Time Complexity : O(m*n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m, n = len(board), len(board[0])
        # calculate new state, use placeholders for new 1 & 0 to avoid confusion
        for i in range(m):
            for j in range(n):
                # helper function to find alive neighbors
                count = self.count_alives(board, i, j)
                if board[i][j] == 1 and (count <2 or count>3):
                    board[i][j] = 5 # need to die, 5 is dead
                if board[i][j] == 0 and (count == 3):
                    board[i][j] = 4 # need to live, 4 is live
        # Swap out 5's and 4's
        for i in range(m):
            for j in range(n):
                if board[i][j] == 5: 
                    board[i][j] = 0
                if board[i][j] == 4:
                    board[i][j] = 1

    def count_alives(self, board, r, c):
        # directions array   r        l         u      d        ur        ul       dr      dl
        directions_array = [[0,1], [0, -1], [-1, 0], [1, 0], [-1, 1], [-1, -1], [1, 1], [1, -1] ]
        alives = 0
        for dr, dc in directions_array:
            nr, nc = r + dr, c + dc
            if 0 <= nr < len(board) and 0 <= nc < len(board[0]):
                if board[nr][nc] == 1 or board[nr][nc] == 5:
                    alives += 1
        return alives