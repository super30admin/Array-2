# Time Complexity : O(n)
# Space Complexity : O(1)

def compare(arr):
    
    min = 0
    max = 0 
    arr[0] = 0

    i = 1

    while i + 1 < len(arr):

        # check if the current value is less the value after it

        if arr[i] < arr[i + 1]:

            # check if min is greater than current, make the current as min
            if min > arr[i]:
                min = arr[i]

            # else make the ahead value as the max

            if max < arr[i + 1]:
                max = arr[i + 1]

        else:

            if min > arr[i + 1]:
                min = arr[i + 1]

            if max < arr[i]:
                max = arr[i]

        i = i + 2
                
    if i + 1 == len(arr):

        if min > arr[i]:
            min = arr[i]

        if max < arr[i]:
            max = arr[i]
            
    return min, max

if __name__ == '__main__':
    
    arr = [2, -4, 5, 6, 7, -8, 3]
    min, max = compare(arr)
    print('Minimum value is', min, '\n'  'Maximum value is', max)