class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        #we need to store the state change within the board itself without any external         variables.
        # 1 -> 0 use 2
        # 0 -> 1 use 3
        # 2, 3 indicates original states were 1 and 0 respectively.

        m = len(board)
        n = len(board[0])

        def helper(board, i, j):
                #right   #left.   #up.   #bottom. #diagonals
            directions = [(0,1), (0,-1), (-1,0), (1,0), (1,1), (1,-1), (-1,1), (-1,-1)]

            count = 0

            for dx, dy in directions:
                r,c = i+dx, j+dy
                if 0 <= r < m and 0 <= c < n:
                    if board[r][c] == 1 or board[r][c] == 2:#we just need to count alive cells
                        count += 1

            return count

        #use temp state change value so that we won't lose track of original value as well
        for i in range(m):
            for j in range(n):
                count = helper(board, i ,j) #we just need count of alive neighbors
                if board[i][j] and (count < 2 or count > 3):
                    board[i][j] = 2
                elif not board[i][j] and count == 3:
                    board[i][j] = 3

        
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 0 #new state
                elif board[i][j] == 3:
                    board[i][j] = 1 #new state

# Time Complexity: O(m*n)
# Space Complexity: O(1)

# 1 -> 0 if neighbors < 2 alive
# 1 -> 1 if neighbors 2 or 3 alive
# 1 -> 0 if neighbors > 3 alive
# 0 -> 1 if neighbors = 3 alive