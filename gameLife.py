# Time Complexity : O(mn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def count_live(self,i, j ,copy_b,rows,cols):
        n_dr = [(1,0),(1,-1),(0,-1),(-1,-1),(-1,0),(-1,1),(0,1),(1,1)]
        count = 0
        for k in n_dr:
            x = i+k[0]
            y = j+k[1]
            if x >= 0 and y >= 0 and x < rows and y <cols and copy_b[x][y] == 1:
                count= count+1
        return count
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        rows,cols = len(board),len(board[0])
        copy_b = copy.deepcopy(board)
        for i in range(rows):
            for j in range(cols):
                ele = copy_b[i][j]
                count = self.count_live(i, j ,copy_b,rows,cols)
                if ele == 0 and count == 3:
                    board[i][j] = 1
                elif ele == 1 and (count < 2 or count >3):
                    board[i][j] = 0
