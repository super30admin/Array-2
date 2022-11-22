#space complexity: O(1)
#time complexity: O(n)
#comparisions: less than 2*(N-2)
#a number that is maximum cannot be minimum. Similarly a number that is minimum cannot be maximum. using this idea when a number 
# is maximum, we can avoid checking it for minimum.
nums=[5,6,1,2,3,8,9]
minimum=nums[0]
maximum=nums[0]
for i in range(1,len(nums)):
    if(nums[i]>maximum):
        maximum=nums[i]
    elif(nums[i]<minimum):
        minimum=nums[i]
print(maximum,minimum)
