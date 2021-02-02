// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        if nums==None or len(nums)==0:
            return 
        lst=[]
        n=len(nums)
        for i in range(n):                                //traverse the list and num[i]-1 will the index in the list then multiply the element at that index with -1 if it is positive in this way we will be able to keep a track of numbers which are present
            index=abs(nums[i])-1
            if nums[index]>0:
                nums[index]*=-1 
         
        for i in range(n):              //traverse the list if we encounter any positive element it means that the (index+1) element is missing and we can append that element in output list
            if nums[i]>0:
                lst.append(i+1)
        return lst
