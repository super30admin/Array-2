# 289 Game of life

# // Time Complexity : O(nxm)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : no


# // code here along with comments explaining approach
    # 1 -> 0 if neighbors<2
    # 1 -> 1 if neighbors == 2 or 3
    # 1 -> 0 if neighbors > 3
    # 0 -> 1 if neighbors == 3

    # 1->2 for 1->0 |  2 means previously it was 1
    # 1->3 for 0->1 |  3 means previously it was 0


class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        # 1 -> 0 if neighbors<2
        # 1 -> 1 if neighbors == 2 or 3
        # 1 -> 0 if neighbors > 3
        # 0 -> 1 if neighbors == 3

        # 1->2 for 1->0 |  2 means previously it was 1
        # 1->3 for 0->1 |  3 means previously it was 0

        # countintg neighbours
        def count_neighbours(board,n,m, row,col):
            neighbors = 0
            dir_arr = [[-1,-1],[-1,0],[-1,1],[0,-1],[0,1],[1,-1],[1,0],[1,1]]
            for dir in dir_arr:
                r = row+dir[0]
                c = col+dir[1]
                if r >=0 and c >=0 and r < n and c < m and (board[r][c]==1 or board[r][c]==2): #bounds when checking on 8 directions
                        neighbors = neighbors + 1
            return neighbors

        n= len(board)
        m = len(board[0])
        for r in range(n):
            for c in range(m):
                cell = board[r][c]
                neighbors = count_neighbours(board,n,m,r,c)

                if cell == 1 and (neighbors < 2 or neighbors > 3):
                    board[r][c] = 2
                if cell == 0 and neighbors == 3:
                    board[r][c] = 3
        # update the values 2, 3 to 0 , 1
        for r in range(n):
            for c in range(m):
                if board[r][c] == 2:
                    board[r][c] = 0
                if board[r][c] == 3:
                    board[r][c] = 1