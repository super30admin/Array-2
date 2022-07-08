class Solution:

    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if (len(board) == 0):
            return []
        m= len(board)
        n = len(board[0])
        
        #0 ===> 1 ===>2
        #1 ===> 0 ===>3
        for i in range(m):
            for j in range(n):
                count = self.countlives(board,i,j)
                if(board[i][j]==0):
                    if(count==3):
                        board[i][j]=2
                else:
                    #fewer than 2
                    if(count < 2):
                        board[i][j] = 3
                    if(count > 3):
                        board[i][j] = 3
             
            
        for i in range(m):
            for j in range(n):
                if(board[i][j]==2):
                    board[i][j]=1
                elif(board[i][j]==3):
                    board[i][j]=0
                
                
    def countlives(self,board,r,c):
        m= len(board)
        n = len(board[0])
        count = 0
        dirs=[[0,1],[0,-1],[1,0],[-1,0],[-1,-1],[1,1],[-1,1],[1,-1]]
        for i in dirs:
            nr = r + i[0]
            nc = c + i[1]
            if(nr >=0 and nr < m and nc >=0 and nc < n and (board[nr][nc] == 1 or board[nr][nc]==3)):
                count += 1
            
        
        
        return count
                
                