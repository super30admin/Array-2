#Time Complexity is: O(n) where n is the sixe of the array
#Space complexity is: O(1) since we are working on the input array
#Program ran successfully on leetcode
#Faced no problems while coding this program

#Program to find all numbers disappeared in an array
class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        #Traversing therough the entire given array
        for i in range(0, len(nums)):
            #taking the absolute value present at a particular index
            x=abs(nums[i])
            #we will go to index x-1 and we will check if it is positive or negative
            #if the value is positive, we will convert to negative, 
            #to make sure that that value x is present in the array
            if(nums[x-1]>0):
                nums[x-1]*=-1
        #creating an array to store missing values in the array
        arr=[]
        for i in range(0,len(nums)):
            #if any value in the array at a particular index is greater than 0, 
            #we will add that value to the array 
            if(nums[i]>0):
                arr.append(i+1)
            #otherwise we will just multiply with -1 to bring the nums array to original state
            else:
                nums[i]*=-1
        #returning the final array which contains missing values
        return arr
