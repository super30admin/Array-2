#O(N) TIME AND O(1) SPACE
def minMax(array):
    length = len(array)
    if (length % 2) == 0:
        minimum = min(array[0],array[1])
        maximum = max(array[0],array[1])
        i = 2
    else:
        minimum,maximum = array[0],array[0]
        i = 1
    
    while i < (length - 1):
        if array[i] < array[i+1]:
            maximum = max(maximum,array[i+1])
            minimum = min(minimum,array[i])
        else:
            maximum = max(maximum,array[i])
            minimum = min(minimum,array[i+1])
        i+=2
    return [minimum,maximum]




