# // Time Complexity : O(n)
# // Space Complexity : O(1), since res is returned as output
# // Did this code successfully run on Leetcode : Yes
# // Your code here along with comments explaining your approach
# We mutate the array itself, to save on SC.
# If element, is present, we mark nums[element-1]'s element as negative
# Then, whatever index+1 of positive elements are the missing numbers
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        # Hashet - O(n) Time and space complexity
        # num_set=set(nums)
        # n=len(nums)
        # res=[]
        # for i in range(1,n+1): 
        #     if i not in num_set: #iterate from 1 to n (range from question), and whatever number is missing append to res
        #         res.append(i)
        # return res
        for i in range(len(nums)):
            index=abs(nums[i]) #incase, of repeats - use abs()
            if nums[index-1]>0: #if not negative already, make it negative
                nums[index-1]*=-1
            
        res=[]
        for i in range(len(nums)):
            if nums[i]>0: #whatever element is positive, that index+1 is the missing element
                res.append(i+1)
            else:          #Incase, we are asked to return the original array back
                nums[i]*=-1
        print(nums)
        return res