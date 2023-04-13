## Finald all disappeared numbers
Time complexcity : 0(n)
Space complexcity :0(n)
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = []
    
    # First pass: Mark elements as negative
        for i in range(n):
            idx = abs(nums[i]) - 1
            if nums[idx] > 0:
                nums[idx] = -nums[idx]
    
    # Second pass: Check for positive elements
        for i in range(n):
            if nums[i] > 0:
                result.append(i + 1)
    
        return result
##Game of life
## TC  0(MN)
## space 0(m+n)
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        ## checking the length of borad is zero
        if board == None or len(board) == 0:
            return 
        m = len(board)
        n = len(board[0])
        for row  in range(m):
            for column in range(n):
                liveCount = self.getLiveCount(board, row, column)
                # if current cell is live:
                if board[row][column] == 1:
                    if liveCount < 2 or liveCount > 3:
                        board[row][column] = 2
                else:
                    if liveCount ==3:
                        bord[row][column] = 3
        
        for row in range(m):
            for column in range(n):
                if board[row][column] == 2:
                    board[row][column] = 0
                elif board[row][column] == 3:
                    board[row][column] = 1
        
        def getLiveCount(self, board: List[list[int]], i : int, j : int) -> int:
            count  = 0
            dirs = [[-1,0], [1,0], [0,-1],[-1, -1], ]