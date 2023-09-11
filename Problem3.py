'''
1. Traverse the entire board and we have eight directions for each cell.
2. For each, we maintain live cells count and based on the rules modify them.
3. We update the value of dead cell that is reviving to 2 to not interfere the current cell.

TC: O(n^2)
SC: O(1)
'''    
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])

        # You have to check eight directions for every cell on board
        directions = [(0,1),(1,0),(1,1),(1,-1),(-1,-1),(0,-1),(-1,0),(-1,1)]
        # For each cell
        for i in range(m):
            for j in range(n):
                # Maintain the number of live cells around it
                live = 0
                for x,y in directions:
                    if( i+x < m and i+x >=0) and (j+y < n and j+y>=0) and abs(board[i+x][j+y])==1:
                        live+=1
                # For rule 1 and 3
                if board[i][j] == 1 and (live<2 or live>3):
                    board[i][j] = -1
                # Rule 4. Change their value to 2 to not include them in subsequent cells life count in this iteration
                if board[i][j] == 0 and live==3:
                    board[i][j] = 2
        for i in range(m):
            for j in range(n):
                board[i][j] = 1 if (board[i][j]>0) else 0
        return board