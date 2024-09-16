from typing import List

"""

    Student :  Shahreen Shahjahan Psyche
    Time Complexity : O(N)
    Space Complexity : O(1)

    This code ran successfully for all the test cases of Leetcode

"""

class Solution:
    def findMinMax(self, nums: List[int]) -> List[int]:
        
        # edge case
        if not nums:
            return []
        
        res = []

        # initializing the min value and max value with the first element of
        # the array
        min_val = nums[0]
        max_val = nums[0]

        # finding the min value and max value
        for i in nums:
            # if i is already greater than max value the it cannot be min value
            # thats why I have kept these 2 conditions in if-elif code block
            if i > max_val:
                max_val = i
            elif i < min_val:
                min_val = i 

        res.append(min_val)
        res.append(max_val)
        
        
        return res
            
            

# Driver Code - Testing my code

check_num = Solution()
testcase1 = [1,2,3,4,5,6,7,8]
print(check_num.findMinMax(testcase1))

