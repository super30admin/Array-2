# Time Complexity: O(m*n) -- Since we are parsing the 2d array
# Space Complexity: O(1) -- Since we are making changes in an existing 2d array and not using any other extra space hence it is O(1)
# Did this code successfully run on Leetcode : Yes
# Code:
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        
        """
        Do not return anything, modify board in-place instead.
        """
        
        # conditions : 1. live cell < 2 live neighbours ==> 0
        #              2. live cell > 3 live neighbours ==> 0
        #              3. Dead cell = 3 live neighbours ==> 1 
        # Also, if we change current element, it might impact another elements as well
        # Assigning 0 ==> 1 as 2 and 1 ==> 0 as 3
        
        def count_live_neighbours(current_row,current_column):
            directions = [[0,-1],[0,1],[-1,0],[1,0],[-1,-1],[-1,1],[1,-1],[1,1]] # 8 directions
            count = 0
            for each_direction in directions:
                new_row = current_row + each_direction[0]
                new_column = current_column + each_direction[1]
                if (new_row >= 0 and new_column >= 0 and new_row < m and new_column < n and  (board[new_row][new_column] == 1 or board[new_row][new_column] == 3)):
                    count = count + 1
            return count
        
        
        
        m = len(board) # row count
        n = len(board[0]) # column count
        
        for i in range(0,m):
            for j in range(0,n):
                count_live_cells = count_live_neighbours(i,j) # count number of 1's for each row column combination and change value based on conditions
                if board[i][j] == 0:
                    if count_live_cells == 3:
                        board[i][j] = 2
                else:
                    if count_live_cells < 2 or count_live_cells > 3 :
                        board[i][j] = 3
        
        for i in range(0,m): # Reverting the array into binary format
            for j in range(0,n):
                if board[i][j] == 2:
                    board[i][j] = 1
                elif board[i][j] == 3:
                    board[i][j] = 0
                else:
                    continue
        
        
 # Approach: We parse through each and every row column combination and check and count its 8 neighbours who has a value of 1. 
 # If the current cell is 0, we check if 8 neighbour cell count equals 3, if yes we make the current cell as 2 (We stored a new value because the other cells might get impacted if we change the value now to 1)      
 # If current cell is 1, we check the count of 1's in the neighbour cells. If it is less than 2 or greater than 3 we change the value to 3. The reason being the same mentioned above.
 # Once, entire array is parsed , we again parse the array with values 0,1,2,3 and when we encounter 2 we change it to 1 and  when 3 we change it to 0 as we want the final array as binary.         
            
        