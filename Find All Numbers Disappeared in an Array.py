class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        # check = [i+1 for i in range(len(nums))]
        # result = []
        
        # for i in range(1,len(nums) + 1):
        #     if check[(nums[i-1]) - 1] != 0:
        #         check[(nums[i-1]) -1] = 0
        
        # for i in range(len(check)):
        #     if check[i]!= 0:
        #         result.append(i+1)

        # return result
        result = []
        for i in range(len(nums)):
            index = abs(nums[i]) - 1
            if nums[index] > 0:
                nums[index] = nums[index] * (-1)

          
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i+1)  
            else:
                nums[i] = nums[i] * -1
                    
        return result    

        