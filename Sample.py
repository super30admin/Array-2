# Problem 1: Find disappeared numbers in a given array having values from 1 to n (not sorted)
# Time Complexicity: O(n), Space Complexicity: O(1)

class Solution:
    
	"""
	Make use of indices to reverse sign of the numbers
	- at the end, the indices of positive numbers + 1 should return list of missing numbers
	"""
	
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        result = []; n = len(nums)
        if n == 0: return result
        else:
            for i in range(n):
                indx = abs(nums[i]) - 1
                if nums[indx] > 0 : nums[indx] *= -1
            for i in range(n):
                if nums[i] > 0:
                    result.append(i+1)
                else: nums[i] *= -1
        return result
		
		
# Problem 2: Game of life, make an element in a given array given by 0-dead, 1-alive using 4 rules
# Time Complexicity: O(m*n), Space Complexicity: O(1)

class Solution:		
  
    def gameOfLife(self, board: List[List[int]]) -> None:
        
        """
        Do not return anything, modify board in-place instead.
		- develop another function to count the neighbors (alive in original)
		- replace existing live by 1 and dead by 0
        """
        
        if len(board) == 0: return
        # Alive to Dead 1 -> 0 (-1)
        # Dead to Alive 0 -> 1 (+2)
        m, n = len(board), len(board[0])
        
        def count(i, j):
            dirs = [(-1,1), (0,1), (1,1), (-1,0), (1,0), (-1,-1), (0,-1), (1,-1)]; count = 0
            for dir_ in dirs:
                r = dir_[0] + i; c = dir_[1] + j
                if r >= 0 and c >= 0 and r < m and c < n and (board[r][c] == -1 or board[r][c] == 1):
                    count += 1
            return count

        for i in range(m):
            for j in range(n):
                # underpopulation and alive -> dead
                if count(i, j) < 2 and board[i][j] == 1:
                    board[i][j] = -1
                # overpopulated and alive -> dead
                if count(i, j) > 3 and board[i][j] == 1:
                    board[i][j] = -1
                # just right population
                if count(i, j) == 2 or count(i, j) == 3:
                    board[i][j] = board[i][j]
                # exactly 3 neighbors
                if count(i, j) == 3 and board[i][j] == 0:
                    board[i][j] = 2
                    
        for i in range(m):
            for j in range(n):
                if board[i][j] == -1:
                    board[i][j] = 0
                if board[i][j] == 2:
                    board[i][j] = 1
                    
        return board


# Extra question: find maximum and minimum element in a given array: (discussed in class), Time Complexicity: O(3*n/2) 
# {specifically mentioned in class, please verify}

def findMax(array):
    
    if len(array) == 0: return
    left = 0; right = len(array)-1

    while left < right:
        if array[left] < array[right]:
            left += 1
        else:
            right -= 1

    return array[left]

def findMin(array):
    
    if len(array) == 0: return
    left = 0; right = len(array)-1
    
    while left < right:
        if array[right] < array[left]:
            left += 1
        else:
            right -= 1

    return array[right]
