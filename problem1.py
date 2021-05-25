class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for i in range(len(nums)):
            val = abs(nums[i])-1
            if nums[val]<0:
                continue
            else:
                nums[val] = -1*(nums[val])
        arr = []
        print(nums)
        for i in range(len(nums)):
            if nums[i]>0:
                arr.append(i+1)

        return arr

        
