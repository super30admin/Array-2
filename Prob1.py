#Time complexity: O(n)   
#Space complexity: O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        res = []
        #first pass
        # we are marking the element as present by going to the index where it should be and multiplying the element there by -1
        for idx,el in enumerate(nums):
            # index of the element is the absolute value -1
            i = abs(el)-1
            # if not negative, make it negative because seen now
            if nums[i]>0:
                nums[i] *= -1
        # in the second pass, we return elements to normal state and the elements which remained positive, their index+1 are missing in nums
        for idx,el in enumerate(nums):
            if el<0:
                nums[idx] *= -1
            else:
                res.append(idx+1)
        return res


    