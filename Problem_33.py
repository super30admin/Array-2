# Time Complexity : O(m*n)
# Space Complexity : O(1) or  constant auxiliary space is needed

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])
        
        directions = [(-1,-1),(-1,0),(-1,1),(0,-1),(0,1),(1,-1),(1,0),(1,1)]
        # Directions cover all 8 neighbours' indices wrt to a given r and c
        
        for r in range(m):
            for c in range(n):
                # print(r,c)
                count = self.aliveNeighbours(board,directions,r,c) # Call aliveNeighbours function to get count
                # print(r,c,count)
                if(board[r][c] == 1 and (count < 2 or count > 3)):
                    # If the current cell is alive we encounter rules 1 and 3
                    board[r][c] = 2 # Alive cell (1) should be dead, so let's denote this with 2 
                    # 2 now refers to all cells who were alive in the original matrix but died in the changed resultant matrix
                elif(board[r][c] == 0 and count == 3):
                    # If current cell is dead and we encounter rule 4
                    # Assign 3 for this cell. 3 refers to a cell which was 0 in the original matrix and became 1 in result
                    board[r][c] = 3
        for r in range(m):
            for c in range(n):
                if board[r][c] == 2:
                    board[r][c] = 0 # AFter all elements are calculated we change all 2s to 0 as these are now dead cell
                elif board[r][c] == 3:
                    board[r][c] = 1 # And 3s to 1 because these are now alive
    def aliveNeighbours(self,board,directions,r,c):
        count = 0
        for i in directions:
            row = r + i[0]
            column = c + i[1] # Add each of the neighbour pairs' corresponding values to the current cell's r and c
            if row >= 0 and row < len(board) and column >= 0 and column < len(board[0]):
                # Check boundary conditions
                if board[row][column] == 1 or board[row][column] == 2: # Value of 1 or 2 means in the input matrix the value was 1, so we increment count
                    count += 1
        return count