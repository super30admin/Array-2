'''
289. Game of Life

TIME COMPLEXITY: O(M*N)
SPACE COMPLEXITY: O(1)
LEETCODE: Yes
DIFFICULTY: Nope
'''


class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])
        
        # flag 0 -> 1 => 2
        # flag 1 -> 0 => 3
        
        d = [(-1,-1), (-1,0), (-1,1), (0,-1), (0,1), (1,-1), (1,0), (1,1)]
        for i in range(0, m):
            for j in range(0, n):
                cnt = 0
                alive = None
                for k in range(0,len(d)):
                    ii = i + d[k][0]
                    jj = j + d[k][1]
                    
                    if (ii >= 0 and ii < m and jj >= 0 and jj < n) and (board[ii][jj]==1 or board[ii][jj]==3):
                        cnt += 1
                
                if board[i][j] == 1 and cnt < 2:
                    alive = False
                elif board[i][j] ==1 and (cnt ==2 or cnt==3):
                    alive = True
                elif board[i][j] ==1 and cnt > 3:
                    alive = False
                elif board[i][j] ==0 and cnt == 3:
                    alive = True
                
                if board[i][j] ==0 and alive:
                    board[i][j] = 2
                elif board[i][j] ==1 and not alive:
                    board[i][j] = 3
        
        for i in range(0, m):
            for j in range(0, n):
                if board[i][j] == 3:
                    board[i][j] = 0
                elif board[i][j] == 2:
                    board[i][j] = 1
