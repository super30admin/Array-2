# // Time Complexity :O(nm)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        # Helper function to check validility of neighbor
        def isValidNeighbor(x, y):
            return x < len(board) and x >= 0 and y < len(board[0]) and y >= 0

        # All directions of neighbors
        ways_x = [0, 0, 1, 1, 1, -1, -1, -1]
        ways_y = [1, -1, 1, -1, 0, 0, 1, -1]
        
        for row in range(len(board)):
            for col in range(len(board[0])):
                
                # Loop to count all live neighbors
                count_live_neighbors = 0
                for i in range(8):
                    curr_x, curr_y = row + ways_x[i], col + ways_y[i]
                    if isValidNeighbor(curr_x, curr_y) and abs(board[curr_x][curr_y]) == 1:
                        count_live_neighbors+=1
                
                # Rules 1 and 3: -1 indicates a cell that was live but now is dead.
                if board[row][col] == 1 and (count_live_neighbors < 2 or count_live_neighbors > 3):
                    board[row][col] = -1
                    
                # Rule 4: 2 indicates a cell that was dead but now is live.
                if board[row][col] == 0 and count_live_neighbors == 3:
                    board[row][col] = 2
                 
        # Get the final board
        for row in range(len(board)):
            for col in range(len(board[0])):
                if board[row][col] >= 1:
                    board[row][col] = 1
                else:
                    board[row][col] = 0