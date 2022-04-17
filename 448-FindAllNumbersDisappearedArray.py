#Time Complexity : O(N ) where N is number of elements
# Space Complexity : O(N) for the output array
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this :
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
            hashset = set()
            output = []
            for i in range(0,len(nums)):
                hashset.add(nums[i])
            print(hashset)
            for i in range(1,len(nums)+1):
                if i not in hashset:
                    output.append(i)
            return output   