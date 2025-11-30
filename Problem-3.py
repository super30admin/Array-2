# Time Complexity : O(mn)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no


# Your code here along with comments explaining your approach
# Traverse the board and mark cells with intermediate states: `2` for live→dead, `3` for dead→live, based on the number of live neighbors.
# Count neighbors by considering cells that were originally alive (`1` or `2`) so that updates are done in-place without affecting the current state.
# In a second pass, finalize the board by converting intermediate states (`2→0`, `3→1`) to get the next state of the Game of Life.

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything; modify board in-place.
        """
        if not board or not board[0]:
            return
        
        m, n = len(board), len(board[0])
        dirs = [(-1,-1), (-1,0), (-1,1), (0,-1), (0,1), (1,-1), (1,0), (1,1)]
        
        # First pass: mark cells with intermediate states
        for i in range(m):
            for j in range(n):
                live_neigh = self.countNeighbours(board, i, j, m, n, dirs)
                
                if board[i][j] == 1:
                    if live_neigh < 2 or live_neigh > 3:
                        board[i][j] = 2  # live -> dead
                else:
                    if live_neigh == 3:
                        board[i][j] = 3  # dead -> live
        
        # Second pass: finalize the board
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1
    
    def countNeighbours(self, board: List[List[int]], i: int, j: int, m: int, n: int, dirs: List[tuple]) -> int:
        count = 0
        for dx, dy in dirs:
            r, c = i + dx, j + dy
            # Explicitly check for original alive cells (1 or 2)
            if 0 <= r < m and 0 <= c < n and (board[r][c] == 1 or board[r][c] == 2):
                count += 1
        return count
