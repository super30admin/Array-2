# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution:
    def findDisappearedNumbers(self, nums):
        result = [0] * (len(nums)+1)
        for i in nums:
            result[i] +=1
        temp = []
        for index, val in enumerate(result):
            if index != 0 and val == 0:
                temp.append(index)
        return temp