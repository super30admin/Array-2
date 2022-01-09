class Solution:
    def subOptimalfindDisappearedNumbers(self, nums: List[int]) -> List[int]:
        hash_ = {}
        r = []
        for i in nums:
            hash_[i] = 1
        for i in range(1, len(nums)+1):
            # print(i)
            if i not in hash_:
                r.append(i)
        return r
    
    def BruteForcefindDisappearedNumbers(self, nums: List[int]) -> List[int]:
        r = []
        for i in range(1, len(nums)+1):
            if i not in nums:
                r.append(i)
        return r
        
