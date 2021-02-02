'''
Time complexity: O(n*m)
Space complexity: O(1)
'''
class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        if board is None or len(board) == 0 or len(board[0]) == 0:
            return []
        n = len(board)
        m = len(board[0])
        
        for i in range(n):
            for j in range(m):
                count = self.countLives(board, i, j, n, m) # get alive neighbors count
                
                # Decide if alive or dead on the basis of the rules and replace with new numbers 2 and 3
                # 2 => was Alive, now Dead
                # 3 => was Dead, now Alive
                if board[i][j] == 1 and (count < 2 or count > 3):
                    board[i][j] = 2
                elif board[i][j] == 0 and count == 3:
                    board[i][j] = 3
        
        # Replace 2 with 0 and 3 with 1 to maintain question's nomenclature
        for i in range(n):
            for j in range(m):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1
                    
    def countLives(self, board, i, j, n, m):
        # Pre-defined manipulation of i and j values of current element to get 8 neighbors in a matrix
        dirs = [[1,-1],[0,-1],[-1,-1],[-1,0],[-1,1],[0,1],[1,1],[1,0]]
        
        count = 0
        for dir in dirs:
            # get co-ordinates of neighbor
            r = i + dir[0]
            c = j + dir[1]
            
            # r >= 0 and r < n and c >=0 and c < m ------> to check matrix bounds
            # board[r][c] == 1 or board[r][c] == 2 ------> since 1 (alive) and 2 (element has changed but was alive in the original matrix) 
            if (r >= 0 and r < n and c >=0 and c < m and (board[r][c] == 1 or board[r][c] == 2)):
                    # count total live neighbors
                    count = count + 1
        return count
            
        