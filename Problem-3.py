'''
    Time Complexity: O(2mn)
    Space Complexity: O(1)
    Ran successfully on leetcode
    Approach: Iterate through the board and simulate the rules by getting the live neighbors. 
            Change the state using temp values and iterate again to change it back
'''
class Solution:
    def getLiveNeighbors(self, directions, board, i, j, m, n):
        liveNeighbors = 0

        for direction in directions:
            r = i + direction[0]
            c = j + direction[1]

            if 0 <= r < m and 0 <= c < n:
                if board[r][c] == 1 or board[r][c] == 2:
                    liveNeighbors += 1

        return liveNeighbors

    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])
        directions = [(-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1)]

        for i in range(m):
            for j in range(n):
                liveNeighbors = self.getLiveNeighbors(directions, board, i, j, m, n)

                if board[i][j] == 1:
                    if liveNeighbors < 2 or liveNeighbors > 3:
                        board[i][j] = 2 #live -> dead
                else:
                    if liveNeighbors == 3:
                        board[i][j] = 3 #dead -> live

        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 0 
                elif board[i][j] == 3:
                    board[i][j] = 1