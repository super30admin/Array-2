# time complexity : O(n)
# space complexity : O(n)
nnums = {}
def find_disappered(nums):
    for num in nums:
        nnums[num] = 1

    result = []

    for num in range(1, len(nums)+1):
        if num not in nnums:
            result.append(num)

    return result

if __name__ == "__main__":
    nums = [4,3,2,7,8,2,3,1]
    print(find_disappered(nums))
