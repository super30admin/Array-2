# Time Complexity : O(n)
# Space Complexity : O(1)


# iterate over nums array
# when we got any number, we wiil go to the it's corresponding index and make it negative
# after that, we will go again to the nums array 
# check which number is positive, if any numbers is possitive, it means it's index was not in array 
# append that index into result array
class Solution:
    def findDisappearedNumbers(self, nums):
        n = len(nums)
        result = []
        for i in range(0,n):
            idx = abs(nums[i]) - 1
            nums[idx] = abs(nums[idx])* -1

        for i in range(0,n):
            if nums[i] > 0:
                result.append(i+1)
        return result

obj = Solution()
print(obj.findDisappearedNumbers([4,2,2,7,8,2,3,1]))