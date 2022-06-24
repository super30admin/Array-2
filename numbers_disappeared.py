'''
-- Passed test cases on LeetCode
'''
class Solution:
    #O(n) - Time complexity ; O(1) - Space complexity
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for i in range(len(nums)):
            index = abs(nums[i]) - 1
            
            if nums[index] > 0:
                nums[index] *= -1
            
        res = []
        
        for i in range(1, len(nums) + 1):
            print(i)
            if nums[i - 1] > 0:
                res.append(i)
        return res
        
        # Solution Using an Array
        #O(n) - Time complexity ; O(n) - Space complexity
        '''
        arr =[0 for i in range(len(nums)+1)]
        print(arr)
        
        for i in nums:
            print(i)
            arr[i] +=1
        print(arr)
        res = []
        for i in range(len(arr)):
            if i != 0 and arr[i] == 0:
                res.append(i)
        return res
        '''
        # Solution using a hashmap
        #O(n) - Time complexity ; O(n) - Space complexity
        '''
        hash_map = {}
        res = []
        
        for i in nums:
            hash_map[i] = 1
            
        for i in range(1, len(nums) + 1):
            if i not in hash_map:
                res.append(i)
                
        return res
        '''
        
        
        
