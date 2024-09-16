# Time Complexity : O(N)
# Space Complexity : O(1) as no extra space, just the output array
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No


def findDisappearedNumbers(nums):
        
        res = []
        for i in range(len(nums)):
            num = abs(nums[i])
            if nums[num-1] > 0:
                nums[num-1] *= -1
        
        for i in range(len(nums)):
            if nums[i] < 0:
                nums[i] *= -1
            else:
                res.append(i+1)
        
        return res

nums = [4, 3, 2, 7, 8, 2, 3, 1]
print(findDisappearedNumbers(nums))