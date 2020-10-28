# To solve this problem  in O(n) time complexity I used hash map. First I store all the numbers from 1 to n and then assign them to 0. But whn I re-traverse the array I increase the count in hashmap. The rquird answer is keys with 0 valu
# Time Complexity: O(n)
#Space Complexity: O(2n)
def missingNum(arr):
    n = len(arr)
    elemMap = dict()
    result = list()
    for i in range(len(arr)+1):
        elemMap[i] = 0

    print(elemMap)
    for i in range(len(arr)):
        elemMap[arr[i]] = elemMap[arr[i]] + 1

    print(elemMap)
    
    for key in elemMap:
        if elemMap[key] == 0:
            result.append(key)
    return result[1:]

arr = [4,3,2,7,8,2,3,1]
res = missingNum(arr)
print(res)
