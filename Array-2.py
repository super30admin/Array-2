
## Problem1 (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if nums == None or len(nums) == 0:
            return []
        result = []
        for i in range(len(nums)):
            index = abs(nums[i]) - 1
            if nums[index] > 0:
                nums[index] = nums[index] * -1
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i+1)
            else:
                nums[i] = nums[i] * -1

        return result

## Problem2-Given an array of numbers of length N, find both the minimum and maximum. 
# Follow up : Can you do it using less than 2 * (N - 2) comparison

#Explanation -Efficient Min-Max Finding Algorithm
# Basic Approach
#Goal: Find minimum and maximum in an array with fewer than 2 * (N - 2) comparisons
#Key strategy: Process elements in pairs to reduce comparison count
#Minimize unnecessary individual element comparisons

def find_min_max(arr):
    n = len(arr)
    if n == 0:
        return None, None
    
    if n % 2 == 0:
        min_val = min(arr[0], arr[1])
        max_val = max(arr[0], arr[1])
        start = 2
    else:
        min_val = max_val = arr[0]
        start = 1
    
    for i in range(start, n, 2):
        if i + 1 < n:
            if arr[i] < arr[i+1]:
                min_val = min(min_val, arr[i])
                max_val = max(max_val, arr[i+1])
            else:
                min_val = min(min_val, arr[i+1])
                max_val = max(max_val, arr[i])
        else:
            min_val = min(min_val, arr[i])
            max_val = max(max_val, arr[i])
    
    return min_val, max_val

#Comparison Efficiency
#Naive approach: 2 * (N - 1) comparisons
#Proposed algorithm: Approximately 3N/2 comparisons
#Reduces comparison overhead by processing elements in pairs
#Most efficient for arrays with more than 3 elements
#4. Complexity Analysis
#Time Complexity: O(N)
#Space Complexity: O(1)
#Comparison Reduction: Less than 2 * (N - 2)
#Optimal for large arrays where minimizing comparisons matters

## Problem3 (https://leetcode.com/problems/game-of-life/)

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        m, n = len(board), len(board[0])
        directions = [(-1,-1), (-1,0), (-1,1), (0,-1), (0,1), (1,-1), (1,0), (1,1)]
        
        def count_live_neighbors(i, j):
            return sum(board[i+x][j+y] & 1 for x, y in directions 
                       if 0 <= i+x < m and 0 <= j+y < n)
        
        for i in range(m):
            for j in range(n):
                live_neighbors = count_live_neighbors(i, j)
                if board[i][j] == 1:
                    if live_neighbors in [2, 3]:
                        board[i][j] = 3  # 11 in binary, live -> live
                else:
                    if live_neighbors == 3:
                        board[i][j] = 2  # 10 in binary, dead -> live
        
        for i in range(m):
            for j in range(n):
                board[i][j] >>= 1  # Right shift to get the new state

#Explanation
# To traverse a matrix in diagonal order, we can use the following algorithm:
# Initialize an empty result list to store the elements in diagonal order.
# Iterate through all possible diagonals, starting from the top-left corner and moving towards the bottom-right corner.
# For each diagonal, collect its elements and add them to the result list in the correct order.

# We first check if the matrix is empty and return an empty list.
# We determine the number of rows (m) and columns (n) in the matrix.
# We iterate through all possible diagonals, which is m + n - 1 in total.
# For each diagonal, we calculate the starting row and column.
# We collect the elements of the current diagonal in a temporary list.
# If the diagonal index is even, we reverse the temporary list before adding it to the result.
# We extend the result list with the elements of the current diagonal.
# The time complexity of this solution is O(m*n), where m is the number of rows and n is the number of columns in the matrix. We visit each element in the matrix exactly once.
# The space complexity is O(m*n) as well, since in the worst case, we need to store all elements of the matrix in our result list