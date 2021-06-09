class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        :time complexity: O(n)
        :space complexity: O(1) - since it is given in question "You may assume the returned list does not count as extra space"
        """
        # Idea to keep original array to keep track of the numbers visited
        #  Since all the numbers are positive intergers, for every number visited we mark the presence of that number by negating the number at the index equal to the current number
        for i in range(len(nums)):
            temp=abs(nums[i])-1
            if nums[temp]>0:
                nums[temp]*=(-1)
            
        result=[]
        for i in range(len(nums)):
            if nums[i]>0:
                result.append(i+1)
        return result
    