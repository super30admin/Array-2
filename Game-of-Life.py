# Problem 2: Game of Life https://leetcode.com/problems/game-of-life/
# Time Complexity: O(m*n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Explanation:
    # - We can solve this problem by using the input board itself to mark the changes.
    # - We iterate through the board and for each cell, we count the number of live neighbors using a function.
    # - Based on the count, we mark the cells that will change state using temporary values.
    # - Finally, we update the board to reflect the new states.


class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])

        # when 1 -> 0: 2
        # when 0 -> 1: 3

        for i in range(m):
            for j in range(n):
                liveNeighbour = self.liveNeighbourCount(board, i, j)
                
                if board[i][j] == 1:
                    if liveNeigbour < 2 or liveNeigbour > 3:
                        board[i][j] = 2
                else:
                    if liveNeighbour == 3:
                        board[i][j] = 3

        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1
                              

    def liveNeighbourCount(self, board: List[List[int]], r: int, c: int) -> int:
        count = 0
        m = len(board)
        n = len(board[0])

        dirs = [[-1, -1], [-1, 0], [-1, 1], [0, -1], [0, 1], [1, -1], [1, 0], [1, 1]]

        for d in dirs:
            nr = r + d[0]
            nc = c + d[1]
            if nr >= 0 and nc >= 0 and nc < n and nr < m and (board[nr][nc]==1 or board[nr][nc]==2):
                count = count+1

        return count


# the following code is the same as above but uses a different approach to mark the changes
# It uses a different marking strategy: Adds 2 or 2×current value to encode next state.
# Final state is decoded by integer division.

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])
        dirs = [(-1,-1), (-1,0), (-1,1), (0,-1), (0,1), (1,-1), (1,0), (1,1)]

        def getCount(i, j):
            count = 0
            for dx, dy in dirs:
                r, c = i + dx, j + dy
                if 0 <= r < m and 0 <= c < n:
                    if board[r][c]%2==1:
                        count += 1
            return count

        for i in range(m):
            for j in range(n):
                liveNeighbour = getCount(i, j)
                if liveNeighbour == 3:
                    board[i][j] += 2
                elif liveNeighbour == 2:
                    board[i][j] += 2*board[i][j]

        for i in range(m):
            for j in range(n):
                board[i][j] //= 2