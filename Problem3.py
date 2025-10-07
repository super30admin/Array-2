# Time Complexity : O(m * n)
# Space Complexity : O(1)   # done in-place, no extra grid used
# Did this code successfully run on LeetCode : Yes
# Any problem you faced while coding this : 
#   Needed to carefully handle transitional states (1->0 and 0->1)


class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """

        # All 8 possible directions around a cell
        dirs = [(-1, -1), (-1, 0), (-1, 1),(0, -1),(0, 1),(1, -1),  (1, 0),  (1, 1)]

        # m = number of rows, n = number of columns
        m, n = len(board), len(board[0])

        
        # Helper function to count live neighbors for cell (i, j)
        def getCount(i, j):
            count = 0
            for dx, dy in dirs:
                r, c = i + dx, j + dy
                # Check if neighbor is within grid boundaries
                if 0 <= r < m and 0 <= c < n:
                    # Count cells that are currently alive (1)
                    # or were alive but are marked to die (2)
                    if board[r][c] == 1 or board[r][c] == 2:
                        count += 1
            return count

        # First pass: determine next state for each cell
        # Encode transitions without disturbing neighbors:
        #   1 -> 0 becomes 2 (was live, will die)
        #   0 -> 1 becomes 3 (was dead, will become live)
    
        for i in range(m):
            for j in range(n):
                cnt = getCount(i, j)

                # Rule 4: Dead cell with exactly 3 live neighbors -> becomes live
                if board[i][j] == 0 and cnt == 3:
                    board[i][j] = 3
                # Rule 1 & 3: Live cell with <2 or >3 live neighbors -> dies
                elif board[i][j] == 1 and (cnt < 2 or cnt > 3):
                    board[i][j] = 2

    
        # Second pass: finalize the board by decoding temporary states
    
        for i in range(m):
            for j in range(n):
                # 3 means dead -> live, set to 1
                if board[i][j] == 3:
                    board[i][j] = 1
                # 2 means live -> dead, set to 0
                elif board[i][j] == 2:
                    board[i][j] = 0
