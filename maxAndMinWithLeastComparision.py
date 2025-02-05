class Solution:
    def __init__(self):
        pass

    def maxMin(self, nums) -> None:

        # compare in pairs
        maxx = float('-inf')
        minn = float('inf')

        for i in range(len(nums)):
            if i+1 == len(nums):
                # odd length, last values comparision
                maxx =  max(maxx, nums[i])
                minn = min(minn, nums[i])
            else:
                if nums[i] > nums[i+1]:
                    # odd length, last values comparision
                    maxx =  max(maxx, nums[i])
                    minn = min(minn, nums[i-1])
                else:
                    maxx =  max(maxx, nums[i+1])
                    minn = min(minn, nums[i])
        
        print(maxx, minn)
        return
    

nums = [-1, 2, 3, 4, 6, 8, 9, 42, 312, 3, -123]
Solution().maxMin(nums)
