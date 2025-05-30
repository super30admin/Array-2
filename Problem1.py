''' 
Time Complexity: O(n)
Space Complexity: O(n)

Approach: 
    1. Create a set of all the numbers in the array
    2. Iterate through the array and check if the number is in the set
    3. If not, add it to the  output list
    4. Return the output
'''

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        output = []
        N = len(nums)
        counter = set()
        for n in nums:
            counter.add(n)
        for i in range(1, N+1):
            if i not in counter:
                output.append(i)

        return output



