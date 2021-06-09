class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        missing = []
        for i in range(len(nums)):
            if nums[abs(nums[i])-1]>0:
                nums[abs(nums[i])-1]*=-1
        for i in range(len(nums)):
            if nums[i]>0:
                missing.append(i+1)
            else:
                nums[i]*=-1
        return missing
    
    """ Time complexity-O(n)
    Space complexity - O(1) as we are not using any extra space other than output"""
    
        # map = dict()
        # num=[]
        # for i in nums:
        #     map[i]=True
        # for i in range(len(nums)):
        #     if i+1 not in map:
        #         num.append(i+1)
        # return num
            
       """ Time complexity-O(n)
    Space complexity - O(n) as we are using hashset to store keys"""