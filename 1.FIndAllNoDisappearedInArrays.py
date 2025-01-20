"""
Time Complexity: 0(n) + 0(n)
Space Complexity: 0(1)
Approach: 
    1. if i is my index, my value is i+1
    2. get value i.e. nums[i]
    3. get the idx i.e. nums[i]-1
    4. go to idx and update the nums[idx] by multiplying with -1
"""
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        for i in range(0,len(nums)):
            
            # get idx
            idx = abs(nums[i])-1

            # mutate the nums
            if nums[idx] < 0:
                continue
            else:
                nums[idx] = -1 * nums[idx]
        
        # end of for loop

        result = []

        for i in range(0,len(nums)):
            if nums[i] > 0:
                result.append(i+1)
        # end of for loop

        return result