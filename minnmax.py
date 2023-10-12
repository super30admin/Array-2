# Time Complexity : O(1.5n)=O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# we are going to compare in pairs to reduce time complexity. We first initialize first element in array as both min n max if lenght of array os odd
# if lenght of array is even, we take the min element as the min among arr[0] and arr[1].
# then in a loop till lenght-1, we check the min n max in pairs and update min, max accordingly. 
class pair:
    def __init__(self):
        self.min = None
        self.max = None

def getMinMax(arr):
     
    n = len(arr)
    if(n % 2 == 0):
        if arr[0] < arr[1]:
            mn = arr[0]
            mx = arr[1]
        else:
            mn = arr[1]
            mx = arr[0]
        i = 2
    else:
        mx = mn = arr[0]
        i = 1

    while(i < n - 1):
        if arr[i] < arr[i + 1]:
            mx = max(mx, arr[i + 1])
            mn = min(mn, arr[i])
        else:
            mx = max(mx, arr[i])
            mn = min(mn, arr[i + 1])
          
        i += 2
     
    return (mx, mn)

if __name__ =='__main__':
     
    arr = [1000, 11, 445, 1, 330, 3000]
    mx, mn = getMinMax(arr)
    print("Minimum element is", mn)
    print("Maximum element is", mx)
     