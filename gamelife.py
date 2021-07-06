#https://leetcode.com/problems/game-of-life/
#time-o(m*n)
#space-o(1)
class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        a=[[0,-1],[0,1],[-1,0],[1,0],[-1,-1],[-1,1],[1,-1],[1,1]]
        #print(type(a))
        n=len(board)
        m=len(board[0])
        for row in range(0,n):
            for col in range(0,m):
                live=0
                for neigh in a:
                    r=row+neigh[0]
                    c=col+neigh[1]
                    if (r<n and r>=0) and (c<m and c>=0) and abs(board[r][c])==1:
                        live+=1
                if board[row][col]==1 and (live<2 or live>3):
                        board[row][col]=-1
                if board[row][col]==0 and live==3:
                        board[row][col]=5
        for i in range(n):
            for j in range(m):
                if board[i][j]>0:
                    board[i][j]=1
                else:
                    board[i][j]=0
        return board