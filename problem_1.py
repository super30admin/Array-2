# TC: O(n)
# SC: O(1)

def findDisappearedNumbers(nums):
    ans = []
    for i in range(len(nums)):
        x = abs(nums[i])
        if nums[x - 1] > 0:
            nums[x - 1] *= -1
    for i in range(len(nums)):
        if nums[i] > 0:
            ans.append(i+1)
    
    return ans


input = [4,3,2,7,8,2,3,1]
print(findDisappearedNumbers(input))

input = [1,1]
print(findDisappearedNumbers(input))