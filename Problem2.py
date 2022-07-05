# Problem2
# Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison

'''
Time complexity O(N) #1.5*(N)

'''

'''
Approach : 
Check  two neibh elements which is less and high
then with that check if less is min and high is greater than max
'''

import math

def sol(arr):
    mini = math.inf
    maxi = -math.inf
    p1 = 0
    p2 = 1
    while(p1 < len(arr)-1 and p2 <len(arr)-1):
        if(p1>p2):
            mini = min(mini,p2)        
            maxi = max(maxi,p1)
        else :
            mini = min(mini,p1)
            maxi = maxi(maxi,p1)

    return mini,maxi

