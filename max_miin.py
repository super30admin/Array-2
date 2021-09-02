# // Time Complexity :O(n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach




arr=[2,5,3,1,6,2,8]
maxi=arr[0]
mini=arr[1]
for i in range(1,len(arr)-1):
    if arr[i]<arr[i+1]:
        if arr[i]<mini:
            mini=arr[i]
        if arr[i+1]>maxi:
            maxi=arr[i+1]
    else:
        if arr[i+1]<mini:
            mini=arr[i+1]
        if arr[i+1]>maxi:
            maxi=arr[i+1]

print(mini)
print(maxi)
