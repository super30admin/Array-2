# Find the min and max with less comparsions
# Brute force takes O(2n)---for 1 value we compare twice
# asymtotic comparison is O(n)---
# Consider O(2n)
# In my approch, I will compare nums[i] with nums[i+1] and after comparing this, compare with max and and min with min_value 
def max_min(nums):
  max_value='-inf'
  min_value='inf'
  for i in range(len(nums)):
    # if condition is saving the one comparision
    # now total comparisions for two values  in a list would be 3 at most
    if (nums[i]>nums[i+1]):
      max_value=max(nums[i],max_value)
      min_value=min(nums[i+1,min_value])
    else:
      min_value=min(nums[i],min_value)
      max_value=max(nums[i+1],max_value)







