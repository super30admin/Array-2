class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        if not nums:
            return []
        
        res=[]
        index=-1
        #from evry element, subtract 1 and treat it as index >>then go to that index, negate its value in nums. If value is already negative dont do anything
        for i in range(len(nums)):
            index=abs(nums[i])-1
            if nums[index]>0:
                nums[index]=-nums[index]
        #print(nums)
        #whatever positive elements are left in nums, add +1 to their indices and add to your result array
        for i in range(len(nums)):
            if nums[i]>0:
                res.append(i+1)
        return res
        

#O(N)
#O(1) **state change** in the same input array