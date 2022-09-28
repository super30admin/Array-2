class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])
        
        # 0 =====> 1  ====> 3 dead to live put 3 in place
        # 1 =====> 0  ====> 2 live to dead put 2 in place
        
        for i in range(m):
            for j in range(n):
                
                liveNeighbors = Solution.countLiveNeighbors(board, i, j)
                # Get the count here for every cell
                
                if board[i][j] == 0: # dead cell
                    if liveNeighbors == 3: # Check the count here and make the changes accordingly
                        board[i][j] = 3
                    
                        
                elif board[i][j] == 1: # live cell
                    if liveNeighbors < 2 or liveNeighbors > 3: 
                        board[i][j] = 2
        
        
        for i in range(m):
            for j in range(n):
                
                if board[i][j] == 2:
                    board[i][j] = 0
                    
                elif board[i][j] == 3:
                    board[i][j] = 1
                    
    def countLiveNeighbors(board, i, j):
        
        m = len(board)
        n = len(board[0])
        
        # All the 8 possible directions
        directions = [[0,1],[0,-1], [1,0], [-1,0],[-1,1],[-1,-1],[1,1], [1,-1]]
        count = 0
        for dir in directions:
            nr = i + dir[0]
            nc = j + dir[1]
            
            # Condition to check if live neighbor found and increment count if found
            if (nr >= 0 and nc >= 0 and nr < m and nc < n and (board[nr][nc] == 1 or board[nr][nc] == 2)):
                count += 1
                
        return count
    
    # Time Complexity: O(m x n) where m and n are the rows are columns
    # Space Complexity: O(1) because no extra space is used. Directions list doesn't matter because it will remain constant