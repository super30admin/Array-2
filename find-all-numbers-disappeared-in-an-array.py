class Solution:
    '''
    TC: O(2n) = O(n)
    SC: O(1)
    Leetcode: Compeleted the problem
    Issue: no issue
    '''
    def findDisappearedNumbers(self, nums):
        n = len(nums)
        for i in range(n):
            # Convert to abs to get the actual element
            idx = abs(nums[i]) - 1

            if nums[idx] > 0:
                # convert the element to neg to mark it as available.
                nums[idx] = - nums[idx]

        res = []
        # Get the result
        for i in range(n):
            if nums[i] > 0:
                # + 1 for getting index for 0 based list.
                res.append(i + 1)
        
        return res

    def findDisappearedNumbers(self, nums):
        n = len(nums)
        id = nums[0]




s = Solution()
nums = [4,3,2,7,8,2,3,1]
print(s.findDisappearedNumbers(nums))
nums = [1,1]
print(s.findDisappearedNumbers(nums))
