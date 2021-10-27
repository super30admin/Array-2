#Time complexity O(n) and space complexity O(n)
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        # storing array values in set for unique elements
        s=set(nums)
        print(s)
        #Result array
        a=[]
        # Traversing through the loop and logic is our index is 1 greater than the values so if the index + 1 element is not there that means its missing and returning those elements in list
        i=0
        while i<len(nums):
            if i+1 not in s:
                a.append(i+1)
            i+=1    
        return a
