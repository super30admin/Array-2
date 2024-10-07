#T.C = O(n) S.C = O(1)
class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        result=[]
        m = len(nums)

        for i in range(m):
            num=nums[i]
            idx=abs(num)-1
            if(nums[idx]>0):
                nums[idx] = nums[idx] * -1

        for i in range(m):
            if(nums[i]<0):
                nums[i] *= -1
            else:
                result.append(i+1)

        return result
        