
TC-> o(m*n)
Sc-> O(1)


class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        #1->0 2
        #0->1 3
        m = len(board)
        n = len(board[0])
        # self.dirs = [[0,1],[0,-1],[-1,0],[1,0],[-1,-1],[-1,1],[1,-1],[1,1]]

        for i in range(m):
            for j in range(n):
                countAlive = self.__countAlive(board,i,j,m,n)
                if board[i][j] == 1 and (countAlive < 2 or countAlive>3):
                    board[i][j] = 2
                if board[i][j] == 0 and countAlive == 3:
                    board[i][j] = 3
        
        #return back the original states
        for i in range(m):
            for j in range(n):
                if board[i][j]==2:
                    board[i][j]=0
                if board[i][j]==3:
                    board[i][j]=1

    def __countAlive(self,board,i,j,m,n):
        result = 0
        dirs = [[0,1],[0,-1],[-1,0],[1,0],[-1,-1],[-1,1],[1,-1],[1,1]]
        for dir in dirs:
            r = i + dir[0]
            c = j + dir[1]
            if (r>=0 and c>=0 and r < m and c < n and (board[r][c]==1 or board[r][c]==2)):
                result = result + 1
        
        return result