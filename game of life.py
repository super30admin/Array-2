# // Time Complexity : O(nm)
# // Space Complexity : o(1)
# // Did this code successfully run on Leetcode : yes
# // Three line explanation of solution in plain english:
# Create a list of tuples to calculate neighbouring cells from current cell
# iterate through the matrix and check for the live neighbouring cell and store the count
# change the value of cell to -1 for dead cell and 2 for the revived cell
# iterate again to change the board to 0s and 1s 



class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        
        # Neighbors array to find 8 neighboring cells for a given cell
        neighbors = [(1,0), (1,-1), (0,-1), (-1,-1), (-1,0), (-1,1), (0,1), (1,1)]
        
        rows = len(board)
        cols = len(board[0])
        
        for row in range(rows):
            for col in range(cols):
                
                # count live for each cell
                live = 0
                for neighbor in neighbors:
                    
                    r = row + neighbor[0]
                    c = col + neighbor[1]
                    
                    # check validity of neighbour and if it was a live cell
                    if (r < rows and r >= 0) and (c < cols and c >= 0) and (abs(board[r][c]) == 1):
                        live += 1
                        
                # rule 1 or rule 3, change cell to -1
                if board[row][col] == 1 and (live > 3 or live < 2):
                    board[row][col] = -1
                
                # rule 4, change cell to 2
                if board[row][col] == 0 and (live == 3):
                    board[row][col] = 2
                    
            
        # final representation of the board
        for row in range(rows):
            for col in range(cols):
                if board[row][col] > 0:
                    board[row][col] = 1
                else:
                    board[row][col] = 0