"""
Go through array in pairs, comparing them to find local min and max
Compare the smaller of the pair with global min, and larger with global max
If the array length is odd initialize differently i.e handle the first element alone
"""
"""
Time Complexity: O(n) — All elements visited once
Space Complexity: O(1) — No extra space used
"""

class minMax:
    def find_min_max(self,nums):
        n = len(nums)
        if n == 0:
            return None, None

        if n % 2 == 0:
            if nums[0] < nums[1]:
                min_val, max_val = nums[0], nums[1]
            else:
                min_val, max_val = nums[1], nums[0]
            start = 2
        else:
            min_val = max_val = nums[0]
            start = 1

        for i in range(start, n, 2):
            if i + 1 >= n:
                break
            if nums[i] < nums[i + 1]:
                min_val = min(min_val, nums[i])
                max_val = max(max_val, nums[i + 1])
            else:
                min_val = min(min_val, nums[i + 1])
                max_val = max(max_val, nums[i])

        return min_val, max_val
    
if __name__=="__main__":
    obj = minMax()
    nums = [4,3,7,8,2,3,1]
    print(obj.find_min_max(nums))
