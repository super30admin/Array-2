class Solution:
    # leetcode URL : https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
    # Problem : 448. Find All Numbers Disappeared in an Array
    # Time Complexity : O(n)
    # Space Complexity : O (1)
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        ret_list = list()
        for i in range(0,len(nums)):
            if nums[abs(nums[i])-1]>0:
                nums[abs(nums[i])-1] = nums[abs(nums[i])-1]*-1
        for i in range(0,len(nums)):
            if nums[i]>0:
                ret_list.append(i+1)
        return ret_list