# // Time Complexity : O(M*N)
 # // Space Complexity : O(1)
 # // Did this code successfully run on Leetcode : Yes

class Solution:
    def gameOfLife(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        r, c = len(matrix), len(matrix[0])
        directions = [(0, 1), (0, -1), (1, 0), (-1, 0), (1, 1), (1, -1), (-1, 1), (-1, -1)]
        for i in range(r):
            for j in range(c):
                # 0->1 - -1
                # 1->0 - 2
                da = self.checkNeighbours(matrix, directions, i, j)
                if da < 2 and matrix[i][j] == 1:
                    matrix[i][j] = 2
                elif da > 3 and matrix[i][j] == 1:
                    matrix[i][j] = 2
                elif da == 3 and matrix[i][j] == 0:
                    matrix[i][j] = -1
        for i in range(r):
            for j in range(c):
                if matrix[i][j] == -1:
                    matrix[i][j] = 1
                elif matrix[i][j] == 2:
                    matrix[i][j] = 0
        return matrix

    def checkNeighbours(self, board, directions, r, c):
        count = 0
        for x, y in directions:
            nx, ny = r + x, c + y
            if 0 <= nx < len(board) and 0 <= ny < len(board[0]):
                if board[nx][ny] > 0:
                    count += 1
        return count