class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        if not nums:
            return None
        solution = []
        
        for num in nums:
            if nums[abs(num)-1]>0:
                nums[abs(num)-1]*=-1
                
        for index,num in enumerate(nums):
            if num>0:
                solution.append(index+1)
                
        return solution
        
#  Approach is to preserve state== what we are doing here is using the same array to spit the result as the input one was
#  Specifically, we have saved the converted each seen numbers corresponding index to the negative number of what was already there at that
#  index, this allows for converting back and returning the numbers which remain positive after the iteration.

# time complexity is O(n)
        
