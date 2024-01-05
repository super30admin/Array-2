'''
Time complexity: O(mxn)
Space complexity: O(1), because result is stored in the same array.
'''
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        near_elems = [[0, -1],[0, 1],[-1, 0],[1, 0],[-1, -1], [-1, 1], [1, 1], [1, -1]]

        def countAlive(board, i, j):
            count = 0
            for idx in near_elems:
                nr = i+idx[0]
                nc = j+idx[1]
                if (nr < len(board) and nc < len(board[0]) and nr >= 0 and nc >= 0):
                    if (board[nr][nc]==1 or board[nr][nc]==2):
                        count += 1

            return count

        cols = len(board[0])
        for i in range(len(board)):
            for j in range(cols):
                count = countAlive(board, i, j)
        
                if (board[i][j]==1 and (count<2 or count>3)):
                    board[i][j]=2
                if board[i][j]==0 and (count==3):
                    board[i][j]=3

        for i in range(len(board)):
            for j in range(cols):

                if board[i][j]==2:
                   board[i][j]=0
                if board[i][j]==3:
                   board[i][j]=1 