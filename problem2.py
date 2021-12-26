# Time Complexity : O(n)     < 2*n-2 
# Space Complexity : o(1)

# Did this code successfully run on Leetcode : 
# YEs

# Any problem you faced while coding this : 

# Your code here along with comments explaining your approach


def solution(a):
    minv = 9999
    maxv =-1
    for i in range(0,len(a)-1,2):   #comparing in pairs
        if a[i] > a[i+1]:
            minv = min(minv,a[i+1])
            maxv = max(maxv,a[i])
        else:
            minv = min(minv,a[i])
            maxv =max(maxv,a[i+1])

    return minv, maxv

print(solution([4,3,1,6,5,9]))
print(solution([2,8,4,6,1,4,2]))