'''
448 Find all numbers disappeared in an array
https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/

Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

Solution:
1. Values as Index: We use the values of the array as the index, go to that index and negate the value at that index if it is positive.
Scan the input array A from left to right. For each index value A[i], we set:
    index = abs(A[i]) - 1
    A[index] = A[index]*(-1), if A[index] > 0

Why do we need to subtract 1 from abs(A[i])? Why couldn't we simply take index = abs(A[i])?
Ans: Because in an array of size N, containing values [1,N], the indices range from 0 to N-1. Hence, to be able to use the values as indices, we need to subtract 1 from the values. In short, [1,N] - 1 = [0,N-1].
Eg. If N = 3, and array A = [1,3,1]
If we use index = abs(A[1]) = 3, then such an index doesn't exist in the array (i.e., A[3] doesn't exist). Hence, we must subtract 1 from abs(A[1]) to get 2 which is a valid index.

Then we scan the array from left to right and note the index of those elements which are still positive. Adding one to those indices, we get the missing values.

https://www.youtube.com/watch?v=Yl3js4yr-BM

Time: O(N), Space: O(1)
'''
def find_missing_values(nums):
    N = len(nums)
    if N == 0:
        return []

    for i in range(N):
        index = abs(nums[i]) - 1
        if nums[index] > 0:
            nums[index] = nums[index]*(-1)

    missing = []
    for i in range(N):
        if nums[i] > 0:
            missing.append(i+1)
    return missing


def run_tests():
    tests = [([4,3,2,7,8,2,3,1], [5,6]), ([4,3,2,3,5,6,1,1], [7,8]), ([1,1], [2]), ([1], [])]

    for test in tests:
        nums, ans = test[0], test[1]
        print(f"\nnums = {nums}")
        res = find_missing_values(nums)
        print(f"Missing Values = {res}")
        passed = (ans == res)
        assert passed == True, f"Test case failed"
        print(f"Pass: {passed}")

    print(f"\nDONE")

run_tests()