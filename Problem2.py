# Time Complexity : O(n) (comparison: 1.5n - 2)
# Space Complexity : O(1) (If we don't consider returned list)
# Did this code successfully run on Leetcode : Not Available on LeetCode
# Three line explanation of solution in plain english:
# - If elements are odd assign first element as min and max. If elements are even compare first 2 element to assign min and max. Initialize index accordingly.
# - Run while loop until length of nums, compare two elements each time and update min and max accordingly.

# Your code here along with comments explaining your approach
class Solution:
def getMM(nums):
    # Store length of array, if it is 1 than assign both of them as max and min
    n = len(nums)
    # Check length of array, if it is 2 than comparing 2 element to assign max and min accordingly
    if n % 2 == 0:
        if nums[0] > nums[1]:
            mx = nums[0]
            mn = nums[1]
        else: 
            mx = nums[1]
            mn = nums[0]
        # initialize index variable
        index = 2
    else:
        mx = nums[0]
        mn = nums[0]
        # initialize index variable
        index = 1

#   RUn for loop till index is less than length
    while index < n -1:
        # compare number and it's next number
        if nums[index] > nums[index+1]:
            # assign max and min accordingly
            if nums[index] > mx:
                mx = nums[index]
            if nums[index+1] < mn:
                mn = nums[index+1]
        else:
            # assign max and min accordingly
            if nums[index+1] > mx:
                mx = nums[index+1]
            if nums[index] < mn:
                mn = nums[index]
        #skip next elemnt 
        index += 2

    return (mn, mx)

def main():
    inp = [1,5,7,9,3]
    print(getMM(inp))


if __name__ == "__main__":
    main()