# Time Complexity : O(m * n), where m = number of rows, n = number of columns
# Space Complexity : O(1) since we modify the board in-place without extra memory
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : No

from typing import List

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        if not board or not board[0]:
            return

        rows, cols = len(board), len(board[0])
        
        # Directions to the 8 neighbors
        directions = [(-1, -1), (-1, 0), (-1, 1),
                      (0, -1),          (0, 1),
                      (1, -1),  (1, 0), (1, 1)]

        for r in range(rows):
            for c in range(cols):
                live_neighbors = 0

                for dr, dc in directions:
                    nr, nc = r + dr, c + dc
                    if 0 <= nr < rows and 0 <= nc < cols:
                        if abs(board[nr][nc]) == 1:  # count original live cells
                            live_neighbors += 1

                # Rule 1 or 3: live → dead
                if board[r][c] == 1 and (live_neighbors < 2 or live_neighbors > 3):
                    board[r][c] = -1
                # Rule 4: dead → live
                elif board[r][c] == 0 and live_neighbors == 3:
                    board[r][c] = 2

        # Final pass to clean up
        for r in range(rows):
            for c in range(cols):
                if board[r][c] > 0:
                    board[r][c] = 1
                else:
                    board[r][c] = 0


if __name__ == "__main__":
    sol = Solution()

    # Example 1
    board1 = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
    sol.gameOfLife(board1)
    print("Output for Example 1:")
    print(board1)  # Expected: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]

    # Example 2
    board2 = [[1,1],[1,0]]
    sol.gameOfLife(board2)
    print("Output for Example 2:")
    print(board2)  # Expected: [[1,1],[1,1]]
