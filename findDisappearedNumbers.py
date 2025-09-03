'''
Solution 1 : with extra space 
We know the numbers in range [1,N]. We iterate over the array and keep removing that
element from the set if not already done. THe diasappered numbers will be in the set.
TIme complexity: O(N)
Space complexity: O(N)
'''
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        range_of_numbers = set()
        for i in range(1,len(nums)+1):
            range_of_numbers.add(i)

        for i in nums:
            if i in range_of_numbers:
                range_of_numbers.remove(i)
        
        return list(range_of_numbers)


'''
Solution 2 : Optimized on space 
First iteration:
    - we negate (if not already done) the element at nums[curr]_th index. This way
      we mark those elements in the array that appear. 
Second iteration:
    - now, we check which index elements are not negative. Those indexes as elements are
      present in my list
(Note): Range is [1-N] but we deal with 0-indexed array. 
TIme complexity: O(N)
Space complexity: O(1)
'''
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for i in range(len(nums)):
            if nums[abs(nums[i]) - 1]>0:
                nums[abs(nums[i]) - 1] = - nums[abs(nums[i]) - 1]
        
        answer = []
        for i in range(len(nums)):
            if nums[i]>0:
                answer.append(i+1) # 0th index arrays, but range from 1->N
        return answer