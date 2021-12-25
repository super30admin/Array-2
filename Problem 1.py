# Time: O(n)
# Space: O(1)
class Solution(object):
    def findDisappearedNumbers(self, num):
        """
        :type nums: List[int]
        :rtype: List[int]
        """   
        ans = []
        for i in range(len(num)):
            if num[abs(num[i]) -1] > 0:
                num[abs(num[i]) -1] *= -1
        for i in range(len(num)):
            if num[i] > 0:
                ans.append(i+1)
        return ans
                
                
        
