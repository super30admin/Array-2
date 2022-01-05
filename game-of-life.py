# Time Complexity: O(mn)
# Space Complexity: O(1)
class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        def countAliveFunc(board, i, j):
            result = 0
            for dir in dirs:
                r = i + dir[0]
                c = j + dir[1]
                if (r >= 0 and c >= 0 and r < m and c < n and (board[r][c] == 1 or board[r][c] == 2)):
                    result += 1
            return result

        if not board: return
        m = len(board)
        n = len(board[0])

        dirs = [[0,1], [0,-1], [-1,0], [1,0], [-1,-1], [-1,1], [1,-1], [1,1]]
        for i in range(m):
            for j in range(n):
                countAlive = countAliveFunc(board, i, j)
                # Rule 1 and 3
                if (board[i][j] == 1 and (countAlive < 2 or countAlive > 3)):
                    board[i][j] = 2
                # Rule 4
                if (board[i][j] == 0 and countAlive == 3):
                    board[i][j] = 3
        
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2: board[i][j] = 0
                if board[i][j] == 3: board[i][j] = 1