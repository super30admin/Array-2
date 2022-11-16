class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        
        ## T.C = O(m.n)
        ## S.C = O(1)
        
        m = len(board)
        n = len(board[0])
        
        
        def get_neighbour_ones(r, c):
            
            ## U, D, L, R, UL, UR, LL, LR
            dirs = [[-1, 0], [1, 0], [0, -1], [0, 1], [-1, -1], [-1, 1], [1, -1], [1, 1]]
            
            ctr_ones = 0
            for p, q in dirs:
                nr = r + p
                nc = c + q
                
                if nr >= 0 and nr < m and nc >= 0 and nc < n and (board[nr][nc] == 1 or board[nr][nc] == 2):
                    ctr_ones += 1
            
            return ctr_ones
        
        
        for i in range(m):
            for j in range(n):
                count_ones = get_neighbour_ones(i, j)
                
                if board[i][j] == 1:
                    if count_ones < 2 or count_ones > 3:
                        board[i][j] = 2
                else:
                    if count_ones == 3:
                        board[i][j] = 3
        
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1
        
        
        