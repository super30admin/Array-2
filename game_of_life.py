class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        #Time Complexity: O(len(board) * len(board[0]))
        #Space Complexity: O(1)
        
        # 1 --> 0: 2
        # 0 --> 1: 3
        
        m, n = len(board), len(board[0])
        for i in range(m):
            for j in range(n):
                val = self.life(board, i, j, m, n)
                
                #rules 1 and 3
                if board[i][j] == 1 and (val < 2 or val > 3):
                    board[i][j] = 2
                
                #rule 4
                elif board[i][j] == 0 and (val == 3):
                    board[i][j] = 3
        
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1
                    
        return
                    
    def life(self, board, i, j, m, n):
        dirs = [[0, -1], [0, 1], [-1, 0], [1, 0], [-1, -1], [-1, 1], [1, -1], [1, 1]]
        val = 0
        
        for d in dirs:
            r = i + d[0]
            c = j + d[1]
            
            if r >= 0 and r < m and c >= 0 and c < n and (board[r][c] in [1,2]):
                val += 1        
        
        return val