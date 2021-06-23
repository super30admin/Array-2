
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        #Defining the output list
        list= []

        #Looping over the input array 
        # to mark all values greater than 0 as negative
        for i in nums:
            pos = abs(i) -1
            if nums[pos] > 0:
                nums[pos] *= -1

        #Looping over the length of the array to append values into output array
        for i in range(len(nums)):
            if nums[i] > 0:
                list.append(i+1)
        return list
        
#This problem finds the missing elements in the given array corresponding to the length of the array

#Time complexity - O(N)
#Space complexity - O(1)

nums = [4,3,2,7,8,2,3,1]
obj = Solution()
print(obj.findDisappearedNumbers(nums))