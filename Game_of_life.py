class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        d=[(1,0), (1,-1), (0,-1), (-1,-1), (-1,0), (-1,1), (0,1), (1,1)]
        for i in range(len(board)):
            for j in range(len(board[0])):
                lives=0
                for di in d:
                    r = (i + di[0])
                    c = (j + di[1])
                    if r<0 or r>=len(board) or c<0 or c>=len(board[0]):
                        continue
                    if board[r][c]==1 or board[r][c]==3:
                        lives+=1
                if board[i][j]==1 and (lives<2 or lives>3):
                    board[i][j]=3;
                if board[i][j]==0 and lives==3:
                    board[i][j]=2
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j]==2:
                    board[i][j]=1
                if board[i][j]==3:
                    board[i][j]=0
#Time Complexity: O(M*N) where M is number of rows & N is number of columns
#Space Complexity: O(1)