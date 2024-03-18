#Problem 1
# Bruteforce
# T.C. O(n)
# S.C. O(n)
# Here, we put all the elements in a hashmap. then check the 1 to N to whether it exists in a hashmap

  hmap = {}
  dis_num = []

  for i in range(len(nums)):
      if nums[i] not in hmap:
          hmap[nums[i]] = 1
   
  for j in range(1, len(nums) + 1):
      if j not in hmap:
          dis_num.append(j)

  return dis_num

# Optimized 
#T.C = O(n)
#S.C = O(1)

# I have implemented an inplace algorithm here. Basically, we will check the original element with the index. and if it's not there, mark it negative.
# in second pass, we will iterate through the array again and basically, the index of non-negative ones are the missing elements.
# element = index + 1

 result = []
  n = len(nums)
  for i in range(n):
      idx = abs(nums[i]) - 1
      if nums[idx] > 0:
          nums[idx] *= -1
  for i in range(n):
      if nums[i] > 0:
          result.append(i+1)
      else:
          nums[i]*= -1
  return result   
