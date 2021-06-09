class Solution:
    def getMinMax(self, nums):
        if len(nums)%2 != 0:
            mini = nums[0]
            maxi = nums[0]
            j=1
        if len(nums)%2==0:
            if nums[0]<nums[1]:
                mini = nums[0]
                maxi = nums[1]
            else:
                mini = nums[1]
                maxi = nums[0]
            j=2
        while j < len(nums)-1:
            if(nums[j]<nums[j+1]):
                mini=min(mini, nums[j])
                maxi=max(maxi, nums[j+1])
                print(mini, maxi)
            else:
                mini=min(mini, nums[j+1])
                maxi=max(maxi, nums[j])
                print(mini, maxi)
            j+=2
        return mini, maxi



sol= Solution()
print(sol.getMinMax([9,8,7,6]))

"""Time complexity: O(n)
space complexity - O(1)
if nums length is odd: No. of comparisions required are 3*(n-1)/2
if nums length is even: No. of comparisions required are 1+3*(n-2)/2"""