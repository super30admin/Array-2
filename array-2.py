# problem 1 : 448. Find All Numbers Disappeared in an Array : https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if not nums :
            return []
        # in place O(n)
        for i in range(len(nums)):
            if nums[abs(nums[i]) - 1] > 0:
                nums[abs(nums[i]) - 1] *= -1
        res = []
        for ele,i in enumerate(nums):
            if i > 0 :
                res.append(ele + 1)
        return res




# problem 2 : Maximum and minimum of an array using minimum number of comparisons : https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/
# Time Complexity : O(n) : 3 * (n-1)/ 2 comparision if n is odd else 1 + 3*(n-2)/2 comparison if n is even
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

def getMinMax(arr) -> (int,int):
  if len(arr) == 1:
    return (arr[0],arr[0])
  else:
    mi, ma = arr[0], arr[1]
    if arr[0] > arr[1]:
      mi, ma = arr[1], arr[0]
    
    if len(arr) % 2:
      i = 2
      while i < len(arr)-1:
        tmin, tmax = arr[i], arr[i+1]
        if tmin > tmax:
          tmin, tmax = tmax, tmin
        if tmin < mi:
          mi = tmin
        if tmax > ma:
          ma = tmax
        i += 2
      if arr[-1] < mi:
        mi = arr[-1]
      if arr[-1] > ma:
        ma = arr[-1]
      return (mi,ma)
    else:
      i = 2
      while i < len(arr):
        tmin, tmax = arr[i], arr[i+1]
        if tmin > tmax:
          tmin, tmax = tmax, tmin
        if tmin < mi:
          mi = tmin
        if tmax > ma:
          ma = tmax
        i += 2
      return (mi,ma)

arr = [1000, 11, 445, 1, 330, 3000] 
mx, mn = getMinMax(arr) 
print("Minimum element is", mx) 
print("Maximum element is", mn) 



# problem 3 : 289. Game of Life : https://leetcode.com/problems/game-of-life/
# Time Complexity : O(m*n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
    def gameOfLife(self, board):
        m,n = len(board), len(board[0])
        for i in range(m):
            for j in range(n):
                if board[i][j] == 0 or board[i][j] == 2:
                    if self.nnb(board,i,j) == 3:
                        board[i][j] = 2
                else:
                    if self.nnb(board,i,j) < 2 or self.nnb(board,i,j) >3:
                        board[i][j] = 3
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2: board[i][j] = 1
                if board[i][j] == 3: board[i][j] = 0

    def nnb(self, board, i, j):
        m,n = len(board), len(board[0])
        count = 0
        if i-1 >= 0 and j-1 >= 0:   count += board[i-1][j-1]%2
        if i-1 >= 0:                count += board[i-1][j]%2
        if i-1 >= 0 and j+1 < n:    count += board[i-1][j+1]%2
        if j-1 >= 0:                count += board[i][j-1]%2
        if j+1 < n:                 count += board[i][j+1]%2
        if i+1 < m and j-1 >= 0:    count += board[i+1][j-1]%2
        if i+1 < m:                 count += board[i+1][j]%2
        if i+1 < m and j+1 < n:     count += board[i+1][j+1]%2
        return count

