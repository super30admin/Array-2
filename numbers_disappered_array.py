# time complexity: O(n)
# space complexity: O(1)
# approach: subtract 1 from the abs of value
# go to this index and make it negative
# now traverse this updated array and if the value is positive, 
# add one to that index and append to the result




class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = []
        for i in range(n):
            num = abs(nums[i])
            if nums[num-1]>0:
                nums[num-1] = -nums[num-1]
        for i in range(n):
            if nums[i]>0:
                result.append(i+1)
            else:
                nums[i] = -nums[i]
        return result
        
        
                
        