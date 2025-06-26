# Time Complexity : O(m * n), where m and n are the dimensions of the board
# Space Complexity : O(1), in-place updates using encoded states
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        rows, cols = len(board), len(board[0])

        # Directions to check all 8 neighbors
        directions = [(-1, -1), (-1, 0), (-1, 1),
                      (0, -1),         (0, 1),
                      (1, -1),  (1, 0),  (1, 1)]

        for r in range(rows):
            for c in range(cols):
                live_neighbors = 0

                # Count live neighbors
                for dr, dc in directions:
                    nr, nc = r + dr, c + dc
                    if 0 <= nr < rows and 0 <= nc < cols and abs(board[nr][nc]) == 1:
                        live_neighbors += 1

                # Apply the rules using temporary states:
                # 1 → live to live, -1 → live to dead
                # 0 → dead to dead, 2 → dead to live
                if board[r][c] == 1:
                    if live_neighbors < 2 or live_neighbors > 3:
                        board[r][c] = -1  # Live to dead
                else:
                    if live_neighbors == 3:
                        board[r][c] = 2  # Dead to live

        # Final pass to update board to next state
        for r in range(rows):
            for c in range(cols):
                if board[r][c] > 0:
                    board[r][c] = 1
                else:
                    board[r][c] = 0
