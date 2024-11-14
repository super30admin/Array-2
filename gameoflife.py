class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        # 2 - dead -> alive
        # 3 - alive ->dead
        m = len(board)
        n = len(board[0])
        for i in range(m):
            for j in range(n):
                count0 = 0
                count1 = 0
                for x in range(i-1,i+2):
                    for y in range(j-1,j+2):
                        if (x != i or y != j) and (x>=0 and x<=m-1) and (y>=0 and y<=n-1):
                            if board[x][y]==0 or board[x][y]==2:
                                count0 += 1
                            else:
                                count1 += 1
                if board[i][j]==0 and count1 == 3:
                    board[i][j]=2
                elif board[i][j]==1 and (count1 < 2 or count1 > 3):
                    board[i][j]=3
        for i in range(0,m):
            for j in range(0,n):
                if board[i][j]== 2:
                    board[i][j]=1
                elif board[i][j]==3:
                    board[i][j]=0





        