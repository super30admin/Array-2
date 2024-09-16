"""
// Time Complexity :O(n) Iterating over an array once
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :NA

//Explanation:
//O(n) solution:
Since the range of the array is from 1 to n, we need to adjust the
index accordingly.
if the value is present at that index, make value present at
that position NEGATIVE
if the value in an array is POSITIVE,the index value is missing in the array
nums->[4,3,2,7,8,2,3,1]
nums->[-4,-3,-2,-7,-8,2,3,1]-> 2 and 3 are positive numbers at index 5,6.
Hence the missing number is 5,6
"""
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        temp = 0
        res = []


        for i in range(len(nums)):
          temp= abs(nums[i])
          temp -= 1
          nums[temp] = -abs(nums[temp])

        for i in range(len(nums)):
          if nums[i]>0:
            res.append(i+1)
        return res

if __name__ == "__main__":
  s = Solution()
  n = [2,2]
  print(s.findDisappearedNumbers(n))
