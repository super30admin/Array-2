import sys
def maxMinOfArray(nums):

    minSize = sys.maxsize
    maxSize = -sys.maxsize - 1

    for i in nums:
        if i > maxSize:
            maxSize = i
            # print("maxSize", maxSize)
        if i < minSize:
            minSize = i
            # print("minSize", minSize)


    return maxSize, minSize


print(maxMinOfArray([1000, 11, 445, 1, 330, 3000]))