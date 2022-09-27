'''
Time Complexity: O(N)
Space Complexity: O(1)
'''
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        arr_len = len(nums)
        op = []
        for i in nums:
            index = abs(i) % arr_len
            if(nums[index]>0):
                nums[index] = 0-nums[index]
        print(nums)
        for i in range(0, arr_len):
            if(i==0 and nums[i]>0):
                op.append(arr_len)
            elif(nums[i]>0):
                op.append(i)
        return op
        