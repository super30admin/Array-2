Problem1 (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)
Time Complexity : O(n)
Space Complexity : O(1)


## trying to do in place here again
## we can iterate over the array and start looking for the element, 
## Once we look at the element go the index meaning if the element is 6 go to index 6 
## and convert it to negative. in the second pass look for any element that is +ve indicating 
## those are not present in arr, add them in list and return
class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        for i in range(len(nums)):
            
            if nums[abs(nums[i])-1] > 0:
                nums[abs(nums[i])-1] *= -1
        res = []
        for i in range(len(nums)):
            if nums[i] >0:
                res.append(i+1)
        return res


Problem 2 https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/
Time Complexity: O(n)
Space Complexity: O(1)



class Solution:

    def find(self, nums):
        n = len(nums)
        i = 0
        ## first pass
        if n % 2 == 0:
            if nums[0] < nums[1]:
                min_val = nums[0]
                max_val = nums[1]
            else:
                min_val = nums[1]
                max_val = nums[0]
            i = 2
        else:
            min_val = max_val = nums[0]
            i = 1
        ## for all the pairs
        while i < n - 1:
            if nums[i] < nums[i + 1]:
                min_val = min(min_val, nums[i])
                max_val = max(max_val, nums[i + 1])
            else:
                min_val = min(min_val, nums[i + 1])
                max_val = max(max_val, nums[i])
            i += 2

        return [min_val, max_val]


Problem 3: https://leetcode.com/problems/game-of-life/
Time Complexity: O(mn)
Space Complexity: O()

class Solution(object):
    def gameOfLife(self, matrix):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        ## we want to do in place and hence cannot change the state right away
        ## we can start assigning different states and then change them in second pass
        ## assigning 2
        ## less than 2 1->0
        ## more than 3 1->0
        ## it will remain 1 no change required
        ## ==2 or ==3 1->1
        ## assigning 3
        ## ==3 0->1
        def count(i,j):
            count =0 
            for dr,dc in [(-1,-1), (-1,0), (-1,1), (0,-1), (0,1), (1,-1), (1,0), (1,1)]:
                row = i+dr
                col = j+dc
                if 0<=row<rows and 0<=col<cols :
                    if matrix[row][col] ==1 or  matrix[row][col] ==2:
                        count +=1
            return count

        rows = len(matrix)
        cols = len(matrix[0])

        for i in range(rows):
            for j in range(cols):
                c = count(i,j)
                val = matrix[i][j]
                if val ==1 and (c<2 or c>3):
                    matrix[i][j] = 2
                if val ==0 and c==3:
                    matrix[i][j] =3
        
        for i in range(rows):
            for j in range(cols):
                if matrix[i][j] ==2:
                    matrix[i][j] =0
                elif matrix[i][j] ==3:
                    matrix[i][j] =1

        return matrix

                

