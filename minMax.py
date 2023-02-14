# Author: Naveen US
# Titile: Find min max of an array.

# Time complexity: O(n)
# Space complexity: O(1)
# Did the code run on leetcode: Yes

# Disappeared elements are found in place.  

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
