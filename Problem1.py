#Arrays-2
#Problem 1 : https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
#Test Cases Passed on LeetCode
#Time Complexity-O(N)
#Space Complexity-O(1)

class Solution:
    def findDisappearedNumbers(self, nums):
    
        #Approach:Take list from 1 to n and Negate the numbers already present in the nums and then just take the positive numbers
        #initialise a result array
        result=[]
        #Traverse the list -nums
        for i in range(len(nums)):
            temp=nums[i]
            #if element at index is negative , make it positive since we need to negate the number at that particular index-1
            if temp<0:
                temp*=-1
            #go to the index and make it negative
            #we are using temp-1 since indexes are from 0-len(nums)-1 and numbers would range from 1-n
            #to make sure that we have the number in the list we mark the nums[temp-1] as negative
            if nums[temp-1]>0:
                nums[temp-1]*=-1
       #once we are done with this, we'll check the possitive elements in the list , their indexes+1 will be the         numbers not in the list
        for i in range(len(nums)):
            if nums[i]>0:
                result.append(i+1)
        return result
sol=Solution()
nums = [4,3,2,7,8,2,3,1]
print(sol.findDisappearedNumbers(nums))            
        
#eg          4  3   2   7   8   2   3   1
#first step:temp-1=4-1=3rd position element we will make it negative
#0  1   2   3   4   5   6   7
#4  3   2   -7  8   2   3   1
#in the above case we mark 7 as -ve since it is the 3rd(4-1)to take make sure that 4 exists in the current list

#second step:temp-1=3-1=2=2nd position element we will make it negative
#0  1   2   3   4   5   6   7
#4  3   -2  -7  8   2   3   1



        
        















