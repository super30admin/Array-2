'''
In this problem, for the given 4 conditions, using my countAlive() helper function, I checked all the neighbors of each cells interaction.
For every time if the state of the cell changes from alive to dead I represented it with 2 and for dead to alive I represnted it with 3.
Finally after checking the neighbors of each cell, I replaced my represented values with actual values.
'''
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])
        for i in range(m):
            for j in range(n):
                countAlives = self.countAlive(board, i, j, m, n)
                if board[i][j] == 1 and (countAlives < 2 or countAlives > 3):
                    # 1 -> 0 => 2
                    board[i][j] = 2
                if board[i][j] == 0 and countAlives == 3:
                    # 0 -> 1 => 3
                    board[i][j] = 3
        
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 0
                if board[i][j] == 3:
                    board[i][j] = 1
    
    def countAlive(self, board, i, j, m, n) -> int:
        dirs = [(-1,-1), (-1,0), (-1,1), (0,-1), (0,1), (1,-1), (1,0), (1,1)]
        count = 0
        for dx, dy in dirs:
            newRow = i + dx
            newCol = j + dy
            if(newRow >= 0 and newCol >= 0 and newRow < m and newCol < n and (board[newRow][newCol] == 1 or board[newRow][newCol] == 2)):
                count += 1
        
        return count
'''
Time Complexity: O(m*n)
Here we are iterattig on the board of size m*n twice, so the average time taken m*n
Space Complexity: O(1)
I modified same board without taking any extra space so the space is O(1)
'''