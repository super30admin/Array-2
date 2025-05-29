"""
Approach: use variables and update the min and secondMin
t.c.=> O(n)
s.c. => O(1)
"""

def main():
    nums=[3, 5, 4, 1, 9]
    n = len(nums)
    maxN, minN = nums[0], nums[0]
    for i in range(1, n):
        if i == n - 1:
            if nums[i] > maxN:
                maxN = nums[i]
            if nums[i] < minN:
                minN = nums[i]
        elif nums[i] > nums[i + 1]:
            maxN = max(maxN, nums[i])
            minN = min(minN, nums[i + 1])
        else:
            maxN = max(maxN, nums[i + 1])
            minN = min(minN, nums[i])
    print(maxN, minN)
if __name__ == "__main__":
    main()
        
