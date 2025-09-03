def gameOfLife(self, board: List[List[int]]) -> None: #TC: O(m*n) SC:O(1)
        """
        Do not return anything, modify board in-place instead.
        """
        dir=[(-1,-1),(-1,0),(-1,1),(0,-1),(0,1),(1,-1),(1,0),(1,1)]
        m=len(board)
        n=len(board[0])

        def getcount(i,j):
            count=0
            for dx,dy in dir:
                r=dx+i
                c=dy+j
                if 0<=r<m and 0<=c<n:
                    if board[r][c]==1 or board[r][c]==2:
                        count+=1
            return count

        for i in range(m):
            for j in range(n):
                cnt=getcount(i,j)
                if board[i][j]==0 and cnt==3:
                    board[i][j]=3
                if board[i][j]==1 and (cnt<2 or cnt>3):
                    board[i][j]=2

        for i in range(m):
            for j in range(n):
                if board[i][j]==3:
                    board[i][j]=1
                if board[i][j]==2:
                    board[i][j]=0