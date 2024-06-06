# TC - O(n)
# SC - O(1), no additional space used

# Approach

# traverse the array in pairs, instead of one by one approach
# compare which is greater between both the elements in the pair and then compare that max with the previous max element
# compare the min with the previous min element


import sys


class Solution:
    def findMinMax(self, A, N):

        maxElement = -sys.maxsize-1
        minElement = sys.maxsize

        if N == 1:
            return [A[0], A[0]]

        for i in range(N-1):
            if (A[i] > A[i+1]):
                maxElement = max(A[i], maxElement)
                minElement = min(A[i+1], minElement)
            else:
                maxElement = max(A[i+1], maxElement)
                minElement = min(A[i], minElement)

        return [maxElement, minElement]
