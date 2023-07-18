class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        #using extra storage as a boolean array
        # bool_arr=[True for i in range(1,len(nums)+2)]
        # l=[]
        # for i in nums:
        #     bool_arr[i]=False
        # for i in range(1,len(bool_arr)):
        #     if(bool_arr[i]):
        #         l+=[i]
        # return l
        
        # with out using any other extra space.
        l=[]
        for i in nums:
            d=abs(i)-1
            if(nums[d]>0):
                nums[d]=nums[d]*-1
        for i in range(len(nums)):
            if(nums[i]>0):
                l.append(i+1)
        return l