class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
#         O(m*n)--->tc
#          O(1)-----> SC
        neighbours= [(0,1), (0,-1), (1,0), (-1,0), (1,1), (-1,1), (1, -1), (-1,-1)]
        n, m = len(board), len(board[0])
        for i in range(n):
            for j in range(m):
                count = 0
                for x,y in neighbours:
                    r, c = i+x, j+y
                    if 0<=r<n and 0<=c<m:
                        if abs(board[r][c]) == 1:
                            count+=1
                        
                if board[i][j] == 1:
                    if count not in [2,3]:
                        board[i][j] = -1
                else:
                    if count == 3:
                        board[i][j] = 2

        for i in range(n):
            for j in range(m):
                if board[i][j] > 0:
                    board[i][j] = 1
                else:
                    board[i][j] = 0