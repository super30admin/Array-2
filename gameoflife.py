#Time Complexity : O(m*n)
#Space Complexity: O(1)
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        dirs = [[-1,0], [1,0], [0,1], [0,-1], [-1,1], [1, -1], [-1, -1], [1, 1]]

        m = len(board)
        n = len(board[0])

        def count_neigh(board, i, j):
            count = 0
            for arr in dirs:
                r = i+arr[0]
                c = j + arr[1]
                if r >= 0 and c >= 0 and r < m and c < n:
                    if board[r][c] == 1 or board[r][c] == 4:
                        count +=1
            return count 

        for i in range(m):
            for j in range(n):
                if board[i][j] == 1:
                    count = count_neigh(board, i,j)
                    if count > 3 or count < 2:
                        board[i][j] = 4
                elif board[i][j] == 0:
                    count = count_neigh(board, i,j)
                    if count == 3:
                        board[i][j] = 3

        
        

        for i in range(m):
            for j in range(n):
                if board[i][j] == 3:
                    board[i][j] = 1
                elif board[i][j] == 4:
                    board[i][j] = 0