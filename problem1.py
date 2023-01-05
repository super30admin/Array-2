#time O(n)
#space O(n)
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        list1=[]
        s=set(nums)
        for i in range(1,len(nums)+1):
            if i in s:
                continue
            else:
                list1.append(i)
        return list1
        