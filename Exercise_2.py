#Time Complexity : O(N), N being the length of the array. 
#Space Complexity : O(1), because not creating extra space of greater than constant. 
#Did this code successfully run on Leetcode : Did not find a leetcode link. 
#Any problem you faced while coding this : Forgot to return result. That's about it. 

#Your code here along with comments explaining your approach in three sentences only
''' Initialize a min and max variable and update them if lower or high is found while
looping through the array. 
'''
def min_and_max(array):
    # if array doesn't have values. 
    if len(array)==0:
        return [None, None]
    else:
        #initialize and loop.
        minimum = array[0]
        maximum = array[0]
        for i in range(1, len(array)):
            if array[i]>maximum:
                maximum = array[i]
            if array[i]<minimum:
                minimum = array[i]
        return [minimum, maximum]


array = [3,1,6,9,3,4,5,66]
result = min_and_max(array)
print(result)