# Time Complexity : O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

class Solution:
    def findDisappearedNumbers(self,nums):
        result = []
        if not nums:
            return result 

        for i in range(len(nums)):
            idx = abs(nums[i]) - 1 
            nums[idx] = -1 * abs(nums[idx])
        
        print(nums)
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i+1)
        
        #back to original array 
        for i in range(len(nums)):
            if nums[i] < 0:
                nums[i] = -1 * nums[i]
        # print(nums)
        return result

if __name__ == "__main__":
    s = Solution()
    nums = [4,3,2,7,8,2,3,1]
    res = s.findDisappearedNumbers(nums)
    print(res)