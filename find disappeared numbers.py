#TC: O(n), n is len of nums
#SC: O(n)
#LC: yes, 448
#problems: NA

class Solution(object):
    def findDisappearedNumbers(self, nums):
        hash_table = {}

        for num in nums:
            hash_table[num] = 1
        
        result = []    
        
        for num in range(1, len(nums) + 1):
            if num not in hash_table:
                result.append(num)
                
        return result         
                
#TC: O(n), n is len of nums
#SC: O(1)
class Solution(object):
    def findDisappearedNumbers(self, nums):
        n = len(nums)
        result = []
        for i in range(0,n):
            idx = abs(nums[i]) - 1
            
            if(nums[idx] > 0):
                nums[idx] *= -1
                
        for i in range(0,n):
            if(nums[i] > 0):
                result.append(i + 1)
            else:
                nums[i] *= -1
                
        return result