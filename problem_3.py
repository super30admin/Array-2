#  Problem: https://leetcode.com/problems/game-of-life/
#  Time Complexity: O(m*n)
#  Space Complexity: O(1)
#  Did this code successfully run on Leetcode : Yes


class Solution:

    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])

        def  count_live_neighbor(board, i , j):
            dirs = [[-1,0], [1,0], [0,-1], [0,1], [-1,-1], [-1, 1], [1,1], [1,-1]]
            count = 0 

            for dir in dirs:
                nr = i + dir[0]
                nc = j + dir[1]

                if 0 <= nr < m and 0 <= nc < n:
                    if board[nr][nc] == 1 or board[nr][nc] == 2:
                        count += 1
                
            return count

        if (board is None) or len(board) == 0:
            return 


        #  1--> 0 = 2
        #  0--> 1 = 3

        for i in range(m):
            for j in range(n):
                live_neighbors  = count_live_neighbor(board, i, j)

                if board[i][j] ==1:
                    if live_neighbors  < 2 or live_neighbors >3:
                        board[i][j] = 2
                
                elif board[i][j] == 0:
                    if live_neighbors  == 3:
                        board[i][j] = 3
        
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                   board[i][j] = 0
                if board[i][j] ==3 :
                    board[i][j] = 1

