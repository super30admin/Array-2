#time complexity: O(n)
#space complexity: O(n)
#ran on leetcode: yes
#loop through the numbers and find out the absolute value. Denote the presence of this 
#particular number by making the number at index=this_number - 1 a negative one. 
#loop back through the array, if a number is positive then the number equivalent to this 
#current index + 1 is missing so add it to the answer list.
class Solution:
    def findDisappearedNumbers(self, nums):
        L=[]
        for i in range(len(nums)):
            ind=abs(nums[i])-1
            if(nums[ind]>0):
                nums[ind]=-nums[ind]
        
        for i in range(len(nums)):
            if(nums[i]>0):
                L.append(i+1)
        return L
s=Solution()
nums = [4,3,2,7,8,2,3,1]
print(s.findDisappearedNumbers(nums))