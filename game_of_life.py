class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        :time complexity = O(m*n)
        :1 --> 0 = 2
        :0 --> 1 = 3
        """
        m=len(board)
        n = len(board[0])
        for i in range(m):
            for j in range(n):
                count=self._countLives(board, i, j, m, n)
                if (board[i][j]==1) and (count<2 or count>3):
                    board[i][j]=2  #rule 1 and rule3
                if board[i][j]==0 and count ==3:
                    board[i][j]=3  # rule 4
            
        for i in range(m):
            for j in range(n):
                if board[i][j]==2:
                    board[i][j]=0
                if board[i][j]==3:
                    board[i][j]=1
                    
    def _countLives(self, board, i, j, m, n):
        result=0
        # right, left, bottom, top, bottom_right, bottom_left, top_right, top_left
        dirs = [[0,1],[0,-1],[1,0],[-1,0],[1,1],[1,-1],[-1,1],[-1,-1]]
        for dirr in dirs:
            r=i+dirr[0]
            c = j+dirr[1]
            if r>=0 and r<m and c>=0 and c<n and (board[r][c]==1 or board[r][c]==2):
                result+=1
        return result
        
        