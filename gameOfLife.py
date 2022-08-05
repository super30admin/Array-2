class Solution:#time O(n^2) space O(1)

    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        di=[[-1,-1],[-1,0],[-1,1],[0,-1],[0,1],[1,-1],[1,0],[1,1]]
        for i in range(len(board)):
            for j in range(len(board[0])):
                l=0
                for x in di:
                    if i+x[0]<0 or i+x[0]>=len(board) or j+x[1]<0 or j+x[1]>=len(board[0]):
                        continue
                    if board[i+x[0]][j+x[1]]==1 or  board[i+x[0]][j+x[1]]==2:
                        l+=1

                if (l<2 or l>3) and board[i][j]==1:
                    board[i][j]=2
                if l==3 and board[i][j]==0:
                    board[i][j]=3

        for i in range(len(board)):
            for j in range(len(board[0])):
                board[i][j]%=2
