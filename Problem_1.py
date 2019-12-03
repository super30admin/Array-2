# Runs on leetcode --all three approaches
# Run time Complexities are o(n) for all methods
# Memory complexity is O(1) for first method --without extra space & O(n) for both set and hashmap methods


def findDisappearedNumbers_without_extra_space(nums):
      result = []
      for i in range(len(nums)):
          if nums[abs(nums[i])-1]>0:
              nums[abs(nums[i])-1] = -nums[abs(nums[i])-1]

      for i in range(len(nums)):
          if nums[i] >0:
              result.append(i+1)
      return result

def findDisappearedNumbers_hashmap(nums):
      result = []
      d = {}
      for i in nums:
          if i not in d:
              d[i] =1
          else:
              d[i] +=1
      print(d)

      for i in range(1,len(nums)+1):
          if i not in d:
              result.append(i)
          else:
              continue
      return result

def findDisappearedNumbers_set(nums):
      result = []
      s = set()
      for i in nums:
          s.add(i)

      for i in range(1,len(nums)+1):
          if i not in s:
              result.append(i)
      return result
      
      
print(findDisappearedNumbers_set([4,3,2,7,8,2,3,1]))
print(findDisappearedNumbers_hashmap([4,3,2,7,8,2,3,1]))
print(findDisappearedNumbers_without_extra_space([4,3,2,7,8,2,3,1]))
   
