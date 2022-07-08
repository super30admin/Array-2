# Time Complexity: O(n) -- Since we are parsing the array to compare max and min values with each index
# Space Complexity: O(1) -- No additional space apart from 2 variables min and max being used
# Number of comparisons: 1 + 2 * (N -2)
#Code:

def min_max_elements_array(nums):
    n = len(nums)
    if n == 1:
        return nums[0] , nums[0] # Return min and max as same val
    
    if nums[0] > nums[1]: # Assigning min and max values from 1st and 2nd element
        minimum = nums[1]
        maximum = nums[0]
    else:
        maximum = nums[1]
        minimum = nums[0]
    
    for i in range(2,n): # Check if current element value is less than min and max, then update values accordingly
        if nums[i] < minimum:
            minimum = nums[i]
        elif nums[i] > maximum:
            max = nums[i]
        else:
            continue
    
    return minimum, maximum

arr = [1000, 11, 445, 1, 330, 3000]
minimum, maximum = min_max_elements_array(arr)
print(minimum, maximum)


# Approach: We first check if length of array is 1, if it is 1 we return same min and max values. 
# If length > 1, we compare 1st and 2nd element and assign min and max values accordingly.
# We then iterate over an array from 3rd element till last element, we check for each element whether the current element is less than min then update min.
# If current element is greater than max then update max value otherwise jump to the next element.


# Approach with less iterations (1.5 * N) comparisons. [Initially it was 4 comaprisons between 2 elements , now it has reduced to 3 comparisons between 2 elements]
# Code:
def min_max_elements_array(nums):
    n = len(nums)
    maximum = minimum = nums[0]
    if n == 1:
        return nums[0] , nums[0] # Return min and max as same val
    
    if n%2 == 0: # Checking if total elements are odd/ even
        x = n
    else:
        x = n-1
        flag = 1
    
    for i in range(0,x,2): # Check if current element value is less than next element, check values accordingly. Step size will be 2
        if nums[i] > nums[i+1]:
            maximum = max(maximum, nums[i])
            minimum = min(minimum,nums[i+1])
        else:
            maximum = max(maximum, nums[i+1])
            minimum = min(minimum,nums[i])
    
    if flag == 1: # If odd elements are there, then check min and max with last elements
        if nums[n-1] > maximum:
            maximum = nums[n-1]
        elif nums[n-1] < minimum:
            minimum = nums[n-1]
    
    return minimum, maximum
            

arr = [10, 11, 445, 35, 330, 1, 0]
minimum, maximum = min_max_elements_array(arr)
print(minimum, maximum)

# Approach: We initially compare the current element with the next element and then if current element is greater then we compare it with maximum 
#           and other one with minimum value. If no. of elements are odd then we compare the last element with minimum and maximum obtained till n - 1 elements. 