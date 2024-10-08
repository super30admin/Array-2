class Solution:
    def findDisappearedNumbers(self, nums):
        integers = {}
        missing = []
        #i = 0
        for i in range(len(nums)):
            if i+1 not in integers:
                integers[i+1] = 0
                
            integers[nums[i]] = 1
            #print(integers)
            i += 1
        for key in integers:
            if integers[key] == 0:
                missing.append(key)
        return missing