class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        Space Complexity: O(1), Time Complexity: O(n^2)
        """
        # -1 will turn to 1
        # 2 will turn to 0
        for i in range(0,len(board)):
            for j in range(0,len(board[0])):
                c = 0
                if(i>0 and board[i-1][j]>=1):
                    c+=1
                if(i>0 and j>0 and board[i-1][j-1]>=1):
                    c+=1
                if(i>0 and j<len(board[0])-1 and board[i-1][j+1]>=1):
                    c+=1
                if(j>0 and board[i][j-1]>=1):
                    c+=1
                if(j<len(board[0])-1 and board[i][j+1]>=1):
                    c+=1
                if(i< len(board)-1 and board[i+1][j]>=1):
                    c+=1
                if(i< len(board)-1 and j<len(board[0])-1 and board[i+1][j+1]>=1):
                    c+=1
                if(i<len(board)-1 and j>0 and board[i+1][j-1]>=1):
                    c+=1
                if(c<2 or c>3):
                    if(board[i][j]==1):
                        board[i][j] = 2
                
                if(c==3):
                    if(board[i][j]==0):
                        board[i][j] = -1
        
        for i in range(0,len(board)):
            for j in range(0,len(board[0])):
                if(board[i][j]==2):
                    board[i][j]=0
                if(board[i][j]==-1):
                    board[i][j]=1
