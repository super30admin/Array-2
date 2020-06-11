# Time Complexity : O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

class Solution:
    def checkMinMax(self,nums):
        if not nums:
            return []
        minn, maxx = float("inf") , float("-inf")
        i = 2
        while i < len(nums)+2:
            if nums[i-2] > nums[i-1]:
                if maxx < nums[i-2]:
                    maxx = nums[i-2]
                if minn > nums[i-1]:
                    minn = nums[i-1]
            else:
                if maxx < nums[i-1]:
                    maxx = nums[i-1]
                if minn > nums[i-2]:
                    minn = nums[i-2]
            i += 2 
        return [minn, maxx]
        
        
            
        
if __name__ =="__main__":
    s = Solution()
    nums = [4,3,2,7,8,2,3,1]
    res = s.checkMinMax(nums)
    print(res)     