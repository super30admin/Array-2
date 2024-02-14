class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        [4,3,2,7,8,2,3,1]
        [4,3,-2,-7,8,2,3,1]
        time: O(n)
        space: O(1)
        """
        ans = []
        for i in range(len(nums)):
            if nums[i] > 0 and nums[nums[i]-1] > 0:
                nums[nums[i]-1] *= -1
            elif nums[i] < 0 and nums[-nums[i]-1] > 0:
                nums[-nums[i]-1] *= -1

        for i in range(len(nums)):
            if nums[i] > 0:
                ans.append(i + 1)
        return ans

        def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        0: dead
        1: live
        2: dead, live before
        3: live, dead before
        1. Trick: Don't do parallel processing. Instead use intermediate values for the next state and update them to the final value in second iteration.
        """
        neighbors = [(1,0), (1,-1), (0,-1), (-1,-1), (-1,0), (-1,1), (0,1), (1,1)]
        rows = len(board)
        cols = len(board[0])
        for row in range(rows):
            for col in range(cols):
                live_neighbors = 0
                for r,c in neighbors:
                    nr, nc = row + r, col + c
                    if 0 <= nr < rows and 0 <= nc < cols and board[nr][nc] in [1, 2]:
                        live_neighbors += 1
                if board[row][col] == 1 and (live_neighbors < 2 or live_neighbors > 3):
                    board[row][col] = 2
                elif board[row][col] == 0 and live_neighbors == 3:
                    board[row][col] = 3
        
        for row in range(rows):
            for col in range(cols):
                if board[row][col] == 2:
                    board[row][col] = 0
                elif board[row][col] == 3:
                    board[row][col] = 1


