#Arrays-2
#Problem 2: Given an array of numbers of length N, find both the minimum and maximum. 
#Follow up : Can you do it using less than 2 * (N - 2) comparison
#Time Complexity-O(N)
#Space Complexity-O(1)

class MinAndMax(object):
#Traverse on a pair of 2 elements at a time, and update overall max
#and min with the pair's max and min if required.

    def minAndMax(self, nums):

        if (nums == None or len(nums) == 0):
            return [-1, -1]

        oddLength = 0
        if len(nums) / 2 != 0:
            oddLength = 1

        globalMax = float('-inf')
        globalMin = float('inf')

        for i in range(0, len(nums) - 1, 2):
            if nums[i+1] > nums[i]:
                currentMax = nums[i+1]
                currentMin = nums[i]
            else:
                currentMax = nums[i]
                currentMin = nums[i + 1]

            if currentMax > globalMax:
                globalMax = currentMax
            if currentMin < globalMin:
                globalMin = currentMin

        if (oddLength):
            if nums[len(nums) - 1] > globalMax:
                globalMax = nums[len(nums) - 1]
            if nums[len(nums) - 1] < globalMin:
                globalMin = nums[len(nums) - 1]

        return [globalMin, globalMax]

sol = MinAndMax()
print(sol.minAndMax([5, 4, 3, 2, 1]))



        
        















