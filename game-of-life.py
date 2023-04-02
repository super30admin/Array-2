
# Time Complexity : O(m*n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

"""
create a function that counts nearby 1s, Which has dirs array having all 8 directions
take care of the edge cases
"""



class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """

        n = len(board)
        m = len(board[0])
        def getCounts(board,i,j) -> int:
            total = 0
            dirs = [[-1,0],[1,0],[0,-1],[0,1],[-1,-1],[-1,1],[1,-1],[1,1]]
            for Dir in dirs:
                row = i + Dir[0]
                col = j + Dir[1]

                if row >= 0 and row < len(board) and col < len(board[0]) and col >=0 and board[row][col] in [1,2]:
                    total += 1

            return total

        for i in range(n):
            for j in range(m):
                total = getCounts(board, i, j)

                # live cell convert 1 -> 2
                if board[i][j] == 1:
                    if total < 2 or total > 3:
                        board[i][j] = 2
                # dead cell convert 0 -> 3
                if board[i][j] == 0:
                    if total == 3:
                        board[i][j] = 3

        for i in range(n):
            for j in range(m):
                if board[i][j] == 2:
                    board[i][j] = 0

                elif board[i][j] == 3:
                    board[i][j] = 1

    



