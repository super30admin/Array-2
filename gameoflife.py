class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """

        row = len(board)
        col = len(board[0])
        dirs = [[0,1],[0,-1],[-1,0],[1,0],[-1,-1],[1,-1],[1,1],[-1,1]]
        def countalive(board,i,j,dirs):
            count = 0
            for m in dirs:
                nr = i+m[0]
                nc = j+m[1]

                if (nr>=0 and nr< row and nc>=0 and nc < col and
                 (board[nr][nc] == 1 or board[nr][nc] == 2)):
                 count+=1
            return count

        for i in range(row):
            for j in range(col):
                count = countalive(board,i,j,dirs)
                if board[i][j] == 1:
                    if (count <2 or count>3):
                        board[i][j] = 2
                else:
                    if count == 3:
                        board[i][j]=3
        for i in range(row):
            for j in range(col):
                if board[i][j] == 2:
                    board[i][j] = 0
                if board[i][j] == 3:
                    board[i][j] = 1



        
        
        