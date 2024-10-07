#T.C = O(m*n) S.C = O(1)
class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """

        m = len(board)
        n = len(board[0])
        dirs = [[0,-1],[0,1],[-1,0],[1,0],[-1,-1],[-1,1],[1,-1],[1,1]]

        for i in range(m):
            for j in range(n):
                count = self.countAlive(dirs,board,i,j,m,n)
                if(board[i][j]==1):
                    if(count<2 or count>3):
                        board[i][j] = 2
                elif(board[i][j]==0):
                    if(count == 3):
                        board[i][j] = 3

        for i in range(m):
            for j in range(n):
                if(board[i][j]==2):
                    board[i][j] = 0
                elif(board[i][j]==3):
                    board[i][j] = 1

    def countAlive(self,dirs,board,i,j,m,n):
        count = 0
        for dir in dirs:
            r = dir[0]+i
            c = dir[1]+j
            if(r>=0 and c>=0 and r<m and c<n):
                if(board[r][c]==1 or board[r][c]==2):
                    count+=1
                
        return count            
    
        