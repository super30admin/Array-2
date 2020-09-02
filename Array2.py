class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        # Doing with hashmap
        hashmap = {}
        for num in nums:
            hashmap[num] =1
        output =[]
        #checking if hashtable has the number from 1-n or not and if not then storing it in output array
        for num in range(1,len(nums)+1):
            if num not in hashmap:
                output.append(num)
        return output
    """
    TC- O(n)
    SC- O(n)
    Did this code successfully run on Leetcode- Yes :
    Any problem you faced while coding this- No :
    """
        