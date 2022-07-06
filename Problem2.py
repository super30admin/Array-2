def findMinAndMax(nums):
    max = min = nums[0]
    for i in range(1, len(nums)):
        if nums[i] > max:
            max = nums[i]
        elif nums[i] < min:
            min = nums[i]
 
    print('Minimum element: ', min)
    print('Maximum element: ', max)
 
 
if __name__ == '__main__':
    nums = [10, 17, 20, 43, 95, 16]
    findMinAndMax(nums)
 
