#Time complexity: O(n)
#Space complexity: O(1)
#Leetcode: Yes

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        n= len(nums)
        arr= list()
        for i in range(n):
            index = nums[i]
            if (nums[i] < 0):
                index= nums[i] * -1
            if(nums[index - 1]> 0):
                nums[index - 1] = nums[index - 1] * -1
            # print(nums)
        
        for i in range(n):
            if(nums[i] > 0):
                arr.append(i+1)
            else:
                nums[i]= -1 * nums[i]
        
        return arr