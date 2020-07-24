# APPROACH 1: USING EXTRA SPACE
# Time Complexity : O(m*n), m: number of rows of board, n: number of columns of board
# Space Complexity : O(m*n), the space of result array, else O(1)
# Did this code successfully run on Leetcode : N/A
# Any problem you faced while coding this : None (forgot to copy the elements from board to result if no condition affects them)
#
#
# Your code here along with comments explaining your approach
# 1. For each cell of board, count the live neighbors (8)
# 2. Then according to conditions, modify the element and store in result
# 3. Don't forgot about the elements that don't get affected by any condition and copy them as it is

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        
        if not board:
            return [[]]
        
        directions = [[-1, -1], [-1, 0], [-1, 1], [0, -1], [0, 1], [1, -1], [1, 0], [1, 1]]
        
        result = [[None for _ in range(len(board[0]))] for _ in range(len(board))]

        for row in range(len(result)):
            for column in range(len(result[0])):
                
                live_nei = 0
                for direction in directions:
                    
                    if row + direction[0] >= 0 and row + direction[0] < len(board) and column + direction[1] >= 0 and column + direction[1] < len(board[0]):
                        if board[row + direction[0]][column + direction[1]] == 1:
                            live_nei += 1
                 
                
                if board[row][column] == 1 and (live_nei < 2 or live_nei > 3):
                        result[row][column] = 0
                        
                elif board[row][column] == 0 and live_nei == 3:
                        result[row][column] = 1
                        
                else:
                    result[row][column] = board[row][column]
                        
        return result
        
        
        

# APPROACH 2: MODIFY IN-PLACE 
# Time Complexity :  O(m*n), m: number of rows of board, n: number of columns of board
# Space Complexity : O(1), since board is modified in-place
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. For each cell of board, count the live neighbors (8)
# 2. Then according to conditions, need to modify the element but we also need to store the past state as they might be neighbors of future elements. 
#    So, let's represent elements that change from 0 -> 1 by 2 and 1 -> 0 by 3
# 3. In this way we will know both the past and current modified state
# 4. Again loop through board, to change elements having values 3, 2 to 0, 1 respectively

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        
        if board:
        
            directions = [[-1, -1], [-1, 0], [-1, 1], [0, -1], [0, 1], [1, -1], [1, 0], [1, 1]]

            # 0 -> 1 : 2
            # 1 -> 0 : 3

            for row in range(len(board)):
                for column in range(len(board[0])):

                    live_nei = 0
                    for direction in directions:

                        if row + direction[0] >= 0 and row + direction[0] < len(board) and column + direction[1] >= 0 and column + direction[1] < len(board[0]):
                            if board[row + direction[0]][column + direction[1]] == 1 or board[row + direction[0]][column + direction[1]] == 3:
                                live_nei += 1


                    if board[row][column] == 1 and (live_nei < 2 or live_nei > 3):
                            board[row][column] = 3

                    elif board[row][column] == 0 and live_nei == 3:
                            board[row][column] = 2


            for row in range(len(board)):
                for column in range(len(board[0])):
                    if board[row][column] == 2:
                        board[row][column] = 1
                    elif board[row][column] == 3:
                        board[row][column] = 0
