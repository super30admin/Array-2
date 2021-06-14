# Game of Life

# Time Complexity: O(m*n)
# Space Complexity: O(1) 
# Did this code successfully run on Leetcode: all test cases passed
# Any problem you faced while coding this: No

# Approach 1: 

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        
        
        # for in-place substitution
        # 0 -> 1 -> 2
        # 1 -> 0 -> 3
        
        new_live_state = 2
        new_dead_state = 3
        i = 0
        j = 0
        # rows and columns
        m = len(board) #rows
        n = len(board[0]) # columns
        
        while(i<m):
            j=0    
            while(j<n):
                numNeighbors = self.findLiveNeighbors(i,j, board)

                if board[i][j] == 1:
                    if numNeighbors < 2: # rule 1
                        board[i][j] = new_dead_state
                    elif numNeighbors >1 and numNeighbors < 4: # rule 2
                        pass
                    elif numNeighbors > 3: # rule 3
                        board[i][j] = new_dead_state
                else:
                    if numNeighbors == 3: # rule 4
                        board[i][j] = new_live_state

                j+=1
            i+=1
        i=0
        j-0
        while(i<m):
            j=0
            while(j<n):
                if board[i][j] == new_live_state:
                    board[i][j] = 1

                elif board[i][j] == new_dead_state:
                    board[i][j] = 0
                j+=1
            
            i+=1
            
            
            
    def findLiveNeighbors(self, i, j, board) -> int:  
        # find neighbors in 8 locations
        
        locs = [[1,1],[1,0],[1,-1],[0,-1],[-1,-1],[-1,0],[-1,1],[0,1]] # 8 states
        count = 0
        
        for loc in locs:
            r = i+loc[0]
            c = j+loc[1]
            if (r < len(board) and r >= 0) and (c>=0 and c < len(board[0])):
                if board[r][c] == 1 or board[r][c] == 3:
                    count = count + 1
        
        return count
                
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        