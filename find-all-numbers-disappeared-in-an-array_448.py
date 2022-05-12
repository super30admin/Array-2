#Time Complexity O(N) 2 times traversal
#Space Complexity O(1) 
#It successfully runs on the leetcode

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        #State change in the corresponding index if the particular number is in the array
        for i in nums:
           nums[abs(i)-1] = -abs(nums[abs(i)-1])
           
        return [i+1  for i in range(len(nums)) if nums[i] > 0] 

   

        