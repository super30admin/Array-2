"""

Time Complexity : o(2nm)
Space Complexity :O(N)
Did this code successfully run on Leetcode :yes
Any problem you faced while coding this :no


Approach
we are travesing all the numbers one by one and checking for the rules
and according to that we are changing the value, we are comparing all the 8 possible values

and to do the change in place we are changing value to 2 and 3 as temp so was to keep track of all the value before and after mutation

"""




class Solution:
    def countalive(self, board: List[List[int]], r: int, c: int) -> int:
        m, n = len(board), len(board[0])
        dirs = [(0,1),(0,-1),(-1,0),(1,0),(-1,1),(-1,-1),(1,1),(1,-1)]
        count = 0
        for dr, dc in dirs:
            nr, nc = r + dr, c + dc
            if 0 <= nr < m and 0 <= nc < n and (board[nr][nc] == 1 or board[nr][nc] == 2):
                count += 1
        return count

    def gameOfLife(self, board: List[List[int]]) -> None:
        m, n = len(board), len(board[0])

        # 1st pass: mark transitions
        for i in range(m):
            for j in range(n):
                alive_neighbors = self.countalive(board, i, j)
                if board[i][j] == 1 and (alive_neighbors < 2 or alive_neighbors > 3):
                    board[i][j] = 2  
                elif board[i][j] == 0 and alive_neighbors == 3:
                    board[i][j] = 3  

        # 2nd pass: finalize
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1
