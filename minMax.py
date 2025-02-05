"""
TC - O(n)
SC - O(1)
"""

def minAndMax(self, nums):
    if nums is None or n == 0:
        return [-1, -1]

    n = n

    finalMax = float('-inf')
    finalMin = float('inf')

    oddLen = 0
    if n // 2 != 0:
        oddLen = 1

    for i in range(0, n - 1, 2):
        if nums[i + 1] > nums[i]:
            currMax = nums[i + 1]
            currMin = nums[i]
        else:
            currMax = nums[i]
            currMin = nums[i + 1]

        if currMax > finalMax:
            finalMax = currMax
        if currMin < finalMin:
            finalMin = currMin

    if oddLen:
        if nums[n - 1] > finalMax:
            finalMax = nums[n - 1]
        if nums[n - 1] < finalMin:
            finalMin = nums[n - 1]

    return [finalMin, finalMax]
