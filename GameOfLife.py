# Time Complexity --> O(m*n)
# Space Complexity --> O(1)
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        # 1 --> 0 then 2
        # 0 --> 1 then 3
        m = len(board)
        n = len(board[0])

        def helper(r, c):
            dim = [[0,1],[1,0],[-1,0],[0,-1],[-1,-1],[-1,1],[1,-1],[1,1]]

            re = 0
            for i in dim:
                row = r+i[0]
                col = c+i[1]
                if 0<= row <m and 0<= col<n:
                    if board[row][col]==2 or board[row][col]==1:
                        re = re + 1
            return re 

        for i in range(m):
            for j in range(n):
                if board[i][j]==0 and helper(i,j)==3:
                    board[i][j]=3
                elif board[i][j]==1 and helper(i,j)<2:
                    board[i][j]=2
                elif board[i][j]==1 and helper(i,j)>3:
                    board[i][j]=2
                else:
                    pass
        
        for i in range(m):
            for j in range(n):
                if board[i][j]==2:
                    board[i][j]=0
                elif board[i][j]==3:
                    board[i][j]=1 


    
