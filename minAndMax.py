"""
Intuition: Take 2 values and compare them together and then compare it with the min and max.
Comparisions for each pair will be 3. 
Total Comparisions : 1.5 * N, where  N = number of elements
#####################################################################
"""
def getMinAndMax(nums):

    #Edge case
    if len(nums) == 0 or nums == None:
        return -1, -1

    minValue = nums[0]
    maxValue = nums[0]
    for index in range(0,len(nums)-1, 2):

        numOne = nums[index]
        numTwo = nums[index + 1]
        print(numOne, numTwo)
        if numOne > numTwo:
            minValue = min(numTwo, minValue)
            maxValue = max(numOne, minValue)

        else:
            minValue = min(numOne, minValue)
            maxValue = max(numTwo, minValue)            
    
    #If the array length is odd, 3 additional comparisions will be made. 
    #In this case total comparisions = 1.5N + 3
    if len(nums) % 2 != 0:
        minValue = min(nums[-1], minValue)
        maxValue = max(nums[-1], minValue) 

    return minValue, maxValue


print(getMinAndMax([4,4, 10,1,2,5,8]))