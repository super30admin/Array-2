# Time complexity = O(m*n)
# Space complexity = O(1)
# Tested on leetcode
# neither DFS or BFS as we are not exploring neighbors neighbor
# Do not convert 0 - 1 directly just mark it as 3 and for 1 - 0 mark it as 3 and count the live neighbors
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])
        # 0 - 1 - 3
        # 1 - 0 = 2
        dirs = [[0,1], [1,0], [-1,0], [0,-1], [-1,-1], [1,1], [1,-1],[-1,1]]
        def countAlive(board, i, j , dir):
            count = 0
            for x,y in dirs:
                r,c = i+x, j+y
                if 0 <= r < len(board) and 0 <= c < len(board[0]):
                    if (board[r][c] == 1 or board[r][c] == 2):
                        count += 1
            return count

        for i in range(m):
            for j in range(n):
                count = countAlive(board, i, j , dir)
                if board[i][j] == 1:
                    if count < 2 or count > 3:
                        board[i][j] = 2
                else:
                    if count == 3:
                        board[i][j] = 3
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1
        return board      


