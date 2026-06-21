#https://leetcode.com/problems/game-of-life/
# Time Complexity: O(m * n) -> we visit every cell once in pass 1 (each visit checks 8 neighbors, a constant) then every cell once again in pass 2, so total work scales with grid size
# Space Complexity: O(1) 
# Use 2 extra encoded states (2 = live->dying, 3 = dead->being born) so we can read the ORIGINAL generation's values while deciding the NEXT generation, without needing a second grid.
# Pass 1 scans every cell, counts live neighbors using getCount(), and marks transitions (2 or 3) based on the 4 Game of Life rules, without overwriting the original 0/1 meaning yet.
# Pass 2 converts the encoded markers back to real 0/1 values, giving the final next-generation board.
# list of all 8 neighbor offsets (dx = row shift, dy = column shift) around any cell excludes (0,0) since that would be the cell itself, not a neighbor


        
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        directions = [(-1,-1), (-1,0), (-1,1), (0,-1), (0,1), (1,-1), (1,0), (1,1)]

        m = len(board)        
        n = len(board[0])     
        # helper function: counts how many of cell (i, j)'s neighbors are CURRENTLY alive
        # i = row index of the cell we're checking neighbors for
        # j = column index of the cell we're checking neighbors for
        def getCount(i, j):
            count = 0                                    # running tally of live neighbors found so far, starts at 0
            for dx, dy in directions:                    # loop through all 8 direction offsets one at a time
                row, column = i + dx, j + dy             # row, column = the neighbor's actual position on the board
                if 0 <= row < m and 0 <= column < n:     # boundary check: skip if neighbor would be off the grid
                                                     # a value of 1 = currently alive, 2 = currently alive but marked to die next round
                                                     # both count as "alive right now", which is what we care about for this generation
                    if board[row][column] == 1 or board[row][column] == 2:
                        count += 1                      # found a live neighbor, increment the tally
            return count                        
        # PASS 1: decide every cell's fate based on the ORIGINAL board values, but don't apply changes yet
        for i in range(m):                          
            for j in range(n):                  
                finalcount = getCount(i, j)     # finalcount = number of live neighbors for cell (i, j)

                # Rule 4: cell is currently dead AND has exactly 3 live neighbors
                if board[i][j] == 0 and finalcount == 3:
                    board[i][j] = 3             

                # Rules 1 & 3 (under/over-population): cell is currently alive AND has too few/too many neighbors
                elif board[i][j] == 1 and (finalcount < 2 or finalcount > 3):
                    board[i][j] = 2             
                # NOTE: Rule 2 (2 or 3 neighbors -> stays alive) needs no code; the cell just remains 1 untouched

        # PASS 2: convert all placeholder markers into their real final 0/1 values
        for i in range(m):                      
            for j in range(n):                      
                if board[i][j] == 2:                
                    board[i][j] = 0                 
                elif board[i][j] == 3:          
                    board[i][j] = 1             