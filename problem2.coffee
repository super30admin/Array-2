#// Time Complexity : (3 comparisons * n/2 pairs) + (optionally 2 comparisons * 1 odd number) = O(3N/2 + 3) or O(3N/2)
#// Space Complexity : O(1) 2 variables, min and max
#// Did this code successfully run on Leetcode : not applicable
#// Any problem you faced while coding this :
# Mental approach to get to this solution, i would never have thought of it
#
#// Your code here along with comments explaining your approach
#
# create a min and max variable, which we'll return
# iterate by 2's through the input
#   if the input doesn't have a pair
#      it is single so just compare it with min and max
#   else it is a pair
#      if the first < second
#        compare min to first
#        compare max to second
#      else
#        compare min to second
#        compare max to first

findMinAndMax = (nums) ->
  return [-1, -1] if nums == null || nums.length < 1
  return [nums[0], nums[0]] if nums.length == 1

  min = Number.MAX_SAFE_INTEGER
  max = Number.MIN_SAFE_INTEGER

  for i in [0..(nums.length-1)] by 2
    if i+1 == nums.length # this one doesn't have a pair, special case it
      if nums[i] < min
        min = nums[i]
      else if nums[i] > max
        max = nums[i]
    else
      if nums[i] < nums[i+1]
        min = Math.min(min, nums[i])
        max = Math.max(max, nums[i+1])
      else
        min = Math.min(min, nums[i+1])
        max = Math.max(max, nums[i])

  [min, max]

findMinAndMax([2,5,6,7,8,9,1])
