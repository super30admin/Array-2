"""
https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
FIRST APPROACH IS TO USE HASHMAP with key value pair as the number and boolean value true/false
-for every unique value encountered mark its value in hashmap as hashmap[number]=True. Then simply iterate from
 the hashmap and find all the False values and printing their keys - Time O(n), Space-O(n)
 - Second Approach is to iterate through all the numbers and for each number put the corresponding index to negative value of the existing number on that index
 for if if the first number econuntered is 1, we multiply array [0(i-1)]with -1 implying that in an ideal scenario arr[0] will be 1,  arr[1] will be 2 and so on
We iterate and find the positive values and print the here T(n)= O(n) and S(n) since we are not using any extra space
Leetcode: yes
"""

#
# class Solution:
#     def findDisappearedNumbers(self, nums):
        # dictionary = dict()
        # for i in range(1, len(nums) + 1):
        #     dictionary[i] = False
        # for i in range(1, len(nums) + 1):
        #     for j in range(0, len(nums)):
        #         if nums[j] == i:
        #             dictionary[i] = True
        #     count = 1
        # array = []
        # for i in dictionary.keys():
        #     if dictionary[i] == False:
        #         array.append(i)
        # return array

        # """brute force below"""

        # dictionary = dict()
        # for i in range(1, len(nums) + 1):
        #     dictionary[i] = False
        # for i in range(1, len(nums) + 1):
        #     for j in range(0, len(nums)):
        #         if nums[j] == i:
        #             dictionary[i] = True
        #     count = 1
        # array = []
        # for i in dictionary.keys():
        #     if dictionary[i] == False:
        #         array.append(i)
        # return array

        # """brute force O(n) below
        # """
        # hashmap=dict()
        # list=[]
        # for i in range(1, len(nums)+1):
        #     hashmap[i]=False
        # # for k in hashmap.
        # # hashmap
        #
        #
        #
        # for num in nums:
        #     # if num not in hashmap.keys():
        #     hashmap[num]=True
        #
        #
        # # print(hashmap)
        #
        # for k,v in hashmap.items():
        #     if v==False:
        #         list.append(k)
        #
        # return list


    # """
    # O(n) with 0(1)below
    # """
class Solution:
        def findDisappearedNumbers(self, nums):


            result = []
            for i in range(len(nums)):
                index = abs(nums[i]) - 1
                if nums[index] > 0:
                    nums[index] *= -1

            # for num in nums:
            #     if num >0:
            #         result.append(num+1)\
            for i in range(len(nums)):
                if nums[i] > 0:
                    result.append(i + 1)

            return result




nums = [4,3,2,7,8,2,3,1]
solve=Solution()
print(solve.findDisappearedNumbers(nums))
# nums = [4, 3, 2, 7, 8, 2, 3, 1]