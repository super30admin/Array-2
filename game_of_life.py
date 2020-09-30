class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        
        def lives(i,j,board):
            val = 0
            directions = [[-1,-1],[-1,0],[-1,1],[0,-1],[0,1],[1,-1],[1,0],[1,1]]
            for d in directions:
                i_new = i + d[0]
                j_new = j + d[1]
                if ((i_new>=0 and i_new<len(board)) and (j_new>=0 and j_new<len(board[0]))):
                    if ((board[i_new][j_new] == 1) or (board[i_new][j_new]==2)):
                        val+=1
            return val
            
        for i in range(len(board)):
            for j in range(len(board[0])):
                life = lives(i,j,board)
                print(i,j)
                print(life)
                if (board[i][j]==1 and (life<2 or life>3)):
                    board[i][j] = 2
                if (board[i][j]==0 and life==3):
                    board[i][j]=3
        print(board)
        for i in range(len(board)):
            for j in range(len(board[0])):
                board[i][j] = board[i][j]%2
        return board
        
                
                    
        