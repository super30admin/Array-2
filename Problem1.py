# Time Complexity : O(n) where n is the length of the list.
# Space Complexity : O(n) for the hashMap (hm)
# Did this code successfully run on Leetcode : Yes.
# Any problem you faced while coding this : No
    
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        hm = [None]* (len(nums) + 1)
        n = len(nums) +1
        for i in nums:
            h = i % n
            hm[h] = i
        result = []
        for i in range(1,len(hm)):
            if hm[i] == None:
                result.append(i)
        return result
                
        