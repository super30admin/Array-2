  ---------------------- Missing numbers in the array------------------------------------------------   
# Time Complexity : O(N) N is the length of the nums.
# Space Complexity : O(1) as I am returning the same array used for exploring numbers
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here I have used a set, where I converted my array into elements of set. Then I iterated through the array and checked whether 
#my index+1 is in set or not. If it is present I will remove the number from set, else I will add the missing number to set. 



class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if not nums:
            return []
        s = set(nums)
        for i in range(len(nums)-1, -1, -1):
            if i+1 not in s:
                s.add(i+1)
            else:
                s.remove(i+1)
                
        
        return s