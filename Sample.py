# Time Complexity : O(n) + O(n) = O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
# Mark the visited indices values as Negative. Whichever number is not negative, that indices are the disappeared number

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        res = []
        for i in range(len(nums)):
            idx_val = abs(nums[i]) - 1
            if nums[idx_val] > 0:
                nums[idx_val] = -nums[idx_val]
        for i in range(len(nums)):
            if nums[i] < 0:
                nums[i] = abs(nums[i])
            else:
                res.append(i+1)
        return res



# Time Complexity : O(n^2) + O(n) = O(n^2)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : 


# Your code here along with comments explaining your approach
# Check all directions to count alive cells around the current cell
# When turning previously alive to dead, turn them to 2
# When turning previously dead to alive, turn them to 3
# This preseves the original state as well
# Finally turn 2s to 0 and 3s to 1


class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        
        1 -> 1 if livecount > 2 nc
        1 -> 0  if livecount < 2 up
        1 -> 0 if livecount > 3 op
        0 -> 1 if livecount == 3 rebirth
        """
        m = len(board)
        n = len(board[0])
        for i in range(m):
            for j in range(n):
                countAlives = self.countAlive(board,i,j)
                if board[i][j] == 1 and (countAlives < 2 or countAlives > 3):
                    board[i][j] = 2
                if board[i][j] == 0 and countAlives == 3:
                    board[i][j] = 3

        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 0
                if board[i][j] == 3:
                    board[i][j] = 1


    def countAlive(self,board,i,j):
        alive = 0
        m = len(board)
        n = len(board[0])
        # left,right,top,down,top-left,top-right,bottom-left,bottom-right
        dirs = [(0,-1), (0,1), (-1,0), (1,0), (-1,-1), (-1,1), (1,-1), (1,1)]
        for dir in dirs:
            r = i+dir[0]
            c = j+dir[1]
            if (r >= 0 and c >= 0 and r < m and c < n and (board[r][c] == 1 or board[r][c] == 2)):
                alive += 1

        return alive
            


        