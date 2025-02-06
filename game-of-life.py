# Time : O(n*m)
# Space: O(1)
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        n = len(board[0])
        m = len(board)
        for i in range(m): #rows
            for j in range(n): # columns
                count = self.getAliveCount(board, i, j, n, m)
                if board[i][j] == 1 and (3 < count or count < 2) :
                    board[i][j] = 2
                if board[i][j] == 0 and count == 3:
                    board[i][j] = 3
        for i in range(m): #rows
            for j in range(n): # columns
                if board[i][j] == 2:
                    board[i][j] = 0
                if board[i][j] == 3:
                    board[i][j] = 1


    def getAliveCount(self, board, i, j, n, m):
        directions = [[0, 1], [0, -1], [-1, 0], [1, 0], [-1,-1], [-1, 1], [1, -1], [1, 1]]
        count = 0
        for dirc in directions:
            i1 = i + dirc[0]
            j1 = j + dirc[1]

            if 0 <= i1 < m and 0 <= j1 < n:
                if board[i1][j1] == 1 or board[i1][j1] == 2:
                    count += 1

        return count