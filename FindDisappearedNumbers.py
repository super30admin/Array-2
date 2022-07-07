from pip import List
class Solution:
    #Time Complexity = O(n)
    #Space Complexity = O(1)
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if(len(nums)==0):
            return []
        diff = 0
        list = []
        for i in range(len(nums)):
            diff = abs(nums[i])-1
            if(nums[diff]>0):
                nums[diff] = -1 * nums[diff]
        for i in range(len(nums)):
            if(nums[i]>0):
                list.append(i+1)
            else:
                nums[i] = nums[i]*-1
        return list
                

        