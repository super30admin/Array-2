#find missing elements dissappeared in an array
#leetcode solution accepted
#space complexity:O[1]
#time complexity:O(n) where n is the length of nums array
#approach is iterate through thhe array and at each index negate ex n[i]-1 the value at the index should be made negative
# at the end the numbers which remain positive are the ones where the value was missing
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for i in range(len(nums)):#iterating through array
            temp = abs(nums[i])-1#creating a temp variable to store 
            if nums[temp]>0:#if the value at the index is positve make it neg
                nums[temp]*=-1
        res = []#initalize the result op
        for i in range(1,len(nums)+1):#iterate from one to len n +1
            if nums[i-1]>0: #if prev is greater than  or positive append
                res.append(i)
        return res
            