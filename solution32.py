#Time Complexity:O(n)
#Space Complexity:O(1)
nums=[3,30,9,11,3,14,16,21,27,15,2]
if len(nums)==0:            #if the arry is null return 0,0
    print(0,0)
i=0
low=99999                   #initializing low to maximum value
high=-99999                 #initializing high to minimum value
while i<len(nums)-1:        #for even length array(except last element in odd length array)
    if nums[i]<nums[i+1]:   #find low and high in pairs of current and next element
        l=nums[i]
        h=nums[i+1]
    else:
        l=nums[i+1]
        h=nums[i]
    if l<low:               #update low if current low is low than global low
        low=l
    if h>high:              #update high if current high is higher than global high
        high=h
    i+=2                    #consider the next pair
if i==len(nums)-1:          #for the last element in odd length array compare with global 
    if nums[i]<low:         #low and high and update respectively
        low=nums[i]
    if nums[i]>high:
        high=nums[i]
print(low,high)