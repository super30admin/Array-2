# // Time Complexity :O(3n/2) => O(n)  
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes

nums=[160,270,3,4,5,140,1]
i=0
max1=nums[0]
min1=nums[0]
while(i<len(nums)):
    a=nums[i]
    if(i+1<len(nums)):
        b=nums[i+1]
    else:
        b=a
    if(a>b):
        max1=max(a,max1)
        min1=min(b,min1)
    else:
        max1=max(b,max1)
        min1=min(a,min1)
    i+=2
print("The maximum value is: "+str(max1)+"\nThe minimum value is: "+str(min1))