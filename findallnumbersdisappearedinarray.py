class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        return list(set([i for i in range(1,len(nums)+1)]).difference(set(nums)))

#TC : O(n)
#SC : O(1)

# is it advisable to submit such solution?
