class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """

        directions =[[-1,0],[1,0],[0,1],[0,-1],[-1,-1],[1,1],[-1,1],[1,-1]]

        for i in range(len(board)):
            for j in range(len(board[0])):
                count = 0
                for r,c in directions:
                    if(i+r in range(len(board)) and j+c in range(len(board[0]))):
                        if board[i+r][c+j]==2 or board[i+r][c+j]==1:
                            count+=1
                if(count ==3 and board[i][j]==0):
                    board[i][j]=3

                elif( (count<2 or count>3) and board[i][j]==1):
                    board[i][j]=2

        for i in range(len(board)):
            for j in range(len(board[0])):

                if board[i][j]==2:
                    board[i][j] = 0

                elif board[i][j]==3:
                    board[i][j]=1

