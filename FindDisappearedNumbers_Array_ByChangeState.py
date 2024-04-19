# TC: O(2n) Here 2 does not matter,hence it is O(n) afterall
# SC: O(1)

# Logic to find missing elements from array by changing state of elements inside original array. 
# Array's length [n] == range of elements [1...n]

class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        result = []
        n = len(nums)

        for i in range(n):
            element = abs(nums[i])
            #Mark index-1 of all numbers are negative to show that those numbers are present. jhfg
            if nums[element-1] > 0:
                nums[element-1] *= -1

        for j in range(n):
            if nums[j]>0: #Positive numbers are the ones whose index+1 is a missing number
                result.append(j+1)
            else: #Make the number positive to get the original array
                nums[j] *= -1

        return result


obj = Solution()
input = [4,3,2,7,8,2,3,1]
disappeared_numbers_1 = obj.findDisappearedNumbers(input)
print(disappeared_numbers_1)