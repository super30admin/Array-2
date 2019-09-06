#Time limit exceeded   - Time complexity was O(n)
#Accepted on leetcode
# no doubts

#explaination:
#we traverse through the array  which has element . and make the element in index (element-1) negative.
#then we traverse again and give the index+1 of elemetns whose value is greater than 1

# class Solution(object):
#     def findDisappearedNumbers(self, nums):
#         """
#         :type nums: List[int]
#         :rtype: List[int]
#         """
        #brute force method
        # result=[]
        # n=len(nums)
        # for val in range(1,len(nums)+1):
        #     if val not in nums:
        #         result.append(val)
        # return result

#********* the new code****
#time complexity is o(n)
#ran on leetocde
#no doubts
class Solution(object):
    def findDisappearedNumbers(self, nums):
                """
                :type nums: List[int]
                :rtype: List[int]
                """
        result = []
        for i in range(len(nums)):
            index = abs(nums[i]) - 1 #taking the index by subtracting it by 1
            if nums[index] > 0: #check if the number is already marked negative
                nums[index] = nums[index] * -1 #if not, make it negative
        for i in range(len(nums)):
            if nums[i] > 0: #check for numbers greater than 0
                result.append(i + 1) #return i+1
        return result