'''
To solve this problem in O(n) time and without any extra space, I changed the state of the elements temporarily to negative.
Initially I caluclated the index and iterated through the array to change the state at that index
while iterating again through the state changed array, if the elemet is positive I stored the index+1 value which is the missing elemnt.
If the element is negative changed it to positive.
'''
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        result = []
        n = len(nums)
        # finding the index and changing the state
        for i in range(n):
            index = abs(nums[i]) - 1
            if nums[index] > 0:
                nums[index] *= -1
        # adding the missing elements to the array and changing the state back
        for i in range(n):
            if nums[i] > 0:
                result.append(i+1)
            else:
                nums[i] *= -1
        return result

'''
Time Complexity: O(n)
Since we iterating on the same array twice, the time complexity would be O(2n) -> O(n) average time complexity
Space Complexity: O(1)
We are not using any extra space, we are just temporarity modifying the same array and changing it back to its original state
'''