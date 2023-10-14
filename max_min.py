# TC : O(n)
# SC : O(1)
# Question - find max and min from an input array with minimal number of comparisions
# Approach - Compare the element in pairs. This way we cut down the number of iterations by half

def find_max_min(nums):
    max_ele = float('-inf')
    min_ele = float('inf')
    for i in range(len(nums)-1):
        if (nums[i] > nums[i+1]):
            max_ele = max(max_ele, nums[i])
            min_ele = min(min_ele, nums[i+1])
        else:
            max_ele = max(max_ele, nums[i+1])
            min_ele = min(min_ele, nums[i])
    print("Max and Min element in the Array : ", max_ele, min_ele)

def main():
    print(find_max_min([22, 14, 8, 17, 35, 3]))
    print(find_max_min([3, 5, 4, 1, 9]))


if __name__ == '__main__':
    main()