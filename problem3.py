class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        for i in range(len(board)):
            for j in range(len(board[0])):
                lives = self.checklives(board,i,j,len(board)-1,len(board[0])-1)
                if (board[i][j]==1 and lives<2):
                    board[i][j] = 3
                elif (board[i][j]==1 and lives>3):
                    board[i][j] = 3
                elif (board[i][j]==0 and lives ==3):
                    board[i][j] = 2

        for i in range(len(board)):
            for j in range(len(board[0])):
                if (board[i][j]==2):
                    board[i][j] = 1
                elif (board[i][j]==3):
                    board[i][j] = 0

    def checklives(self,board,i,j,m,n):
        checklist = [(0,1),(0,-1),(1,0),(-1,0),(-1,-1),(1,1),(-1,1),(1,-1)]
        count = 0
        for k in checklist:
                r = i+ k[0]
                c = j+ k[1]
                if (r>=0 and r<=m and c>=0 and c<=n and (board[r][c] == 1 or board[r][c]==3)):
                    count = count + 1
        return count

            
