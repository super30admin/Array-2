#time complexity : O(n)
#space complexity : O(1)
#Did this code successfully run on Leetcode : Yes
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result = []
        #checking for the null case
        if nums == None :
            return result

        #creating for loop for the making the present index numbers negative 
        for i in range(len(nums)):
            #storing the index of the present number
            #Absolute of the number is taken because it might have became negative according to the index it is present on 
            index = abs(nums[i])-1

            #if the particular number is present twice then there might be the case that the number at the index is already negative so if checking before making the number negative
            if nums[index]>0:
                nums[index] *= -1
        #creating the for loop for checking which numbers are missing and then again making all the negative numbers positive so that there is no mutation
        for i in range(len(nums)):
            if (nums[i]>0):
                result.append(i+1)
            else:
                nums[i] *= -1
        return result
