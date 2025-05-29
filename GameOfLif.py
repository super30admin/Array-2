#Time Complexity - o(m*n)
# Space Complexity - o(1)

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        
        m = len(board)
        n = len(board[0])

        for i in range(m):
            for j in range(n):

                count = self.countAlive(board, i, j)
                print('count - ',count)

                if board[i][j] == 1:
                    if count < 2 or count > 3:
                        board[i][j] = 5
                elif board[i][j] == 0:
                    if count == 3:
                        board[i][j] = 4

        for i in range(m):
            for j in range(n):
                if board[i][j] == 4:
                    board[i][j] = 1
                elif board[i][j] == 5:
                    board[i][j] = 0

    def countAlive(self, board, r, c):

        dir = [[0,1],[0,-1],[1,0],[-1,0],[1,1],[-1,-1],[1,-1],[-1,1]]
        m = len(board)
        n = len(board[0])
        count = 0

        for dr, dc in dir:
            row = r+dr
            col = c+dc

            if row>-1 and row <m and col>-1 and col<n:
                if board[row][col]==1 or board[row][col]==5:
                    count+=1
        return count

