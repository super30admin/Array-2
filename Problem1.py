# https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

# Hashset solution 
# TC: O(2n)
# SC: O(n)

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        hs = set()
        res = []
        for num in nums:
            if num not in hs:
                hs.add(num)

        for i in range(1, len(nums)+1):
            if i not in hs:
                res.append(i)

        return res
    
# Solution2: Sorting and traversing the sorted array to check for 1 to n
# TC: O(n log n) + O(n)
# SC: O(1)

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        boo = [False] * (len(nums)+1)
        res = []
        
        for num in nums:
            boo[num] = True

        for i in range(1, len(nums)+1):
            if boo[i] == False:
                res.append(i)

        return res
    
# Solution2: Boolean array
# TC: O(2n)
# SC: O(1)  
    
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for i in range(len(nums)):
            idx = abs(nums[i]) - 1

            if nums[idx] > 0:
                nums[idx] = nums[idx] * -1

        res = []

        for i in range(len(nums)):
            if nums[i] > 0:
                res.append(i+1)

        return res