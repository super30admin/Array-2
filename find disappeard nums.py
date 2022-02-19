# // Time Complexity : O(n)
# // Space Complexity : o(n)
# // Did this code successfully run on Leetcode : yes
# // Three line explanation of solution in plain english:
# Use set to remove duplicates and create a new set with the range of
# input nums length. return the missing elements by subracting the two sets


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        # gets unique numbers
        set_nums = set(nums)
        
        # new set
        l = set()
        
        # add all the element until the len of nums
        for i in range(1, len(nums)+1):
            l.add(i)
                
        # returns the missing element
        return l - set_nums
        