class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        n = len(nums)
        myset = set(nums)
        nums_1 = []

        for i in range(1,n+1):
            if i not in myset:
                nums_1.append(i)
       
        return nums_1