# Author: Naveen US
# Titile: Game of life.

# Time complexity: O(m*n)
# Space complexity: O(1)
# Did the code run on leetcode: Yes

# To make the updation in place we first change the ones to 2 when they have to be changed to 0 accoring to the rules. 
# similary we change the 0s to 3 when they are to be changed to 1. By doing this we have track of what was the original number which is required when we want to change all the numbers inplace.
# we then pass though the matrix again to change the 2s and 3s to 0s and 1s respectively.

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        m,n=len(board),len(board[0])
        # 1 -> 0 = 2
        # 0 -> 1 = 3
        dir = [[-1,-1],[-1,0],[-1,1],[0,1],[1,1],[1,0],[1,-1],[0,-1]]
        for i in range(m):
            for j in range(n):
                result=0
                for k in dir:
                    c,r = i + k[0], j + k[1]
                    if (0<=c<m and 0<=r<n):
                        if (board[c][r]==1 or board[c][r]==2):
                            result +=1
                if board[i][j]==1 and (result<2 or result>3):
                        board[i][j]=2
                elif board[i][j]==0 and result==3:
                    board[i][j]=3
        for i in range(m):
            for j in range(n):
                if board[i][j]==2: board[i][j]= 0
                elif board[i][j]==3: board[i][j]= 1
        return
