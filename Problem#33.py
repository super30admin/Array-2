'''
289. Game of Life
Link: https://leetcode.com/problems/game-of-life/
Title: Game of Life
'''
'''
Intuition and Approach:
The Game of Life is a cellular automaton devised by mathematician John Conway. The game consists of a grid of cells that can be either alive (1) or dead (0). The state of each cell in the next generation is determined by its current state and the states of its eight neighbors.
To solve this problem, we can use a two-pass approach:
1. **First Pass**: Iterate through the grid and update the state of each cell based on the rules of the game. We can use two additional states to represent transitions:
    - `2` for a live cell that will die in the next generation (currently alive, but will become dead).
    - `3` for a dead cell that will become alive in the next generation (currently dead, but will become alive).   
2. **Second Pass**: Iterate through the grid again and update the cells to their final states based on the values set in the first pass.
This approach allows us to avoid using extra space for a new grid, as we can modify the original grid in place.
'''

# Time Complexity : O(m * n) where m is the number of rows and n is the number of columns in the board.# The algorithm iterates through each cell in the grid twice, leading to a linear time complexity relative
# Space Complexity : O(1) since we are modifying the board in place without using any additional data structures.
# Did this code successfully run on Leetcode : Yes, it runs successfully on Leetcode and for the test cases provided.
# Any problem you faced while coding this : Yes, I faced issues with handling the edge cases where cells are on the borders of the grid and ensuring that we correctly count the live neighbors without going out of bounds.
# Reattempt is required
# Reference: https://leetcode.com/problems/game-of-life/discuss/73264/Python-solution-with-explanation

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if not board or not board[0]: # Check if the board is empty or has no columns
            return # Early exit if the board is empty
        
        rows, cols = len(board), len(board[0]) # Get the number of rows and columns in the board
        
        # First pass: update the states
        for r in range(rows): # Iterate through each row
            for c in range(cols): # Iterate through each column
                live_neighbors = 0 # Initialize the count of live neighbors for the current cell
                
                # Count live neighbors
                for dr in [-1, 0, 1]: # Iterate through the relative row indices of neighbors
                    for dc in [-1, 0, 1]: # Iterate through the relative column indices of neighbors
                        if (dr == 0 and dc == 0) or not (0 <= r + dr < rows and 0 <= c + dc < cols): # Skip the current cell and out-of-bounds neighbors
                            continue # Skip the current cell and out-of-bounds neighbors
                        if board[r + dr][c + dc] in [1, 2]: # Check if the neighbor is alive (1) or marked as live that will die (2)
                            live_neighbors += 1 # Increment the count of live neighbors if the neighbor is alive or marked as live that will die
                # Apply the rules of the Game of Life
                if board[r][c] == 1 and (live_neighbors < 2 or live_neighbors > 3): # If the cell is currently alive and has fewer than 2 or more than 3 live neighbors, it dies
                    board[r][c] = 2 # Mark as live cell that will die
                elif board[r][c] == 0 and live_neighbors == 3: # If the cell is currently dead and has exactly 3 live neighbors, it becomes alive
                    board[r][c] = 3 # Mark as dead cell that will become alive  
        
        # Second pass: finalize the states
        for r in range(rows): # Iterate through each row again
            for c in range(cols): # Iterate through each column again
                if board[r][c] == 2: # If the cell was marked as a live cell that will die
                    board[r][c] = 0 # Live cell that will die becomes dead
                elif board[r][c] == 3: # If the cell was marked as a dead cell that will become alive
                    board[r][c] = 1 # Dead cell that will become alive becomes alive

# Visualize the Game of Life
if __name__ == "__main__":
    board = [
        [0, 1, 0],
        [0, 0, 1],
        [1, 1, 1],
        [0, 0, 0]
    ]
    solution = Solution()
    solution.gameOfLife(board)
    print("Next state of the board:")
    for row in board:
        print(row)
# Output:
# Next state of the board:
# [0, 0, 0]
# [1, 0, 1]
# [0, 1, 1]
# [0, 1, 0] 

# Visualize the dry run of the Game of Life
# Initial board:
# [0, 1, 0]
# [0, 0, 1]
# [1, 1, 1]
# [0, 0, 0]
# After first pass (marking states):
# [0, 2, 0]
# [0, 0, 3]
# [2, 1, 1]
# [0, 0, 0]
# After second pass (finalizing states):
# [0, 0, 0]
# [1, 0, 1]
# [0, 1, 1]
# [0, 1, 0]

