class Solution:
    def show(self, board):
        rows,r = len(board), 0
        cols, c = len(board[0]), 0
        while r < rows:
            line = "| "    
            while c < cols:
                line = line + str(board[r][c]) + " "
                c += 1
            c = 0
            line = line + "|"
            print(line)
            r += 1

    def gameOfLife(self, board):
        """
        Do not return anything, modify board in-place instead.
        """
        if not board or not board[0]:
            return

        m, n = len(board), len(board[0])
        
        # Directions for the eight neighbors
        directions = [(-1, -1), (-1, 0), (-1, 1), 
                      (0, -1),          (0, 1), 
                      (1, -1), (1, 0), (1, 1)]
        
        for i in range(m):
            for j in range(n):
                live_neighbors = 0
                
                # Count live neighbors
                for d in directions:
                    ni, nj = i + d[0], j + d[1]
                    if 0 <= ni < m and 0 <= nj < n:
                        if board[ni][nj] == 1 or board[ni][nj] == 3:
                            live_neighbors += 1
                
                # Apply the rules
                if board[i][j] == 1 and (live_neighbors < 2 or live_neighbors > 3):
                    board[i][j] = 3  # Mark as dead in the next state
                elif board[i][j] == 0 and live_neighbors == 3:
                    board[i][j] = 2  # Mark as live in the next state

        # Step 2: Update the board to the final state
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 1  # Change to live
                elif board[i][j] == 3:
                    board[i][j] = 0  # Change to dead
                    
                    
                    
board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
solution = Solution()
solution.show(board)
solution.gameOfLife(board)
print("\n  |  |  \n")
solution.show(board)
