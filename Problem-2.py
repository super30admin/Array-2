class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        #0-->1-->3
        #1-->0-->2

        if board is None or len(board)==0:
            return
        m = len(board); n=len(board[0])

        def countLives(board,i,j):
            count=0
            dirs = [[-1,0],[0,1],[1,0],[0,-1],[-1,1],[1,-1],[-1,-1],[1,1]]
            for d in dirs:
                r = i+d[0]
                c = j+d[1]
                if (r>=0 and c>=0 and r<m and c<n and (board[r][c] ==1 or board[r][c]==2)):
                    count+=1
            return count



        for i in range(m):
            for j in range(n):
                lives = countLives(board,i,j)

                #rule 1 and 3
                if (board[i][j]==1 and (lives <2 or lives >3)):
                    board[i][j] = 2
                #rule 4
                if (board[i][j]==0 and lives ==3):
                    board[i][j] = 3

        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 0

                if board[i][j]==3:
                    board[i][j] =1
        
