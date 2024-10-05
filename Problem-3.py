#Approach
# change the states of the changing 1->0 as 2 and 0->1 as 3 so that we can change the given input matrix
# By changing the states we are modifing the original live count


# complexities
# Time complexity O(m*n)
# Space Complexity O(1)


from typing import List


class Solution:

    def countNeighbours(self, board, m, n, row, column):
        neighbour_indexes = [-1, 0, 1]
        count = 0
        for i in neighbour_indexes:
            for j in neighbour_indexes:
                if i == 0 and j == 0:
                    continue
                else:
                    nei_row = row + i
                    nei_column = column + j
                    if nei_row >= 0 and nei_row < m and nei_column >= 0 and nei_column < n:
                        if board[nei_row][nei_column] == 2 or board[nei_row][nei_column] == 1:
                            count += 1
        return count

    def gameOfLife(self, board: List[List[int]]) -> None:

        m = len(board)
        n = len(board[0])

        for i in range(m):
            for j in range(n):
                count = self.countNeighbours(board, m, n, i, j)
                if count < 2 or count > 3:
                    if board[i][j] == 1:
                        board[i][j] = 2
                elif count == 3 and board[i][j] == 0:
                    board[i][j] = 3

        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 0
                if board[i][j] == 3:
                    board[i][j] = 1


s = Solution()
s.gameOfLife([[0,1,0],[0,0,1],[1,1,1],[0,0,0]])