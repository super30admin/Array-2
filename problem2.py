// Time Complexity : 
      //  n is odd:    3*(n-1)/2  
      //  n is even:   1 Initial comparison for initializing min and max, and 3(n-2)/2 comparisons for rest of the elements  =  1 + 3*(n-2)/2 = 3n/2 -2
      
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

nums=[2,4,45,6,7,9,99,22]

if nums==None or len(nums)==0:
	return

n=len(nums)
if n==1:
	return nums[0],nums[0]

elif n%2==0:        //if length is even then min of first two numbers will be minimum and other will be maximum otherwise vice varsa
	if nums[0]<nums[1]:
		minimum,maximum=nums[0],nums[1]
	else:
		minimum,maximum=nums[1],nums[0]
	j=2
else:
	minimum,maximum=nums[0],nums[0]
	j=1



for i in range(j,len(nums)-1,2)://take two elements at a time from list and check which one is smaller and the compare smaller one with minimum to get new minimum and samw we will do for maximum
	if nums[i]<nums[i+1]:
		minimum=min(minimum,nums[i])
		maximum=max(maximum,nums[i+1])
	else:
		minimum=min(minimum,nums[i+1])
		maximum=max(maximum,nums[i])

print(maximum,minimum)






        
