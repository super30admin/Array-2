#space complexity= o(1)
#time complexity= o(n)
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        length= len(nums)
        out=[]
        for i in nums:
            if(nums[abs(i)-1] > 0):
                nums[abs(i)-1] *= -1
        print(nums)
        for i in range(length):
            if(nums[i]>0):
                out.append(i+1)
        return out