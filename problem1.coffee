#// Time Complexity : O(n) we iterate the input 2 times
#// Space Complexity : O(1) since we use the input array and no additional space
#// Did this code successfully run on Leetcode : yes
#// Any problem you faced while coding this :
# just the mental intuition i would not come up with this algorithm
#
#
#// Your code here along with comments explaining your approach
#
# for all numbers
#   use the number to index into nums
#   set nums[index] = -1
#
# for all numbers (now modified)
#   look for the 2 positive numbers, store their indices
#
# return indices+1

findDisappearedNumbers = (nums) ->
  return [] if nums == null or nums.length == 0

  output = []

  for num in nums
    index = Math.abs(num)-1

    if nums[index] > 0
      nums[index] *= -1

  for num, index in nums
    if nums[index] > 0
      output.push(index+1)

  output

findDisappearedNumbers([-4,-3,-2,-7,8,2,-3,-1])
