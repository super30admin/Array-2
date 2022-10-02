# Time Complexity: O(m*n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No


class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])
        
        def findLive(i, j):
            count = 0
            
            dirs = [[0,1], [0,-1], [1,0], [-1,0], [1,1], [-1,1], [1,-1], [-1,-1]]
            for d in dirs:
                nr = i + d[0]
                nc = j + d[1]
                if nr>=0 and nc>=0 and nr<m and nc<n and (board[nr][nc] == 1 or board[nr][nc] == 2):
                    count+=1  
            return count
        
        for i in range(m):
            for j in range(n):
                live = findLive(i, j)
                
                if board[i][j] == 1:
                    if live<2 or live>3:
                        board[i][j] = 2
                        
                if board[i][j] == 0:

                    if live == 3:
                        board[i][j] = 3
        
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1
          