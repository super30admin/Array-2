class Solution:
    ########### Method 1 using set ###########
    # Time Complexity : O(N)
    # Space Complexity : O(N)
    # def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
    #     mySet = set()
    #     for num in nums:
    #         mySet.add(num)
    #         result = []
    #     for i in range(1,len(nums)+1):
    #         if i not in mySet:
    #             result.append(i)
    #     return result


  
    ########### Method 2 ###########
    # Time Complexity : O(N)
    # Space Complexity : O(1)
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for i in range(len(nums)):
            # Find the index where the value of the element should be placed
            new_idx = abs(nums[i]) - 1
            # Mark the element at the found index as visited by making it negative
            if nums[new_idx] > 0:
                nums[new_idx] *= -1
        
        # empty list to store the result
        result = []
        
        # Iterate through the modified list
        for i in range(len(nums)):
            # If an element is positive, it means its index+1 is missing in the original list
            if nums[i] > 0:
                result.append(i + 1)   
        return result


            
