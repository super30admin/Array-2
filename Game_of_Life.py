class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        
        ### Approach:
        '''
            1. When changing from alive to dead, mark the state as 3 (1->0:3)
            2. When changing from dead to alive, mark the state as 2 (0->1:2)
            3. This way, odd number means the state is currently alive or it was alive before.
            4. Likewise, even number means the state is currently dead or it was dead before
        '''        
        
        def compute_neighbor_live(row, col):
            '''
            Computes Alive Cells at among all valid neighboring cells given row and column
            '''    
            live_count = 0
            for i in range(row-1, row+2):
                for j in range(col-1, col+2):
                    if i>=0 and i<m and j>=0 and j<n and not (i==row and j==col):
                        live_count += board[i][j] % 2
            return live_count
        
        m,n = len(board), len(board[0])
        
        for i in range(m):
            for j in range(n):
                
                alive_cells = compute_neighbor_live(i,j)
                
                ## Condition for changing alive to dead
                if board[i][j] and (alive_cells < 2 or alive_cells > 3):
                        board[i][j] = 3
                
                # Condition for changing dead to alive
                elif not board[i][j] and alive_cells == 3:
                    board[i][j] = 2
                            
        # Change the state to alive and dead based on state numbers
        for i in range(m):
            for j in range(n):
                if board[i][j] == 3:
                    board[i][j] = 0
                elif board[i][j] == 2:
                    board[i][j] = 1
        
        return board

### Complexity Analysis:

# Time Complexity: O(MxN) --> Iterating through the entire matrix
# Space Complexity: O(1) --> No extra space used