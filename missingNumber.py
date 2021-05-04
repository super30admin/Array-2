from typing import List
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
       # result:List[int]
        result=[]
        for idx,item in enumerate(nums):
                id =abs(item)-1
                if nums[id]>0:
                    nums[id]=-1*nums[id]

        for idx, item in enumerate(nums):
            if item >0:
                result.append(idx+1)




        return result


# Space:-O(1)
# time:-O(n)
if __name__ == '__main__':
    print(Solution().findDisappearedNumbers(nums=[4,3,2,7,8,2,3,1]))