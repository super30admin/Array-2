# problem 2
class Problem2:
    def findMinAndMax(self, nums):
        n = len(nums)
        i = 0
        if n%2 == 0:
            if nums[i] < nums[i+1]:
                min_val = nums[i]
                max_val = nums[i+1]
            else:
                min_val = nums[i+1]
                max_val = nums[i]
            i = 2
        else:
            min_val = nums[i]
            max_val = nums[i]
            i = 1

        while i < n-1:
            if nums[i] < nums[i+1]:
                min_val = min(min_val,num[i])
                max_val = max(max_val,num[i+1])
            else:
                min_val = min(min_val,num[i+1])
                max_val = max(max_val,num[i])
            i+=2
        return [min_val,max_val]