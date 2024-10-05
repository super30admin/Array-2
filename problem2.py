# time complexity: O(n)
# space complexity: O(1)

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])

        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0], [-1, 1], [1, -1], [-1, -1], [1, 1]]

        #checking and converting
        for i in range(m):
            for j in range(n):
                count = self.countAlive(board, i, j, dirs, m, n)
                if board[i][j] == 1:
                    if count < 2 or count > 3:
                        board[i][j] = 2     # alive to dead
                elif board[i][j] == 0:
                    if count == 3:
                        board[i][j] = 3     # dead to alive
        
        # converting back to 0, 1
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1


    # checking alive 
    def countAlive(self, board: List[List[int]], i: int, j: int, dirs: List[List[int]], m: int, n: int) -> int:
        count = 0
        for dir in dirs:
            r = dir[0] + i
            c = dir[1] + j

            if r>=0 and c>=0 and r<m and c<n:
                if board[r][c] == 1 or board[r][c] == 2:
                    count += 1
        return count