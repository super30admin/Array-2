class Solution:
    def n_neighbors(self, board, m, n):
        count = 0
        rows = len(board)
        cols = len(board[0])
        new_row = 0
        new_col = 0
        direction_array = [(1,-1), (1,0), (-1,-1), (-1,0),(-1,1),(0,-1),(0,1),(1,1)]

        for dirs in direction_array:
            new_row = (m + dirs[0])
            new_col = (n + dirs[1])
            if (new_row >= 0 and new_row < rows and  new_col >= 0 and new_col < cols ) and (board[new_row][new_col] == 1 or board[new_row][new_col] == 2):
                count+=1
        #print(count)        
        return count
 
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if not board or len(board)==0:
            return 

        rows = len(board)
        cols = len(board[0])
        #lives = 0
        

        for i in range(rows):
            for j in range(cols):
                lives = self.n_neighbors(board,i,j)
                
                # Rule 1 and Rule 3
                if board[i][j]==1 and (lives <2 or lives >3):
                    board[i][j]= 2 # -1 signifies the cell is now dead but originally was live.
                if board[i][j]== 0 and lives ==3:
                    board[i][j]=3 # signifies the cell is now live but was originally dead.

        for i in range(rows):
            for j in range(cols):
                board[i][j] = board[i][j]%2
        return board
    


                

                
    




        