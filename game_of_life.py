#TC => o(m*n) 
#SC => o(1) considering directions array as constant

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        #0 ==> 1 ==== 2
        #1 ==> 0 ==== 3
        def count_(board, i, j):
            count = 0
            dirs = [[-1,0], [-1,-1], [-1,1], [0,-1], [0,1], [1,-1], [1,0], [1,1]]
            for z in range(len(dirs)):
                r,c = i+dirs[z][0], j+dirs[z][1]
                if r>=0 and c>=0 and r<=len(board)-1 and c<=len(board[0])-1:
                    if board[r][c] == 1 or board[r][c] == 3:
                        count += 1
            return count
        for i in range(len(board)):
            for j in range(len(board[0])):
                        count = 0
                        count = count_(board, i,j )
                        if board[i][j] == 0 and count == 3:
                            board[i][j] = 2
                        elif board[i][j] == 1: 
                            if count < 2 or count>3:
                                board[i][j] = 3
                        
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == 3:
                    board[i][j] = 0
                elif board[i][j] == 2:
                    board[i][j] = 1
                           