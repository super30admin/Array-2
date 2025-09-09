"""
Space Complexity: O(1)
Time Complexity: O(m * n) -> iterating through all the elements in the matrix 

"""
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """

        # any cell < 2 live neighbours die
        # any cell with 2 or 3 neighbours lives 
        # any cell with > 3 neighbors die
        # any dead cell with exactly 3 live neighbors becomes live
        def check_live_neighbours(i,j):
            dirs = [(-1,0),(1,0),(0,1),(0,-1),(-1,-1),(-1,1),(1,-1),(1,1)]
            nc = 0
            for dx,dy in dirs: 
                nx = i + dx
                ny = j + dy

                if 0 <= nx < len(board) and 0<=ny<len(board[0]):
                    if board[nx][ny] == 1 or board[nx][ny]==2:
                        nc+=1
            return nc


        m, n = len(board), len(board[0])

        for i in range(m):
            for j in range(n):
                curr_cell = board[i][j]
                if curr_cell: # if the cell is live, check for three conditions
                    if check_live_neighbours(i,j) < 2 or check_live_neighbours(i,j) > 3:
                        curr_cell = 2
                else:
                    if check_live_neighbours(i,j) == 3:
                        curr_cell = 3
                board[i][j] = curr_cell
                
        for i in range(m):
            for j in range(n):
                if board[i][j] == 3: 
                    board[i][j] = 1
                elif board[i][j] == 2: 
                    board[i][j] = 0



        
