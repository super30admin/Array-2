# Time Complexity : O(m*n)
# Space Complexity : O(1)

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m, n = len(board), len(board[0])
        res = [[0 for i in range(n)]for j in range(m)]

        for i in range(m):
            for j in range(n):
                count = 0
                for k in range(i - 1, i + 2):
                    for l in range(j - 1, j + 2):
                        if k < 0 or k > m - 1 or l < 0 or l > n - 1:
                            continue
                        else:
                            if k == i and l == j:
                                continue
                            elif board[k][l] == 1 or board[k][l] == 3:
                                count += 1
                if board[i][j] == 0:
                    if count == 3:
                        board[i][j] = 2

                else:
                    if count < 2 or count > 3:
                        board[i][j] = 1
                    else:
                        board[i][j] = 3
        
        for i in range(m):
            for j in range(n):
                if board[i][j] < 2:
                    board[i][j] = 0
                else:
                    board[i][j] = 1
                                
                