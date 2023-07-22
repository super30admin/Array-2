#Time Complexity: O(n)
#Space Complexity: O(1)

#Iterate over the elements in the given array, if the number is present (first occurance) then mark its position in the array using - sign. If the position is already with - sign then it indicates that the number is a duplicate.
#Iterate over the elements finally and if it is positive then the element which has to occupy the index is missing 
#Applicable only for positive array greater than 0

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        output=[]
        for i in range(0, len(nums)):
            index = abs(nums[i])-1
            if nums[index]>0:
                nums[index]=-nums[index]
        
        for i in range(0, len(nums)):
            if nums[i]<0:
                nums[i]=abs(nums[i])
            else:
                output.append(i+1)
        return output

        