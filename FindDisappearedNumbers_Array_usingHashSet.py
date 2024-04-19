# TC: O(n)
# SC: O(n)

# Logic to find missing elements from array using Hashset method. Array's length [n] == range of elements [1...n]

class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        #Python set having unique elements from input nums
        set = self.useHashset(nums)
        result=[]

        #Iterate through the range of elements
        for i in range(1,len(nums)+1):
            #Append missing elements from the set into result array to return from this method
            if i not in set:
                result.append(i)

        return result

    #create a python set which has unique elements
    def useHashset(self,nums):
        myset = set(nums)

        return myset
        
obj = Solution()
input = [4,3,2,7,8,2,3,1]
disappeared_numbers_1 = obj.findDisappearedNumbers(input)
print(disappeared_numbers_1)