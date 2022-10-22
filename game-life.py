# TC: O(size of Matrix)
# SC: O(1)


class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        rows=len(board)
        cols=len(board[0])
        
        direction=[(-1, 0), (1,0), (0,-1), (0, 1), (-1, -1), (-1, 1), (1, -1), (1, 1)]
        
        for i in range(rows):
            for j in range(cols):
                number_of_live_cells=0
                for dir1 in direction:
                    new_row=(i+dir1[0])
                    new_col=(j+dir1[1])
                    
                    if (new_row>=0 and new_row<rows) and (new_col>=0 and new_col<cols) and (board[new_row][new_col]==1 or board[new_row][new_col]==2):
                        number_of_live_cells  +=1
                    
                    
                if board[i][j]==1 and (number_of_live_cells<2 or number_of_live_cells>3):
                    board[i][j]=2
                if board[i][j]==0 and number_of_live_cells==3:
                    board[i][j]=3
                    
        for i in range(rows):
            for j in range(cols):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                     board[i][j] = 1