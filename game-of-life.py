#time_complexity: o(n*m)
#space_complexity: o(1)

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        # // 1-> 0 3
        # // 0 -> 1 2
        """
        Do not return anything, modify board in-place instead.
        """
        row = len(board)
        col = len(board[0])
        if row <= 0:
            return []
        for i in range(row):
            for j in range(col):
                num_ones = self.calculateOnes(board,i,j)
                if (num_ones < 2 or num_ones > 3) and board[i][j] == 1:
                    board[i][j] = 3
                if num_ones == 3 and board[i][j] == 0:
                    board[i][j] = 2
        for i in range(row):
            for j in range(col):
                if board[i][j] == 3:
                    board[i][j] = 0
                if board[i][j] == 2:
                    board[i][j] = 1
    def calculateOnes(self, nums, r , c):
        dir = [[0,1],[1,0],[-1,0],[0,-1],[1,1],[-1,1],[1,-1],[-1,-1]]  
        count = 0 
        for i in range(len(dir)):
            r1  = r + dir[i][0]
            c1 = c + dir[i][1]
            if (0 <= r1 < len(nums)) and (0 <= c1 <len(nums[0])):
                if nums[r1][c1] == 1 or nums[r1][c1] == 3:
                    count = count + 1
        return count
