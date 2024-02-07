class Solution: 
    def getMinMaxArray (self, nums[List[int]]) -> (arraymin(int), arraymax(int)):
        n = len(nums)
        arraymin, arraymax
        if (n % 2 == 0):
            if nums[0]< nums[1]:
                arraymin = nums[0]
                arraymax = nums[1]
            else:
                arraymin = nums[1]
                arraymax = nums[0]
        else:
            arraymin = nums[0]
            arraymax = nums[0]

        # iterate over the elements of nums in pairs and compare to array min and array max 
        i = 0
        while (i < n-1):
            if nums[i] < nums[i+1]:
                arraymin = min(arraymin,nums[i])
                arraymax = max(arraymax, nums[i+1])
            else:
                arraymin = min(arraymin,nums[i+1])
                arraymax = max(arraymax, nums[i])   
            i += 2
            
        return( arraymin, arraymax)

