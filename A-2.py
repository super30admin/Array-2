# Array-2

## Problem 1: Find All Numbers Disappeared in an Array (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if nums == None or len(nums) == 0:
            return []
        result = []
        for i in range(len(nums)):
            index = abs(nums[i])-1
            if nums[index] > 0:
                nums[index] = nums[index] * -1
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i+1)
            else:
                nums[i] = nums[i] * -1
        return result
# TC = O(n) , SC= O(1)

## Problem 2: Game of Life (https://leetcode.com/problems/game-of-life/)

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if board == None or len(board) == 0:
            return
        m = len(board)
        n = len(board[0])
        #1 -> 0 ==> 2 
        #0 -> 1 ==> 3
        for i in range(m):
            for j in range(n):
                liveNeighbors = self.liveNeighborCount(board, i, j)
                #cell is alive
                if board[i][j] == 1:
                    if liveNeighbors < 2 or liveNeighbors > 3:
                        board[i][j] = 2
                elif board[i][j] == 0:
                    if liveNeighbors == 3:
                        board[i][j] = 3
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] =0
                elif board[i][j] == 3:
                    board[i][j] =1
    
    def liveNeighborCount(self, board: List[List[int]], row : int, col: int) -> int:
        count = 0
        m = len(board)
        n = len(board[0])
        dirs = [[-1,0], [1,0], [0,-1], [0,1], [-1,-1], [-1,1], [1,-1], [1,1]] # U D L R UL UR LL LR
        for Dir in dirs:
            nr = row + Dir[0]
            nc = col + Dir[1]
            if nr >= 0 and nr < m and nc >= 0 and nc < n and (board[nr][nc] ==  1 or board[nr][nc] == 2):
                count = count +1
        return count
# TC = O(m*n) , SC= O(1)
        