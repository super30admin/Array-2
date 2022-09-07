class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        a = set(nums) #set for nums in array
        b = set(i for i in range (1,len(nums)+1)) #set for n consecutive nums starting from 1
        res = list(b-a) #complement of intersection of both sets
        return res