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
            
            
            
        