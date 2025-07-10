'''
448. Find All Numbers Disappeared in an Array
'''

# Time Complexity : O(n)
# The time complexity is O(n) because we traverse the array once to mark the indices and
# then traverse it again to find the missing numbers. Each operation inside the loops is O(1),
# leading to a linear time complexity overall.
# Space Complexity : O(1)
# The space complexity is O(1) because we are modifying the input array in place and
# not using any additional data structures that grow with the input size. The result list is
# the only additional space used, but it does not depend on the size of the input array
# and is not counted in the space complexity analysis.
# Did this code successfully run on Leetcode : Yes, it runs successfully on Leetcode and for the test cases provided.
# Any problem you faced while coding this : Yes, I faced issues with taking it to the optimized solution where O(n) time complexity is required and O(1) space complexity is required.

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        # Brute Force Approach
        # Time Complexity: O(n^2)
        # Space Complexity: O(1)
        '''
        Intuition:
        - For each number in the array, check if it exists in the range 1 to n.
        - If a number is missing, add it to the result list.
        - This approach is inefficient for large arrays due to nested loops.
        Example:
        nums = [4,3,2,7,8,2,3,1]
        Output: [5, 6]
        Approach:
        - Iterate through each number in the array. If a number is not found in the range 1 to n, add it to the result list.
        '''
        # n = len(nums) # humne array ki length n li hai (we stored the length of the array in n)
        # result = [] # humne result ka ek empty list banaya hai (we created an empty list for the result)
        # for i in range(1, n + 1): # humne 1 se lekar n tak ke numbers ko check karna hai (we need to check numbers from 1 to n)
        #     flag = False # humne ek flag banaya hai jo check karega ki number exist karta hai ya nahi (we created a flag to check if the number exists or not)
        #     for j in range(n): # humne ek aur loop banaya hai jo array ke har element ko check karega aur jth index par ith number ko dekhega (we created another loop to check each element of the array and see if the ith number exists at the jth index)
        #         if nums[j] == i: # agar nums[j] i ke barabar hai to flag ko True kar do (if nums[j] is equal to i, set the flag to True)
        #             flag = True # humne flag ko True kar diya hai kyunki number exist karta hai (we set the flag to True because the number exists)
        #             break # loop se bahar aa jao (break out of the loop)
        #     if not flag: # agar flag False hai to iska matlab number exist nahi karta (if the flag is False, it means the number does not exist)
        #         result.append(i) # humne result mein i ko add kar diya hai (we added i to the result list)
        # return result # humne result ko return kar diya hai (we returned the result list)
        
        # Optimized Approach
        # Time Complexity: O(nlog n)
        # Space Complexity: O(1)
        '''
        • First, we sort the array to make all duplicates and missing numbers easier to find.
        •Then we check each number from 1 to n against the sorted array.
        •If a number isn’t matched in the array, we add it to the result.
        '''
        # n = len(nums)  # Store the length of the array in n
        # result = []  # Create an empty list for the result
        # nums.sort()  # Sort the array to make it easier to find missing numbers
        # i = 0 # Initialize index i to 0
        # for num in range(1, n + 1):  # Check numbers from 1 to n
        #     if i >= n or nums[i] > num:
        #         # If i is out of bounds or the current number in nums is greater than num,
        #         # it means num is missing in the array
        #         result.append(num)
        #     else:
        #         # If the current number in nums is equal to num, move to the next index
        #         while i < n and nums[i] == num: # Check for duplicates
        #             i += 1 # Move to the next index
        # return result  # Return the list of missing numbers
        
        # 3rd Approach
        '''
        • We first put all numbers from the array into a set for quick lookup.
        • Then we go from 1 to n and check which number isn’t in the set.
        • If a number is missing, we add it to our result list.
        '''
        # n = len(nums)  # Store the length of the array in n
        # result = [] # Create an empty list for the result
        # num_set = set(nums)  # Create a set from the nums array for quick lookup
        # for i in range(1, n + 1):
        #     if i not in num_set:
        #         # If i is not in the set, it means it's a missing number
        #         result.append(i)
        # return result  # Return the list of missing numbers
        # # This approach has a time complexity of O(n) and space complexity of O(n) due to the set.

        # 4th Approach
        '''
        • We use each number in the array to mark its corresponding index negative.
        • If any index remains positive, it means that number was missing from the array.
        • So we collect all those index+1 values as the result.
        '''
        n = len(nums)  # Store the length of the array in n
        result = []  # Create an empty list for the result
        for i in range(n):
            # Use the absolute value of nums[i] to find the index to mark
            index = abs(nums[i]) - 1
            # Mark the number at that index as negative to indicate it has been seen
            if nums[index] > 0:
                nums[index] = -nums[index]
        # Now, we check which indices are still positive
        for i in range(n):
            if nums[i] > 0:
                # If the number at index i is positive, it means i+1 is missing
                result.append(i + 1)
        return result  # Return the list of missing numbers
        # Dry Run:
        # nums = [4,3,2,7,8,2,3,1]
        # n = 8
        # result = []
        # i = 0, index = 3, nums[3] = 7
        # nums = [4,3,2,-7,8,2,3,1]
        # i = 1, index = 2, nums[2] = 2
        # nums = [4,3,-2,-7,8,2,3,1]
        # i = 2, index = 1, nums[1] = 3
        # nums = [4,-3,-2,-7,8,2,3,1]
        # i = 3, index = 6, nums[6] = 3
        # nums = [4,-3,-2,-7,8,-2,2,-3,1]
        # i = 4, index = 7, nums[7] = 1
        # nums = [4,-3,-2,-7,-8,-2,2,-3,1]
        # i = 5, index = 1, nums[1] = -3
        # nums = [4,-3,-2,-7,-8,-2,2,-3,1]
        # i = 6, index = 2, nums[2] = -2
        # nums = [4,-3,-2,-7,-8,-2,2,-3,1]
        # i = 7, index = 0, nums[0] = 4
        # nums = [-4,-3,-2,-7,-8,-2,2,-3,1]
        # Now we check which indices are still positive
        # i = 0, nums[0] < 0
        # i = 1, nums[1] < 0
        # i = 2, nums[2] < 0
        # i = 3, nums[3] < 0
        # i = 4, nums[4] < 0
        # i = 5, nums[5] < 0
        # i = 6, nums[6] > 0, result = [7]
        # i = 7, nums[7] < 0, result = [7, 8]
        # Final result = [5, 6]
        # This approach has a time complexity of O(n) and space complexity of O(1) since we are modifying the input array in place.
        # Note: The input array nums is modified in place, so if you need to keep the original array intact, you should make a copy of it before using this approach.




# Dry Run:
        # nums = [4,3,2,7,8,2,3,1]
        # n = 8
        # result = []
        # i = 1, flag = False
        # j = 0, nums[0] != 1
        # j = 1, nums[1] != 1
        # j = 2, nums[2] != 1
        # j = 3, nums[3] != 1
        # j = 4, nums[4] != 1
        # j = 5, nums[5] != 1
        # j = 6, nums[6] != 1
        # j = 7, nums[7] != 1
        # flag = False, result = [1]
        # i = 2, flag = False
        # j = 0, nums[0] != 2
        # j = 1, nums[1] != 2
        # j = 2, nums[2] == 2
        # flag = True, result = [1]
        # i = 3, flag = False
        # j = 0, nums[0] != 3
        # j = 1, nums[1] == 3
        # flag = True, result = [1]
        # i = 4, flag = False
        # j = 0, nums[0] == 4
        # flag = True, result = [1]
        # i = 5, flag = False
        # j = 0, nums[0] != 5
        # j = 1, nums[1] != 5
        # j = 2, nums[2] != 5
        # j = 3, nums[3] != 5
        # j = 4, nums[4] != 5
        # j = 5, nums[5] != 5
        # j = 6, nums[6] != 5
        # j = 7, nums[7] != 5
        # flag = False, result = [1, 5]
        # i = 6, flag = False
        # j = 0, nums[0] != 6
        # j = 1, nums[1] != 6
        # j = 2, nums[2] != 6
        # j = 3, nums[3] != 6
        # j = 4, nums[4] != 6
        # j = 5, nums[5] != 6
        # j = 6, nums[6] != 6
        # j = 7, nums[7] != 6
        # flag = False, result = [1, 5, 6]
        # i = 7, flag = False
        # j = 0, nums[0] != 7
        # j = 1, nums[1] != 7
        # j = 2, nums[2] != 7
        # j = 3, nums[3] == 7
        # flag = True, result = [1, 5, 6]
        # i = 8, flag = False
        # j = 0, nums[0] != 8
        # j = 1, nums[1] != 8
        # j = 2, nums[2] != 8
        # j = 3, nums[3] != 8
        # j = 4, nums[4] == 8
        # flag = True, result = [1, 5, 6]
        # Final result = [5, 6] 