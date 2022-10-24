# Time complexity: O(m*n)
 # Space complexity: O(1)
 # Does this code run on Leetcode: Yes
 # Did you face any difficulty while coding the solution: No


class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        dead = 0
        live = 1
        deadtolive = 2
        livetodead = 3
        directions = [[0,-1], # left
                    [0, 1], # right
                     [1, 0], # top
                     [-1, 0], # bottom
                     [-1, 1], #upleft
                     [1, 1], #upright
                     [-1,-1], #downleft
                     [1, -1], #downright
                     ]
        def alivecount(board, i, j):
            count = 0
            m = len(board)
            n = len(board[0])
            for d in directions:
                
                
                ni = i + d[0]
                nj = j + d[1]
                if (ni>= 0 and ni<m and nj>=0 and nj<n):
                    if board[ni][nj] == live or board[ni][nj] == livetodead:
                        count +=1
            return count
        
        m = len(board)
        n = len(board[0])
        for i in range(m):
            for j in range(n):
                alive = alivecount(board, i, j)
                if board[i][j] == live:
                    if alive < 2 or alive>3:
                        board[i][j] = livetodead
                else:
                    if alive == 3:
                        board[i][j] = deadtolive
                        
        for i in range(m):
            for j in range(n):
                if board[i][j] == livetodead:
                    board[i][j] = 0
                if board[i][j] == deadtolive:
                    board[i][j] = 1
       
