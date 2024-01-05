'''
Time complexity: O(n) because it traverses through each value in the array
Space complexity: O(n) , not sure. 
'''
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        missing_arr = []
        for i in range(len(nums)):
            if (nums[i]>0):
                if nums[abs(nums[i])-1]>0:
                    nums[abs(nums[i])-1]=nums[abs(nums[i])-1]*-1
            if (nums[i]<0):
                if nums[abs(nums[i])-1]>0:
                    nums[abs(nums[i])-1]=nums[abs(nums[i])-1]*-1
        
        for i in range(len(nums)):
            if nums[i]>0:
                missing_arr.append(i+1)

        return missing_arr