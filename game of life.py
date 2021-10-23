# TC-O(m*n)
# SC-O(1)
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        directions= [[-1 ,-1] ,[-1 ,0] ,[-1 ,1] ,[0 ,-1] ,[0 ,1] ,[1 ,1] ,[1 ,0] ,[1 ,-1]]


        for i in range(0 ,len(board)):
            for j in range(len(board[0])):
                live =0

                for d in directions:
                    if 0 <= i+ d[0] < len(board) and 0 <= j + d[1] < len(board[0]):
                        if board[i + d[0]][j + d[1]] == 1 or board[i + d[0]][j + d[1]] == 3:
                            live += 1

                if board[i][j] == 1:
                    if live < 2:
                        board[i][j] = 3
                    if live > 3:
                        board[i][j] = 3

                elif board[i][j] == 0:
                    if live == 3:
                        board[i][j] = 2

        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == 2:
                    board[i][j] = 1
                if board[i][j] == 3:
                    board[i][j] = 0
