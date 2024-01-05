'''

Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced

Your code here along with comments explaining your approach:
Taking a pair and calculating minimum and maximum. This way, less than (2N -2) operations are needed to compute the min and max.

'''

def min_max(nums:list[int]):
    mini = float('inf')
    maxi = float('-inf')
    i = 0
    length = len(nums)

    while i < length:
        if i == length - 1:
            mini = min(nums[i],mini)
            maxi = max(nums[i],maxi)
            i += 1

        else:
            if nums[i] > nums[i+1]:
                maxi = max(nums[i],maxi)
                mini = min(nums[i+1],mini)
            else:
                maxi = max(nums[i+1],maxi)
                mini = min(nums[i],mini)
            i+=2

    return [mini,maxi]

def main():
    print(min_max([3, 5, 4, 1, 9]))

if __name__ == "__main__":
    main()