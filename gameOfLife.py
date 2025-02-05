class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
         # to avoid interfere with old state assign 0->1 = 2, 1->0 # 3
        n = len(board[0])
        m = len(board)

        def countAlive(r,c):
            count = 0
            for i in [-1,0,1]:
                for j in [-1,0,1]:
                    if i==0 and j==0:
                        continue
                    
                    nr = r + i
                    nc = c + j

                    if nr >= m or nc >= n or nr < 0 or nc < 0:
                        continue

                    if board[nr][nc] == 1 or board[nr][nc] == 3:
                        count += 1

            return count 


        for r in range(m):
            for c in range(n):
                alive = countAlive(r,c)
                if board[r][c] == 0:
                    if alive == 3:
                        # 0 -> 1
                        board[r][c] = 2
                else:
                    if alive < 2 or alive > 3:
                        # 1 -> 0
                        board[r][c] = 3

        for r in range(m):
            for c in range(n):
                if board[r][c] == 3:
                    board[r][c] = 0
                if board[r][c] == 2:
                    board[r][c] = 1

# TC : O(m*n)
# SC : O(1)