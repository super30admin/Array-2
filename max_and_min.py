#  Problmep- An array of numbers of length N is given , you need to find the minimum and maximum. try doing this in less than 2* (N-2) comparisons

# To reduce the comparisions, comapring the pairs of the array. At first, fiund out the min and max from the first pair and comparing that with the min and max element of the next pair. Accordingly incrementing the pointer by 2.

# Time Complexity- O(n) Space Complexity- O(1)

class Solution:
    def findMinAndMax(self, nums):
        n = len(nums)
        i = 0
        # check if the nums have even numbers
        if n % 2 == 0:
            # comapare first and second and find the min and max from them
            if nums[0] < nums[1]:
                min_val = nums[0]
                max_val = nums[1]
            else:
                min_val = nums[1]
                max_val = nums[0]
            # change the pointer to 2nd position
            i = 2
        # if the nums have odd numbers set first element as min and max
        else:
            min_val = max_val = nums[0]
            i = 1
        # below part reduces the comparision by comparing pairs at a time which is nums[i] and nums[i + 1]
        while i < n - 1:
            # find out the min and max from the next pair
            if nums[i] < nums[i + 1]:
                # if the first element is small
                min_val = min(min_val, nums[i])
                max_val = max(max_val, nums[i + 1])
            # if the second element is small
            else:
                min_val = min(min_val, nums[i + 1])
                max_val = max(max_val, nums[i])
            # increment the pointer by 2 for next pair
            i += 2

        return [min_val, max_val]
    
solution = Solution()
print(solution.findMinAndMax([3,2,6,5,1,7,9]))