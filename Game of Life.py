# Time Complexity: O(m*n)
# Space Complexity: O(1) since I'm making in-place edits

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        # State change from 1-> 0 will be denoted as 2
        # State change from 0 -> 1 will be denoted as 3
        m = len(board)
        n = len(board[0])
        # UP     # Down  # Left   # Right  #Topl   #TopR   #BotL   # BotR
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1], [-1, -1], [-1, 1], [1, -1], [1, 1]]

        def getneighborcount(board, i, j):  # Function to get count of 1s from neighbors
            cnt = 0
            for dir in dirs:
                Nrow = (i + dir[0])
                Ncol = (j + dir[1])
                if (Nrow >= 0 and Nrow < m) and (Ncol >= 0 and Ncol < n):
                    if board[Nrow][Ncol] == 1 or board[Nrow][Ncol] == 2:
                        cnt += 1
            return cnt

        for i in range(m):
            for j in range(n):
                count = getneighborcount(board, i, j)
                # print(i,j, "has count", count)
                if board[i][j] == 0:
                    if count == 3:
                        board[i][j] = 3  # State Change
                if board[i][j] == 1:
                    if count < 2 or count > 3:
                        board[i][j] = 2  # State Change

        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 0
                if board[i][j] == 3:
                    board[i][j] = 1

        return board

