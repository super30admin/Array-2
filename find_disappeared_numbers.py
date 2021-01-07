# Approach: Brute Force method would be to get the range (1 to N) and with each value check if its in the nums list, if not that element is missing
# Time Complexity: Time limit exceeded, not an optimal way of finding it

# Optimized approach 1: Using hashmaps
# Iterate over the array and fill a hashmap with all occurrences of the numbers
# Iterate over the range now and check if the number in order( 1 to N) is in the hashmap if not return it
# Time : O(N)
# Space : O(N)


# Brute Force - Time Limit exceeded
def findDisappearedNumbers(nums):

        n = len(nums)
        res = []
        
        for i in range(1, n+1):
            if not i in nums:
                res.append(i)
                
        return res
    

# Approach using hashmaps
# can be done with set instead

def findDisappearedNumbers(nums):
    
    lastSeen = {}
    result = []
    
    for idx, val in enumerate(nums):
        if val in lastSeen:
            lastSeen[val] += 1
            
        else:
            lastSeen[val] = 1
            
    for num in range(1, len(nums)+1):
        if num not in lastSeen:
            result.append(num)
            
    return result



# Approach to optimize space to O(1) - Technique: Temporary State Change
# Key here is to find the index corresponding to a value. For example if val = 4, the index representing 4 would be val - 1, ie 3
# This holds true since it is given [1, N]
# Once we find this index, we change the state of the number to negative. We do this only for vals > 0 so as to not reverse sign of already reversed number, (in case of duplicates)
# Iterate over the array again and check which numbers are positive and get the corresponding number as index + 1
# If not reverse array back to original so as to not mutate array

def missingElement(array):
    
    result = []
    
    for num in array:
        index = abs(num) - 1 # getting corresponding index
        if array[index] > 0: # to avoid reversing duplicates back to positive
            array[index] *= -1
            
 
            
    for i in range(len(array)):
        if array[i] > 0:
            missing_number = i + 1
            result.append(missing_number)
            
        else:
            array[i] *= -1
            
    
    
    
    
arr = [4,3,2,7,8,2,3,1]
print(missingElement(arr))
            
            
            
        