class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        
        if not board:
            return 
        
        m = len(board)
        n = len(board[0])
        
        # live to dead: <2 or >3
        # live to live: == 2 or == 3
        # dead to live: == 3
        # 1 to 0: 3
        # 0 to 1: 2
        for i in range(m):
            for j in range(n):
                
                # count live neighbors
                count = self.countLiveNeighbors(board, i, j, m, n)
                
                if(board[i][j] == 1) and (count<2 or count>3):
                    board[i][j] = 3
                if(board[i][j] == 0 and count == 3):
                    board[i][j] = 2
        
        # changing back 3 to 0 and 2 to 1
        for i in range(m):
            for j in range(n):
                if board[i][j] == 3:
                    board[i][j] = 0
                if board[i][j] == 2:
                    board[i][j] = 1
        
        
    def countLiveNeighbors(self, board, i, j, m, n):
        result = 0
        dirs = [[-1, -1], [-1, 1], [1, 1], [1, -1], [0, 1], [1, 0], [0, -1], [-1, 0]]
        
        for x in dirs:
            r = i + x[0]
            c = j + x[1]
            if (r>=0 and r<m and c>=0 and c<n):
                if board[r][c] == 1 or board[r][c] == 3:
                    result += 1
        
        return result
    
# dirs array defines the coordinates of the directions from the nodes to count the live neighbors
# counting the neighbors based on the criteria and the boundary
# TC: O(MN) SC: O(1)