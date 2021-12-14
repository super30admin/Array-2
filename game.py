#time complexity: O(mxn)
#space complexity: O(1)

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if board==None or len(board)==0: return []
        
        def count_lives(board, r, c):
            dirs=[[-1,-1],[-1,0],[-1,1],[0,-1],[0,1],[1,-1],[1,0],[1,1]]
            count=0
            
            for i in dirs:
                new_r=r+i[0]
                new_c=c+i[1]
                
                if(new_r>=0 and new_r<m and new_c>=0 and new_c<n and (board[new_r][new_c]==1 or board[new_r][new_c]==2)):
                    count=count+1
            return count
        
        m=len(board)
        n=len(board[0])
        #1-0->2
        #0-1->3
        
        for i in range(m):
            for j in range(n):
                lives=count_lives(board, i, j)
                if board[i][j]==1:
                    if (lives<2 or lives>3):
                        board[i][j]=2
                        
                else:
                    if lives==3:
                        board[i][j]=3
                        
        for i in range(m):
            for j in range(n):
                if board[i][j]==2:
                    board[i][j]=0
                elif board[i][j]==3:
                    board[i][j]=1