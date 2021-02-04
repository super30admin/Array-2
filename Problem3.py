# Time Complexity :O(n)
# Space Complexity :O(1.5n + 1)
# Any problem you faced while coding this :no
#GeeksForGeeks :  https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/

# Write a function to return minimum and maximum in an array. Your program should make the minimum number of comparisons.
#Less than 2n-2 which is original

#Main function where we define the array and call the method.
def main():
    nums = [1000, 11, 445, 1, 330, 3000]
    ans = getMaxMin(nums)
    print(ans)


#Core method.
def getMaxMin(nums):

    #Checking if nums is empty
    if not nums:
        return None

    #Taking length of array
    n = len(nums)

    #If there is just one item return that item as both min and max
    if n == 1:
        return [nums[0],nums[0]]

    #Then if the length is even we choose first two elements and the starting will be from third element i.e. index 2
    #We will do the comparisions in pairs of 2 now.

    if n%2 == 0:
        #Max of both will be maxVal and min of both will be minVal
        min_val = min(nums[0],nums[1])
        max_val = max(nums[0],nums[1])
        start = 2
    else:

        #If the length is odd, then assign both min and max to the first element.
        min_val,max_val= nums[0],nums[0]
        #And starting would be from 2nd element i.e index 2
        start = 1


    #Starting from the starting index and going till second last element for not going out of bounds.
    #Also we are moving in steps of 2 because we are comparing in pairs.


    for index in range(start,n-1,2):

        #Here the logic is, If new pair has element 'a' which is greater than element 'b' then
        # 'a' will be compared to the old max val and 'b' will be compared to old min val.
        if nums[index] < nums[index+1]:
            max_val = max(max_val,nums[index+1])
            min_val = min(min_val,nums[index])
        else:
            max_val = max(max_val, nums[index])
            min_val = min(min_val, nums[index+1])

    #Finally we return the array of max and min val.
    return [max_val,min_val]


if __name__ == '__main__':
    main()