# Time Complexity : O(mXn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
# 1. If there is a need to change the number from 0 to 1,change it to 2 instead
# 2. If there is a need to change the number from 1 to 0,change it to 3 instead
# 3. These rules will help to preseve the initial value of each cell required for manipulation throughout the traversal.
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if board is None or len(board) == 0 or len(board[0]) == 0:
            return
        m = len(board)
        n = len(board[0])
        
        neighbours = [[-1,-1], [-1,0], [-1,1], [0,-1], [0,1], [1,-1], [1,0], [1,1]]
        
        for i, row in enumerate(board):
            for j, col in enumerate(row):
                if 0 == col or 2 == col: # 2 signify the 0 has been cobverted to 1
                    alive_count = 0
                    for neighbour in neighbours:
                        x = neighbour[0]+i
                        y = neighbour[1]+j
                        if x >=0 and x < m and y >=0 and y < n:
                            if board[x][y] == 1 or board[x][y] == 3:
                                alive_count+=1
                    if alive_count == 3:
                        board[i][j] = 2
                elif 1 == col or 3 == col: # 3 signify the 1 has been cobverted to 0
                    alive_count = 0
                    for neighbour in neighbours:
                        x = neighbour[0]+i
                        y = neighbour[1]+j
                        if x >=0 and x < m and y >=0 and y < n:
                            if board[x][y] == 1 or board[x][y] == 3:
                                alive_count+=1
                    if alive_count > 3 or alive_count < 2:
                        board[i][j] = 3
        
        # traverse the matrix 
        # replace 3 with 0 and 2 with 1
        for i, row in enumerate(board):
            for j, col in enumerate(row):
                if col == 3:
                    board[i][j] = 0
                elif col ==2:
                    board[i][j] = 1