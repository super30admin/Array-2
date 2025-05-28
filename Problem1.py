# // Time Complexity :O(N)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no

https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
# // Your code here along with comments explaining your approach


class Solution:
  """
  here we know ip range is [1,n] we will make use it by visting each idx and making it -ve(we can't make any other chages and we too retain info)
  After that we go to each idx and see if it is +ve or -ve 
  """
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for i in nums:
            idx=abs(i)-1
            if nums[idx]>0:
                nums[idx]=-1*nums[idx]
        ans=[]
        for i in range(len(nums)):
            if nums[i]>0:
                ans.append(i+1)
        return ans



class Solution:
  """
  getting from set is O(1) TRY thinking of data structure ,O(N,N)
  """
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        s=set(nums)
        l=[]
        for i in range(1,len(nums)+1):
            if i not in s:
                l.append(i)
        return l
        
