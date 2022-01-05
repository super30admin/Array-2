# Time Complexity :
# O(m*n)

# Space Complexity :
# O(1)

# Did this code successfully run on Leetcode :
# Yes

# Three line explanation of solution in plain english
# I have used state change pattern to update the cells in place in the same matrix without using new data structures.
# In first iteration i have changed the state to 2 or -1 for change 1-->0 and 0-->1 respectively.
# In second iteration i have have changed all the cells with value 2 to 0 and all the cells with value -1 to 1.

# Your code here along with comments explaining your approach

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if board == None or len(board) == 0:
            return []
        
        dirs = [[0, 1], [0, -1], [-1, 0], [1, 0], [-1, -1], [-1, 1], [1, -1], [1, 1]]
        
        # Changing state 
        # 1-->0 : 2
        # 0-->1 : -1
        for i in range(len(board)):
            for j in range(len(board[0])):
                
                liveCount = self.liveNeighborsCount(board, i, j, dirs)
                
                # Rule 1 and 3
                if (board[i][j]==1 and (liveCount<2 or liveCount>3)):
                    board[i][j] = 2
                    
                # Rule 4
                if (board[i][j]==0 and liveCount==3):
                    board[i][j] = -1
                  
        # Changing cells with value 2 to 0 and Changing cells with value -1 to 1
        for i in range(len(board)):
            for j in range(len(board[0])):
                
                if (board[i][j] == 2):
                    board[i][j] = 0
                
                if (board[i][j] == -1):
                    board[i][j] = 1
                    
    # Function for counting number of live neighbors
    def liveNeighborsCount(self, board, i, j, dirs):
        
        count = 0
        
        for dr in dirs:
            
            r = i+dr[0]
            c = j+dr[1]
            
            if (r>=0 and r<len(board) and c>=0 and c<len(board[0]) and (board[r][c] == 1 or board[r][c] == 2)):
                count += 1
                    
        return count