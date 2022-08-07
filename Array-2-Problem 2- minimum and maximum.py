"""
S30 FAANMG Problem #32 {Easy }


Maximum and minimum of an array using minimum number of comparisons

Time Complexity : O(N)



Space Complexity : O(1)


Did this code successfully run on Leetcode : Yes
  


We are comparing the max and min simultabiouls with the current value and the next value in the array

  

@name: Rahul Govindkumar_RN27JUL2022
"""




arr = [-19, -3, 4,6,8,-7,1,-2]
mx = arr[0]
mn = arr[0]
for i in range (len(arr)-1):


    if arr[i] > arr[i + 1]:
        mx = max(mx, arr[i])
        mn = min(mn, arr[i+1])
    else:
        mx = max(mx, arr[i+1])
        mn = min(mn, arr[i])
        
print("maximum Number : ", mx)
print("Minimum Number : ", mn)