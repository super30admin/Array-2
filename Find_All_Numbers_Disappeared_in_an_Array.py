#time complexity: O(n)
#Space complexity O(1)

class Solution:
    def findDisappearedNumbers(self, nums: list[int]) -> list[int]:
        if nums is None or len(nums) == 0:
            return []
        result = []  #creating a new list
        for i in range(len(nums)):
            index = abs(nums[i]) - 1  #subtracting 1 from nums[i]
            if nums[index] > 0:
                nums[index] = nums[index] * -1 #nums[index] contains the answer after subtracting nums[i] -1
        for i in range(len(nums)): #again iterating the list to find all the non-negative values
            if nums[i] > 0:  
                result.append(i + 1)

            else:
                nums[i] = nums[i] * -1 #getting the original non-negative array back

        return result



        
                
