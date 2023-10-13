class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        Time Complexity: O(m x n)
        Space Complexity: O(1)
        Did this code successfully run on Leetcode: Yes
    
        Any problem you faced while coding this: No
        
        """
        # Rule 1: < 2 neighbors = 0 (under population)
        # Rule 2: 2 or 3 neighbors = 1 
        # Rule 3: > 3 neighbors = 0 (over population)
        # Rule 4: = 3 neighbors = 0->1 (reproduces)

        # Neighbors array to find 8 neighbors 
        # Represented as tuple where row=first element, col=second element
        neighbors = [(1,0), (1,-1), (0, -1), (-1, -1), (-1,0), (-1, 1), (0,1), (1,1)]
        rows = len(board)
        cols = len(board[0])

        # Copy of original board
        copy_board = [ [board[row][col] for col in range(cols)] for row in range(rows)]

        # Iterate through board cell by cell 
        for row in range (rows):
            for col in range(cols):
                #for each cell count the number of live neighbors
                live_neighbors = 0
                for neighbor in neighbors:
                    r = (row + neighbor[0]) # first element in each tuple is the row
                    c = (col + neighbor[1]) # second element in each tuple is the column

                    # Is the neighboring cell valid? Was it originally a live cell? Use the copy matrix
                    if (r < rows and r >= 0) and (c < cols and c >= 0) and (copy_board[r][c] == 1):
                        live_neighbors += 1

                # Now apply Rule 1 and 3 where the cell becomes 0
                if (copy_board[row][col] == 1) and (live_neighbors < 2 or live_neighbors > 3):
                    board[row][col] = 0
                # Rule 4
                if (board[row][col]==0) and (live_neighbors == 3):
                    board[row][col] = 1
                # Do not have to do anything explicit for Rule 2
                

