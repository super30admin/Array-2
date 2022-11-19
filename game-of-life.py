#TC: O(m*n)
#SC: O(1)
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        dirs=[-1,1,0]
        for i in range(len(board)):
            for j in range(len(board[i])):
                alive=0
                for dirx in dirs:
                    for diry in dirs:
                        if (not (dirx==0 and diry==0)) and 0<=i+dirx<len(board) and 0<=j+diry<len(board[i]):
                            neighbour=board[i+dirx][j+diry]
                            alive+= 1 if neighbour==1 or neighbour==3 else 0
                if board[i][j]==0 and alive==3: 
                    board[i][j]=2
                elif board[i][j]==1 and (alive<2 or alive>3): 
                    board[i][j]=3

        for i in range(len(board)):
            for j in range(len(board[i])):
                if board[i][j]==2: board[i][j]=1
                elif board[i][j]==3: board[i][j]=0
