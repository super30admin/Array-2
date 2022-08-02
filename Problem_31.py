class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        h = {}
        n = len(nums)
        for i in range(len(nums)):
            h[nums[i]] = 1 # Create a key in hashmap for every element in nums
        ans = collections.deque()
        for i in range(1,n+1):
            if i not in h.keys(): # If i is not in the hashmap's keys then i did not occur in nums
                ans.append(i) # So, we add i to our answer
        return ans