# https://leetcode.com/problems/game-of-life/

# In this program to update the board without using the extra space two temporary notations used '2' for alive and '3' for dead. Checked every cell and count how manylive neighbors it has. Then eventually turn the 2 and 3 into the original form.
# Time Complexity- O(m * n) Space Complexity- (1)

class Solution:
    def gameOfLife(self, board)-> list[int]:
        directions = [(-1,-1), (-1,0), (-1,1), (0,-1), (0,1), (1,-1), (1,0), (1,1)]
        m, n = len(board), len(board[0])

        def getaAliveCount(i, j):
            count = 0
            # iterating on directions array to find the all eight directions of the current row and column index
            for dx, dy in directions:
                # to find the new row and column of the neighbor
                r, c = i + dx, j + dy
                # checking the boundires if the new row formed is greater than zero and less than total rows and new column formed is greater than zero and less than n then only consider it 
                if 0 <= r < m and 0 <= c < n:
                    # as checking for only alive counts so give the conditions originally alive and changed to dead which was original alive
                    if board[r][c] == 1 or board[r][c] == 2:
                        count += 1
            # once we are done with the all directions return the count
            return count

        for i in range(m):
            for j in range(n):
                # calling the function to get the count of the live cells
                cnt = getaAliveCount(i, j)
                # if the cell is dead(board[i][j] == 0) then checking the 4th rule which says dead cell with 3 dead neighbors becomes alive
                if board[i][j] == 0 and cnt == 3:
                    # mark it 3 which shows intially it was dead now it's alive
                    board[i][j] = 3
                # if the cell is live(board[i][j] == 1) then checking the 2 give rules first one is live cell fewer than 2 live neighbors or live cell more than 3 live neighbors becomes dead
                elif board[i][j] == 1 and (cnt < 2 or cnt > 3):
                    # mark it 2 which shows intially it was alive now it's dead
                    board[i][j] = 2

        for i in range(m):
            for j in range(n):
                # change the updated cell in it's original state
                if board[i][j] == 2:
                    board[i][j] = 0
                # change the updated cell in it's original state
                elif board[i][j] == 3:
                    board[i][j] = 1
        return board

solution =  Solution()
print(solution.gameOfLife([[0,1,0],[0,0,1],[1,1,1],[0,0,0]]))