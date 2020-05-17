"""
// Time Complexity :O(n) Iterating over an array once
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :NA
// Any problem you faced while coding this :NA

//Explanation:
Compare the 
"""
class Solution:
  def getMinMax(self,nums):
    minEle = nums[0]
    maxEle = nums[0]

    for i in range(1, len(nums)-1,2):
     # edge case len(nums) -1
      if i == len(nums) - 1 :
        if nums[i] > maxEle: maxEle = nums[i]
        if nums[i] < minEle : minEle = nums[i]
      elif nums[i] > nums[i+1]:
        if nums[i] > maxEle: maxEle = nums[i]
        if nums[i+1] < minEle: minEle = nums[i]
      else:
        if nums[i+1] > maxEle: maxEle = nums[i+1]
        if nums[i] < minEle : minEle = nums[i]
    return minEle,maxEle


if __name__ == "__main__":
  nums = [2,8,6,2,11,5,70]
  s = Solution()
  print(s.getMinMax(nums))
