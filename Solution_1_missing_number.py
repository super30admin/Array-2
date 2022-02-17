// Time Complexity : O(n) 
// Space Complexity : O()
// Did this code successfully run on Leetcode : Time limit exceeded
// Any problem you faced while coding this : No
'''
1. Get unique set of elements
2. Iterate over the set for range in 1 and n and check if present or not
3. If not present, append to list
4. return the list


'''

class Solution1:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        k=set(nums)
        s=[]
        for i in range(1,len(nums)+1):
            if i in k:
                pass
            else:
                s.append(i)
        return s
		
		
// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Time limit exceeded
// Any problem you faced while coding this : No
'''
1. Iterate over the list. for each value at the array index, 
   multiply  the value by -1. if number is 
   already negative, do not change it.
   
2. The positive values index+1 is the missing number

3. return the missing numbers.


'''		
		
		
class Solution:
    def findDisappearedNumbers(self, k: List[int]) -> List[int]:
        for index in range(0 ,len(k)):
            val=k[index]
            if k[abs(val)-1]>0:
                k[abs(val)-1]=k[abs(val)-1]*-1
                
        s=[]   
        for i in range(0,len(k)):
            if k[i]>0:
                s.append(i+1)
        return s
        