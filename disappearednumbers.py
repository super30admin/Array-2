# // Time Complexity :O(n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        mem=set(nums)
        x=[]
        for i in range(1,len(nums)+1):
            if i not in mem:
                x.append(i)
        return x
